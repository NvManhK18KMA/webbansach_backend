package vn.titv.webbansach_backend.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import vn.titv.webbansach_backend.entity.NguoiDung;

public interface UserService extends UserDetailsService {
    public NguoiDung findByUsername(String tenDangNhap);
}
