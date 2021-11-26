package cl.desafiolatam.empresaLogistiqal.repository;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.empresaLogistiqal.model.Producto;

public interface IProductoRepository extends CrudRepository<Producto, String> {
	
	
}
