package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "KhachHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", unique = true, length = 36)
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "Ten", length = 30)
    private String ten;

    @Column(name = "TenDem", length = 30)
    private String tenDem;

    @Column(name = "Ho", length = 30)
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Column(name = "ThanhPho", length = 50)
    private String thanhPho;

    @Column(name = "QuocGia", length = 50)
    private String quocGia;

    @Column(name = "MatKhau", length = 2147483647)
    private String matKhau;
    
    public void setNgaySinh(String yourDateStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.ngaySinh = dateFormat.parse(yourDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getYourDate() {
        return ngaySinh;
    }

    public void merge(KhachHang khachHang) {
        if (khachHang.getMa() != null) {
            this.ma = khachHang.getMa();
        }
        if (khachHang.getTen() != null) {
            this.ten = khachHang.getTen();
        }
        if (khachHang.getTenDem() != null) {
            this.tenDem = khachHang.getTenDem();
        }
        if (khachHang.getHo() != null) {
            this.ho = khachHang.getHo();
        }
        if (khachHang.getNgaySinh() != null) {
            this.ngaySinh = khachHang.getNgaySinh();
        }
        if (khachHang.getSdt() != null) {
            this.sdt = khachHang.getSdt();
        }
        if (khachHang.getDiaChi() != null) {
            this.diaChi = khachHang.getDiaChi();
        }
        if (khachHang.getThanhPho() != null) {
            this.thanhPho = khachHang.getThanhPho();
        }
        if (khachHang.getQuocGia() != null) {
            this.quocGia = khachHang.getQuocGia();
        }
        if (khachHang.getMatKhau() != null) {
            this.matKhau = khachHang.getMatKhau();
        }
    }

}
