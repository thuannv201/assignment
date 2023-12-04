package entity;

import java.math.BigDecimal;
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
@Table(name = "ChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID()")
    private UUID id;

    @Column(name = "IdSP", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID idSP;

    @Column(name = "IdNsx", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID idNsx;

    @Column(name = "IdMauSac", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID idMauSac;

    @Column(name = "IdDongSP", columnDefinition = "UNIQUEIDENTIFIER")
    private UUID idDongSP;

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
    
    public void setIdSp (String idSP) {
        this.idSP = UUID.fromString(idSP);
    }

    public void setIdNsx (String idNsx) {
        this.idNsx = UUID.fromString(idNsx);
    }

    public void setIdMauSac (String idMauSac) {
        this.idMauSac = UUID.fromString(idMauSac);
    }

    public void setIdDongSP (String idDongSP) {
        this.idDongSP = UUID.fromString(idDongSP);
    }

    public void merge(ChiTietSP entity) {
        this.idSP = entity.getIdSP() != null ? entity.getIdSP() : this.idSP;
        this.idNsx = entity.getIdNsx() != null ? entity.getIdNsx() : this.idNsx;
        this.idMauSac = entity.getIdMauSac() != null ? entity.getIdMauSac() : this.idMauSac;
        this.idDongSP = entity.getIdDongSP() != null ? entity.getIdDongSP() : this.idDongSP;
        this.namBH = entity.getNamBH() != null ? entity.getNamBH() : this.namBH;
        this.moTa = entity.getMoTa() != null ? entity.getMoTa() : this.moTa;
        this.soLuongTon = entity.getSoLuongTon() != null ? entity.getSoLuongTon() : this.soLuongTon;
        this.giaNhap = entity.getGiaNhap() != null ? entity.getGiaNhap() : this.giaNhap;
        this.giaBan = entity.getGiaBan() != null ? entity.getGiaBan() : this.giaBan;
    }

}
