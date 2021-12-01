package cl.desafiolatam.empresaLogistiqal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import cl.desafiolatam.empresaLogistiqal.model.Producto;

public interface IProductoRepository extends CrudRepository<Producto, Integer>, 
	PagingAndSortingRepository<Producto, Integer> {
	
	@Query(value = "SELECT FROM producto WHERE nombre = ?", nativeQuery = true)
	public List<Producto> findByNombre(String nombre);
	@Query(value = "SELECT * FROM producto", nativeQuery = true)
	public List<Producto> getAllUsuarios();
	@Query(value = "INSERT INTO producto (codigo, nombre, precio, stock) VALUES (?,?,?,?)", nativeQuery = true)
	public Integer add(Producto producto);
	@Query(value = "UPDATE producto SET codigo = ?, nombre = ?, precio = ?, stock = ?", nativeQuery = true)
	public Integer update(Producto producto);
	@Query(value = "DELETE FROM producto WHERE codigo = ?", nativeQuery = true)
	public void delete(Producto producto);
	@Query(value = "SELECT FROM producto WHERE codigo = ?", nativeQuery = true)
	public List<Producto> findByCodigo(Integer codigo);
	
}
