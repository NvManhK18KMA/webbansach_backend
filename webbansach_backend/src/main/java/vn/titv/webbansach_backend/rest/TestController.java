package vn.titv.webbansach_backend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.titv.webbansach_backend.dao.ChiTietDonHangRepository;
import vn.titv.webbansach_backend.entity.ChiTietDonHang;

@Controller
public class TestController {

    private ChiTietDonHangRepository chiTietDonHangRepository;

    @Autowired
    public TestController(ChiTietDonHangRepository chiTietDonHangRepository) {
        this.chiTietDonHangRepository = chiTietDonHangRepository;
    }

    @GetMapping("/")
    public void test(){
        ChiTietDonHang chiTietDonHang = new ChiTietDonHang();
    }
}
