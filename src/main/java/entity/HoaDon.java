package entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HoaDon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HoaDon {

    @Id
    @Column(name = "Id", unique = true, length = 36)
    private String Id;

    @Column(name = "IdKH")
    private String IdKH;

    @Column(name = "IdNV")
    private String IdNV;

    @Column(name = "Ma", unique = true, length = 20)
    private String Ma;

    @Column(name = "NgayTao")
    private Date NgayTao;

    @Column(name = "NgayThanhToan")
    private Date NgayThanhToan;

    @Column(name = "NgayShip")
    private Date NgayShip;

    @Column(name = "NgayNhan")
    private Date NgayNhan;

    @Column(name = "TinhTrang")
    private int TinhTrang;

    @Column(name = "TenNguoiNhan", length = 50)
    private String TenNguoiNhan;

    @Column(name = "DiaChi", length = 100)
    private String DiaChi;

    @Column(name = "Sdt", length = 30)
    private String Sdt;

}
