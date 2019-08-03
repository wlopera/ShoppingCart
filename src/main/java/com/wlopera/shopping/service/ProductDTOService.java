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
import com.wlopera.shopping.util.ProductMapper;

/**
 * Implemantacion de servicios de procesamientos de productos contra base de
 * datos
 * 
 * @author William Lopera
 */
@Service
@Transactional(readOnly = true)
public class ProductDTOService implements ProductDTOApi {

	private ProductRepository repository;

	private ProductMapper mapper;

	public ProductDTOService(ProductRepository repository) {
		mapper = new ProductMapper();
		this.repository = repository;
	}

	@Override
	@Transactional
	public ProductDTO create(ProductDTO product) {
		return mapper.toProductDTO(repository.save(mapper.toProductDAO(product)));
	}

	@Override
	@Transactional
	public ProductDTO update(ProductDTO product) {
		return mapper.toProductDTO(repository.save(mapper.toProductDAO(product)));
	}

	@Override
	@Transactional
	public void delete(ProductDTO product) {
		repository.delete(mapper.toProductDAO(product));
	}

	@Override
	public ProductDTO findByIdProduct(String idProduct) {
		return mapper.toProductDTO(repository.findByIdProduct(idProduct));
	}

	@Override
	public ProductDTO findByName(String name) {
		return mapper.toProductDTO(repository.findByName(name));
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDAO> inputList = repository.findAll();

		List<ProductDTO> outputList = new ArrayList<>();

		for (ProductDAO input : inputList) {
			outputList.add(mapper.toProductDTO(input));
		}

		return outputList;
	}

}
