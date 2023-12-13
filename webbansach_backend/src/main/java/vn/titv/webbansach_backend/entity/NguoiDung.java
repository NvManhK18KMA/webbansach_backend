package vn.titv.webbansach_backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_nguoi_dung", length = 256)
    private int maNguoiDung;

    @Column(name = "ho_dem", length = 256)
    private String hoDem;

    @Column(name = "ten", length = 256)
    private String ten;

    @Column(name = "ten_dang_nhap", length = 256)
    private String tenDangNhap;

    @Column(name = "mat_khau", length = 512)
    private String matKhau;

    @Column(name = "gioi_tinh")
    private char gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "dia_chi_mua_hang")
    private String diaChiMuaHang;

    @Column(name = "dia_chi_giao_hang")
    private String diaChiGiaoHang;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            }
    )
    private List<SuDanhGia> danhSachSuDanhGia;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            }
    )
    private List<SachYeuThich> danhSachSachYeuThich;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "nguoidung_quyen",
            joinColumns = @JoinColumn(name = "ma_nguoi_dung"),
            inverseJoinColumns = @JoinColumn(name = "ma_quyen")
    )
    private List<Quyen> danhSachQuyen;

    @OneToMany(mappedBy = "nguoiDung", fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.REFRESH
            }
    )
    private List<DonHang> danhSachDonHang;

    @Column(name = "da_kich_hoat")
    private boolean daKichHoat;
    @Column(name = "ma_kich_hoat")
    private String maKichHoat;
    @Column(name = "avatar" , columnDefinition = "LONGTEXT")
    @Lob
    private String avatar;

    public NguoiDung(String hoDem, String ten, String tenDangNhap, String matKhau, char gioiTinh, String email, String soDienThoai, String diaChiMuaHang, String diaChiGiaoHang, List<SuDanhGia> danhSachSuDanhGia, List<SachYeuThich> danhSachSachYeuThich, List<Quyen> danhSachQuyen, List<DonHang> danhSachDonHang, boolean daKichHoat, String maKichHoat) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChiMuaHang = diaChiMuaHang;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.danhSachSuDanhGia = danhSachSuDanhGia;
        this.danhSachSachYeuThich = danhSachSachYeuThich;
        this.danhSachQuyen = danhSachQuyen;
        this.danhSachDonHang = danhSachDonHang;
        this.daKichHoat = daKichHoat;
        this.maKichHoat = maKichHoat;
    }

    public NguoiDung() {

    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getHoDem() {
        return hoDem;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public char getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(char gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public List<SuDanhGia> getDanhSachSuDanhGia() {
        return danhSachSuDanhGia;
    }

    public void setDanhSachSuDanhGia(List<SuDanhGia> danhSachSuDanhGia) {
        this.danhSachSuDanhGia = danhSachSuDanhGia;
    }

    public List<SachYeuThich> getDanhSachSachYeuThich() {
        return danhSachSachYeuThich;
    }


    public void setDanhSachSachYeuThich(List<SachYeuThich> danhSachSachYeuThich) {
        this.danhSachSachYeuThich = danhSachSachYeuThich;
    }

    public List<Quyen> getDanhSachQuyen() {
        return danhSachQuyen;
    }

    public void setDanhSachQuyen(List<Quyen> danhSachQuyen) {
        this.danhSachQuyen = danhSachQuyen;
    }

    public List<DonHang> getDanhSachDonHang() {
        return danhSachDonHang;
    }

    public void setDanhSachDonHang(List<DonHang> danhSachDonHang) {
        this.danhSachDonHang = danhSachDonHang;
    }

    public boolean isDaKichHoat() {
        return daKichHoat;
    }

    public void setDaKichHoat(boolean daKichHoat) {
        this.daKichHoat = daKichHoat;
    }

    public String getMaKichHoat() {
        return maKichHoat;
    }

    public void setMaKichHoat(String maKichHoat) {
        this.maKichHoat = maKichHoat;
    }
}
