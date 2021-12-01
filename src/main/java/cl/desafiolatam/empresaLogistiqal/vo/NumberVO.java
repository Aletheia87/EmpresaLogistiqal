package cl.desafiolatam.empresaLogistiqal.vo;


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
public class NumberVO extends GenericVO {

	long valor;

	public NumberVO(long valor, String mensaje, String codigo) {
		super(mensaje, codigo);
		this.valor = valor;
	}
	

}
