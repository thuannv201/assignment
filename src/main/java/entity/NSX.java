package entity;

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
@Table(name = "NSX")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID()")
    private UUID id;

    @Column(name = "Ma", unique = true, length = 20)
    private String ma;

    @Column(name = "Ten", length = 30)
    private String ten;

    public void merge(NSX nsx) {
        this.ma = nsx.getMa();
        this.ten = nsx.getTen();
    }
}
