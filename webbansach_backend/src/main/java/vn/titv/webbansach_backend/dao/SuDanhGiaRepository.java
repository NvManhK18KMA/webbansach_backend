package vn.titv.webbansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import vn.titv.webbansach_backend.entity.DonHang;
import vn.titv.webbansach_backend.entity.SuDanhGia;
@RepositoryRestResource(path = "su-danh-gia")
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia, Long> {
}
