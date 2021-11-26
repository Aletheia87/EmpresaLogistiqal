package cl.desafiolatam.empresaLogistiqal.model;

import javax.persistence.Entity;

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
public class Producto {
	
	private String codigo; //único,
	private String nombre; // único,
	private Integer precio;
	private Integer stock;

}
