package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVien {

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

    @Column(name = "GioiTinh", length = 10)
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi", length = 100)
    private String diaChi;

    @Column(name = "Sdt", length = 30)
    private String sdt;

    @Column(name = "MatKhau", length = 65535)
    private String matKhau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCH", referencedColumnName = "id", insertable = false, updatable = false)
    private CuaHang cuaHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCV", referencedColumnName = "id", insertable = false, updatable = false)
    private ChucVu chucVu;

    @Column(name = "IdGuiBC")
    private UUID idGuiBC;

    @Column(name = "TrangThai")
    private int trangThai;
}
