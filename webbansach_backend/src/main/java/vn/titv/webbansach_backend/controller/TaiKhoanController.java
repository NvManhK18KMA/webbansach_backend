package vn.titv.webbansach_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.titv.webbansach_backend.entity.NguoiDung;
import vn.titv.webbansach_backend.entity.ThongBao;
import vn.titv.webbansach_backend.Endpoints.JwtResponse;
import vn.titv.webbansach_backend.Endpoints.LoginRequest;
import vn.titv.webbansach_backend.service.JwtService;
import vn.titv.webbansach_backend.service.TaiKhoanService;
import vn.titv.webbansach_backend.service.UserService;

@RestController
@RequestMapping("/tai-khoan")
public class TaiKhoanController {
    private final TaiKhoanService taiKhoanService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    @Autowired
    public TaiKhoanController(TaiKhoanService taiKhoanService,
                              AuthenticationManager authenticationManager,
                              UserService userService,
                              JwtService jwtService) {
        this.taiKhoanService = taiKhoanService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtService = jwtService;
    }
//        @CrossOrigin(origins = "http://localhost:3000")
    @CrossOrigin(origins = "*")
    @PostMapping("/dang-ky")
    public ResponseEntity<?> dangKyNguoiDung(@Validated @RequestBody NguoiDung nguoiDung){
        ResponseEntity<?> response = taiKhoanService.dangKyNguoiDung(nguoiDung);
        return  response;
    }

    @GetMapping("/kich-hoat")
    public  ResponseEntity<?> kichHoatTaiKhoan(@RequestParam String email , @RequestParam String maKichHoat){
        ResponseEntity<?> response = taiKhoanService.kichHoatTaiKhoan(email , maKichHoat);
        return  response;
    }

@PostMapping("/dang-nhap")
public ResponseEntity<?> dangNhap(@RequestBody LoginRequest loginRequest) {
    try {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        if (authentication.isAuthenticated()) {
            final String jwt = jwtService.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new JwtResponse(jwt));
        } else {
            return ResponseEntity.badRequest().body(new ThongBao("Xác thực không thành công", "Đăng nhập lại"));
        }
    } catch (BadCredentialsException exception) {
        return ResponseEntity.badRequest().body(new ThongBao("Tên đăng nhập hoặc mật khẩu không chính xác", "Đăng nhập lại"));
    } catch (LockedException | DisabledException exception) {
        return ResponseEntity.badRequest().body(new ThongBao("Tài khoản đã bị khóa hoặc bị vô hiệu hóa", "Liên hệ quản trị viên"));
    } catch (AuthenticationException exception) {
        return ResponseEntity.badRequest().body(new ThongBao("Xác Thực Không Thành Công", "Đăng Nhập Lại"));
    }
}

}
