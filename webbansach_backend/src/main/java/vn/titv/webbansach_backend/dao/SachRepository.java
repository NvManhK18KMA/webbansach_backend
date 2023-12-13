package vn.titv.webbansach_backend.dao;

import org.apache.coyote.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import vn.titv.webbansach_backend.entity.DonHang;
import vn.titv.webbansach_backend.entity.Sach;
@RepositoryRestResource(path = "sach")
public interface SachRepository extends JpaRepository<Sach, Integer> {
    Page<Sach> findByTenSachContaining(@RequestParam("tenSach") String tenSach, Pageable pageable);

    Page<Sach> findByDanhSachTheLoai_MaTheLoai(@RequestParam("maTheLoai") int maTheLoai, Pageable pageable);

    Page<Sach> findByTenSachContainingAndDanhSachTheLoai_MaTheLoai(@RequestParam("tenSach") String tenSach, @RequestParam("maTheLoai") int maTheLoai, Pageable pageable);
    Page<Sach> findBySoLuongBetween(
            @RequestParam("min") int min,
            @RequestParam("max") int max,
            Pageable pageable);

    public  Sach findSachByMaSach(int maSach);
}

//eyJhbGciOiJIUzI1NiJ9.eyJ4IjoiQWJjIiwiaXNBZG1pbiI6dHJ1ZSwic3ViIjoibWFpbnVzZXIiLCJpYXQiOjE3MDE1MzE4ODEsImV4cCI6MTcwMTUzMzY4MX0.2LCC0KnRwn6dSgrysz67Oz0ZmJprurq-doBvkp8vjB4
//eyJhbGciOiJIUzI1NiJ9.eyJ4IjoiQWJjIiwiaXNBZG1pbiI6dHJ1ZSwic3ViIjoibWFpbnVzZXIiLCJpYXQiOjE3MDE1MzE4ODEsImV4cCI6MTcwMTUzMzY4MX0.2LCC0KnRwn6dSgrysz67Oz0ZmJprurq-doBvkp8vjB4
