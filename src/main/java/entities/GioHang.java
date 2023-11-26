package entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GioHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GioHang {
    @Id
    @Column(name = "Id")
    private UUID id;

    @Column(name = "IdKH")
    private UUID idKH;

    @Column(name = "IdNV")
    private UUID idNV;

    @Column(name = "Ma", unique = true)
    private String ma;

    @Column(name = "NgayTao")
    private LocalDate ngayTao;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "NgayShip")
    private LocalDate ngayShip;

    @Column(name = "NgayNhan")
    private LocalDate ngayNhan;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

}
