package vn.titv.webbansach_backend.service;

import vn.titv.webbansach_backend.entity.HinhAnh;

public interface HinhAnhService {
    public HinhAnh findHinhAnhById(int maHinhAnh);
    public HinhAnh saveHinhAnh(HinhAnh hinhAnh);
}
