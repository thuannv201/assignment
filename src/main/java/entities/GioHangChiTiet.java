package entities;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GioHangChiTiet")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GioHangChiTiet {

    @Id
    @Column(name = "IdGioHang")
    private UUID idGioHang;

    @Id
    @Column(name = "IdChiTietSP")
    private UUID idChiTietSP;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    @ManyToOne
    @JoinColumn(name = "IdGioHang", referencedColumnName = "Id")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private ChiTietSP chiTietSP;

}
