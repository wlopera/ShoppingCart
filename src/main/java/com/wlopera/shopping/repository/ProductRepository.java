package com.wlopera.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wlopera.shopping.entity.ProductDAO;

/**
 * Repositorio de Productos
 * 
 * @author William Lopera
 */
public interface ProductRepository extends JpaRepository<ProductDAO, String> {

	/**
	 * Operacion de consulta de productos por identificador
	 * 
	 * @param name Identificador del producto
	 * 
	 * @return Producto
	 */
	public ProductDAO findByIdProduct(String idProduct);
	
	/**
	 * Operacion de consulta de productos por nombre
	 * 
	 * @param name Nombre del producto
	 * 
	 * @return Producto
	 */
	public ProductDAO findByName(String name);

}
