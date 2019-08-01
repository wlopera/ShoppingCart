/**
 * 
 */
package com.wlopera.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wlopera.shopping.entity.ProductDAO;
import com.wlopera.shopping.model.ProductDTO;
import com.wlopera.shopping.repository.ProductRepository;

/**
 * Implemantacion de servicios de procesamientos de productos contra base de
 * datos
 * 
 * @author Willian Lopera
 */
@Service
@Transactional(readOnly = true)
public class ProductDTOService implements ProductDTOApi {

	private ProductRepository productRepository;

	public ProductDTOService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public ProductDTO create(ProductDTO product) {
		return toProductDTO(productRepository.save(toProductDAO(product)));
	}

	@Override
	public ProductDTO update(ProductDTO product) {
		return toProductDTO(productRepository.save(toProductDAO(product)));
	}

	@Override
	public void delete(ProductDTO product) {
		productRepository.delete(toProductDAO(product));
	}

	@Override
	public ProductDTO findByName(String name) {
		return toProductDTO(productRepository.findByName(name));
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDAO> inputList = productRepository.findAll();

		List<ProductDTO> outputList = new ArrayList<>();

		for (ProductDAO input : inputList) {
			outputList.add(toProductDTO(input));
		}

		return outputList;
	}

	/**
	 * Conversor objeto 'ProductDTO' a objeto 'ProductDAO'
	 * 
	 * @param input Producto del modelo de negocio
	 * 
	 * @return Producto del modelo de base de datos
	 */
	private ProductDAO toProductDAO(ProductDTO input) {

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
	private ProductDTO toProductDTO(ProductDAO input) {

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
