//package vn.titv.webbansach_backend.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import vn.titv.webbansach_backend.dao.HinhAnhRepository;
//import vn.titv.webbansach_backend.dao.SachRepository;
//import vn.titv.webbansach_backend.entity.HinhAnh;
//import vn.titv.webbansach_backend.entity.NguoiDung;
//import vn.titv.webbansach_backend.entity.Sach;
//import vn.titv.webbansach_backend.service.HinhAnhServiceImpl;
//import vn.titv.webbansach_backend.service.SachService;
//import vn.titv.webbansach_backend.service.SachServiceImpl;
//
//@RestController
//@RequestMapping("/hinh-anh")
//public class HinhAnhController {
//    private SachServiceImpl sachService;
//    private HinhAnhServiceImpl hinhAnhService;
//
//    @Autowired
//    public HinhAnhController(SachServiceImpl sachService, HinhAnhServiceImpl hinhAnhService) {
//        this.sachService = sachService;
//        this.hinhAnhService = hinhAnhService;
//    }
//
//
//    @CrossOrigin(origins = "*")
//    @PostMapping("/dang-ky")
//    public ResponseEntity<?> dangKyNguoiDung(@Validated @RequestBody HinhAnh hinhAnh , int maSach){
//        Sach sach = sachService.getSachById(maSach);
//        hinhAnh.setSach(sach);
//        ResponseEntity<?> response = hinhAnhService.saveHinhAnh(hinhAnh);
//        return response;
//    }
//}
