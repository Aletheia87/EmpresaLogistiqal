package cl.desafiolatam.empresaLogistiqal.service;

import cl.desafiolatam.empresaLogistiqal.model.Producto;
import cl.desafiolatam.empresaLogistiqal.vo.NumberVO;
import cl.desafiolatam.empresaLogistiqal.vo.ProductoVO;

public interface IProductoService {
	
	public ProductoVO getAllProductos();
	public ProductoVO findByNombre(String nombre);
	public ProductoVO add(Producto producto);
	public ProductoVO update(Producto producto);
	public ProductoVO delete(Producto producto);
	public ProductoVO findByCodigo(Integer codigo);
	public ProductoVO getPage(Integer pagina, Integer cantidad);
	public NumberVO getPageCount(long registrosPorPagina) ;

}
