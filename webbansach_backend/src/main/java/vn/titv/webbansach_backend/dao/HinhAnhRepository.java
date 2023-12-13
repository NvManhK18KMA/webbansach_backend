package vn.titv.webbansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import vn.titv.webbansach_backend.entity.DonHang;
import vn.titv.webbansach_backend.entity.HinhAnh;
import vn.titv.webbansach_backend.service.HinhAnhService;

@RepositoryRestResource(path = "hinh-anh")
public interface HinhAnhRepository extends JpaRepository<HinhAnh, Integer> {
    public HinhAnh findHinhAnhByMaHinhAnh(int maHinhAnh);
}
