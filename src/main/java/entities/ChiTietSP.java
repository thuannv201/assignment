package entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSP {
    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID()")
    private String id;

    @Column(name = "IdSP", columnDefinition = "UNIQUEIDENTIFIER")
    private String idSP;

    @Column(name = "IdNsx", columnDefinition = "UNIQUEIDENTIFIER")
    private String idNsx;

    @Column(name = "IdMauSac", columnDefinition = "UNIQUEIDENTIFIER")
    private String idMauSac;

    @Column(name = "IdDongSP", columnDefinition = "UNIQUEIDENTIFIER")
    private String idDongSP;

    @Column(name = "NamBH", columnDefinition = "INT DEFAULT NULL")
    private Integer namBH;

    @Column(name = "MoTa", columnDefinition = "NVARCHAR(50) DEFAULT NULL")
    private String moTa;

    @Column(name = "SoLuongTon", columnDefinition = "INT")
    private Integer soLuongTon;

    @Column(name = "GiaNhap", columnDefinition = "DECIMAL(20,0) DEFAULT 0")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", columnDefinition = "DECIMAL(20,0) DEFAULT 0")
    private BigDecimal giaBan;

}
