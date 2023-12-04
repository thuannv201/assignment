package entity;

import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CuaHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID()")
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "Ten", length = 30)
    private String ten;

    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Column(name = "ThanhPho", length = 30)
    private String thanhPho;

    @Column(name = "QuocGia", length = 30)
    private String quocGia;
    
    @OneToMany(mappedBy = "cuaHang", fetch = FetchType.LAZY)
    private Set<NhanVien> nhanViens;

    public void merge(CuaHang cuaHang) {
        this.ma = cuaHang.getMa();
        this.ten = cuaHang.getTen();
        this.diaChi = cuaHang.getDiaChi();
        this.thanhPho = cuaHang.getThanhPho();
        this.quocGia = cuaHang.getQuocGia();
    }
}
