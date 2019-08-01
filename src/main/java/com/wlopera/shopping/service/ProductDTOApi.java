/**
 * 
 */
package com.wlopera.shopping.service;

import java.util.List;

import com.wlopera.shopping.model.ProductDTO;

/**
 * Servicios de procesamientos de productos contra base de datos
 * 
 * @author Willian Lopera
 */
public interface ProductDTOApi {

	/**
	 * Servicio de actulizar datos de un producto
	 * 
	 * @param product Producto a crear
	 * 
	 * @return Producto creado
	 */
	public ProductDTO create(ProductDTO product);

	/**
	 * Servicio de modificar datos de un producto
	 * 
	 * @param product Producto a modificar (se envia el identificador del producto)
	 * 
	 * @return Producto modificado
	 */
	public ProductDTO update(ProductDTO product);

	/**
	 * Servicio de borrar un producto
	 * 
	 * @param product Producto a borrar
	 */
	public void delete(ProductDTO product);

	/**
	 * Operacion de consulta de productos por nombre
	 * 
	 * @param name Nombre del producto
	 * 
	 * @return Producto
	 */
	public ProductDTO findByName(String name);

	/**
	 * Operacion de consultar todos los productos
	 * 
	 * @return Lista de prodcutos
	 */
	public List<ProductDTO> findAll();

}
