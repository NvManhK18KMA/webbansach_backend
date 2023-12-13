package vn.titv.webbansach_backend.service;

import org.springframework.stereotype.Service;
import vn.titv.webbansach_backend.dao.SachRepository;
import vn.titv.webbansach_backend.entity.Sach;

@Service
public class SachServiceImpl implements SachService{
    private SachRepository sachRepository;

    @Override
    public Sach getSachById(int maSach) {
        return sachRepository.findSachByMaSach(maSach);
    }
}
