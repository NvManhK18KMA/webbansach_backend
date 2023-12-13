package vn.titv.webbansach_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.titv.webbansach_backend.dao.NguoiDungRepository;
import vn.titv.webbansach_backend.entity.NguoiDung;
import vn.titv.webbansach_backend.entity.ThongBao;

import java.util.UUID;

@Service
public class TaiKhoanService {
    private NguoiDungRepository nguoiDungRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private EmailService emailService;

    @Autowired
    public TaiKhoanService(NguoiDungRepository nguoiDungRepository, BCryptPasswordEncoder passwordEncoder, EmailService emailService) {
        this.nguoiDungRepository = nguoiDungRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
    }
    public NguoiDung test(){
        return nguoiDungRepository.findByTenDangNhap("a");
    }
    public ResponseEntity<?> dangKyNguoiDung(NguoiDung nguoiDung){
        //kiem tra ten dang nhap
        if(nguoiDungRepository.existsByTenDangNhap(nguoiDung.getTenDangNhap())){
            return ResponseEntity.badRequest().body(new ThongBao("Tên Đăng Nhập Đã Tổn Tại" , "Chọn Tên Khác"));
        }
        if(nguoiDungRepository.existsByEmail(nguoiDung.getEmail())){
            return ResponseEntity.badRequest().body(new ThongBao("Email Đã Tổn Tại" , "Email Khác"));
//            return ResponseEntity.badRequest().body("Email Đã Tồn Tại");

        }
        nguoiDung.setMatKhau(passwordEncoder.encode(nguoiDung.getMatKhau()));
        nguoiDung.setMaKichHoat(taoMaKichHoat());
        nguoiDung.setDaKichHoat(false);

        //gui mail
        NguoiDung nguoiDungDaDangKy = nguoiDungRepository.save(nguoiDung);
        guiEmailKichHoat(nguoiDung.getEmail() , nguoiDung.getMaKichHoat());
        return ResponseEntity.ok(new ThongBao("Đăng Ký Thành Công" , "Bạn Có Thể Đăng Nhập"));
    }

    private String taoMaKichHoat(){
        //tao ma ngau nhien
        return UUID.randomUUID().toString();
    }

    private void guiEmailKichHoat(String email, String maKichHoat) {
        String subject = "Kích Hoạt Tài Khoản WebBanSach";
        String text = "Vui lòng nhập mã kích hoạt sau để kích hoạt tài khoản có email: " + email + " :<br/><h1>" + maKichHoat + "</h1>";
        text += "<br/> Click vào đường dẫn sau để kích hoạt : ";
        String url = "http://localhost:3000/kich-hoat/" + email + "/" + maKichHoat; // Sửa lỗi đường dẫn
        text += "<br/> <a href=\"" + url + "\">" + url + "</a>";
        emailService.sendMessage("webbansach@email.com", email, subject, text);
    }



    public ResponseEntity<?> kichHoatTaiKhoan (String email , String maKichHoat){
        System.out.println("im here");
        NguoiDung nguoiDung = nguoiDungRepository.findByEmail(email);
        if(nguoiDung == null){
            return ResponseEntity.badRequest().body(new ThongBao("người dùng không tồn tại " , "thử lại email khác"));
        }
        if(nguoiDung.isDaKichHoat()){
            return ResponseEntity.badRequest().body(new ThongBao("tài khoản đã dược kích hoạt " , "hãy đăng nhập"));
        }
        if(maKichHoat.equals(nguoiDung.getMaKichHoat())){
            nguoiDung.setDaKichHoat(true);
            nguoiDungRepository.save(nguoiDung);
            return  ResponseEntity.ok(new ThongBao("Kích Hoạt Thành Công" , "Hãy Đăng Nhập"));
        }else {
            return ResponseEntity.badRequest().body(new ThongBao("Mã Kích Hoạt Không Chính Xác " , "Nhập Lại"));
        }
    }
}
