package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVien {

    @Id
    @Column(name = "Id", unique = true, length = 36)
    private String Id;

    @Column(name = "Ma", unique = true, length = 20)
    private String Ma;

    @Column(name = "Ten", length = 30)
    private String Ten;

    @Column(name = "TenDem", length = 30)
    private String TenDem;

    @Column(name = "Ho", length = 30)
    private String Ho;

    @Column(name = "GioiTinh", length = 10)
    private String GioiTinh;

    @Column(name = "NgaySinh")
    private Date NgaySinh;

    @Column(name = "DiaChi", length = 100)
    private String DiaChi;

    @Column(name = "Sdt", length = 30)
    private String Sdt;

    @Column(name = "MatKhau", length = 65535)
    private String MatKhau;

    @Column(name = "IdCH")
    private UUID IdCH;

    @Column(name = "IdCV")
    private UUID IdCV;

    @Column(name = "IdGuiBC")
    private UUID IdGuiBC;

    @Column(name = "TrangThai")
    private int TrangThai;
}
