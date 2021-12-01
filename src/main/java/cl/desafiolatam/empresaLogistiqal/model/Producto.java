package cl.desafiolatam.empresaLogistiqal.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="producto")
public class Producto {
	
	@Id
	@Column(unique = true, nullable = false)
	private Integer codigo; //único,
	@Column(unique = true, nullable = false)
	private String nombre; // único,
	private Integer precio;
	private Integer stock; 

	
}
