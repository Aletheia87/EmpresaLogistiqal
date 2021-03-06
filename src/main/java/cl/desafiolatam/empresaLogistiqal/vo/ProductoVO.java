package cl.desafiolatam.empresaLogistiqal.vo;

import java.util.List;

import cl.desafiolatam.empresaLogistiqal.model.Producto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductoVO extends GenericVO {
	
	List<Producto> productos;

	public ProductoVO(List<Producto> productos, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.productos = productos;
	}

}
