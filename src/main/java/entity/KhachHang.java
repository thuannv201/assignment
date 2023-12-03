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
@Table(name = "KhachHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang {
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

    @Column(name = "NgaySinh")
    private Date NgaySinh;

    @Column(name = "Sdt", length = 30)
    private String Sdt;

    @Column(name = "DiaChi", length = 100)
    private String DiaChi;

    @Column(name = "ThanhPho", length = 50)
    private String ThanhPho;

    @Column(name = "QuocGia", length = 50)
    private String QuocGia;

    @Column(name = "MatKhau", length = 2147483647)
    private String MatKhau;

}
