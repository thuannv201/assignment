package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ChucVu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChucVu {
	
	@Id
	@Column(name = "Id", unique = true, length = 36)
	private String Id;
	
	@Column(name = "Ma", unique = true, length = 20)
	private String Ma;

	@Column(name = "Ten", length = 30)
	private String Ten;

}
