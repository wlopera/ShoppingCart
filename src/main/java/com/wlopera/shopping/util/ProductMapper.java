/**
 * 
 */
package com.wlopera.shopping.util;

import com.wlopera.shopping.entity.ProductDAO;
import com.wlopera.shopping.model.ProductDTO;

/**
 * Mapeo de objetos 'ProductDTO' a 'ProductDAO' y visceversa
 * 
 * @author William Lopera
 */
public class ProductMapper {

	/**
	 * Conversor objeto 'ProductDTO' a objeto 'ProductDAO'
	 * 
	 * @param input Producto del modelo de negocio
	 * 
	 * @return Producto del modelo de base de datos
	 */
	public ProductDAO toProductDAO(ProductDTO input) {

		ProductDAO output = new ProductDAO();

		output.setIdProduct(input.getIdProduct());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		output.setImage(input.getImage());
		output.setPrece(input.getPrece());
		output.setStock(input.getStock());

		return output;

	}

	/**
	 * Conversor objeto 'ProductDAO' a objeto 'ProductDTO'
	 * 
	 * @param input Producto del modelo de base de datos
	 * 
	 * @return Producto del modelo de negocio
	 */
	public ProductDTO toProductDTO(ProductDAO input) {

		ProductDTO output = new ProductDTO();

		output.setIdProduct(input.getIdProduct());
		output.setName(input.getName());
		output.setDescription(input.getDescription());
		output.setImage(input.getImage());
		output.setPrece(input.getPrece());
		output.setStock(input.getStock());

		return output;

	}

}
