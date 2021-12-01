package cl.desafiolatam.empresaLogistiqal.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.desafiolatam.empresaLogistiqal.model.Producto;
import cl.desafiolatam.empresaLogistiqal.repository.IProductoRepository;
import cl.desafiolatam.empresaLogistiqal.vo.NumberVO;
import cl.desafiolatam.empresaLogistiqal.vo.ProductoVO;

@Service
public class ProductoService implements IProductoService {

	@Autowired
	IProductoRepository repository;
	
	ProductoVO respuesta;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(ProductoVO.class);

	@Override
	@Transactional(readOnly = true)
	public ProductoVO getAllProductos() {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "102");
		try {
			respuesta.setProductos((List<Producto>) repository.findAll());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getProductos().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Producto Service: Error en getAllProductos", e);
		}
		return respuesta;
				
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findByNombre(String nombre) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "101" );
		try {
			List<Producto> productos = repository.findByNombre(nombre);
			if (productos.size() > 0) {
				respuesta.setProductos(productos);
				respuesta.setMensaje("Producto encontrado correctamente.");
				respuesta.setCodigo("0");
			} else {
				respuesta.setMensaje("Producto no encontrado.");
			}
		} catch (Exception e) {
			logger.trace("Producto Service: Error en findByNombre", e);
		}
		return respuesta;
	}


	@Override
	@Transactional(readOnly = true)
	public ProductoVO add(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "104");
		try {
			repository.save(producto);
			respuesta.setMensaje(String.format("Se ha guardado correctamente al producto %s", producto.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Producto Service: Error en add", e);
		}
		return respuesta;

	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO update(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "105");
		try {
			repository.save(producto);
			respuesta.setMensaje(String.format("Se ha actualizado correctamente al producto %s", producto.getNombre()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Producto Service: Error en update", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO delete(Producto producto) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "106");
		try {
			repository.delete(producto);
			respuesta.setMensaje("Se ha eliminado correctamente al producto");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Producto Service: Error en delete", e);
		}
		return respuesta;

	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO findByCodigo(Integer codigo) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "107");
		try {
			Producto producto = repository.findByCodigo(codigo).get(0);
			respuesta.getProductos().add(producto);
			respuesta.setMensaje("Producto encontrado correctamente.");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Producto Service: Error en findByCodigo", e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductoVO getPage(Integer pagina, Integer cantidad) {
		respuesta = new ProductoVO(new ArrayList<Producto>(), "Ha ocurrido un error", "108");
		try {
			Pageable pageable = PageRequest.of(0, 5);
			Page<Producto> responsePage = repository.findAll(pageable);
			respuesta.setProductos(responsePage.getContent());
			respuesta.setMensaje(String.format("Se ha/n encontrado %d registro/s", respuesta.getProductos().size()));
			respuesta.setCodigo("0");
		} catch (Exception e) {
			logger.trace("Producto Service: Error en getPage", e);
		}
		return respuesta;

	}

	@Override
	@Transactional(readOnly = true)
	public NumberVO getPageCount(long registrosPorPagina) {
		NumberVO respuesta = new NumberVO(0,"Ha ocurrido un error", "109");
		try {
			long registros = repository.count();
			if (registrosPorPagina == 0 && registros == 0) {
				respuesta.setValor(1);
			} else {
				respuesta.setValor((registros / registrosPorPagina) + (registros % registrosPorPagina == 0 ? 0 : 1));
			}
			respuesta.setCodigo("201");
			respuesta.setMensaje(String.format("Hay %d paginas", respuesta.getValor()));
		} catch (Exception e) {
			logger.trace("Producto Service: Error en getPageCount", e);
		}
		return respuesta;

	}

}