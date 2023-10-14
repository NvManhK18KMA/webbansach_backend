package vn.titv.webbansach_backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.titv.webbansach_backend.entity.DonHang;

import java.beans.JavaBean;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang , Integer> {
}
