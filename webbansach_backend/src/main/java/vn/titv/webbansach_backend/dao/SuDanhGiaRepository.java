package vn.titv.webbansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.titv.webbansach_backend.entity.DonHang;
import vn.titv.webbansach_backend.entity.SuDanhGia;
@Repository
public interface SuDanhGiaRepository extends JpaRepository<SuDanhGia, Long> {
}