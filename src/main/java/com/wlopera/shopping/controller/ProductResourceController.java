package com.wlopera.shopping.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.shopping.model.ProductDTO;
import com.wlopera.shopping.service.ProductDTOService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Servicios WEB del Producto.
 * 
 * @author William Lopera
 */
@RestController
@RequestMapping("/api/product")
@Api(tags = "Producto")
public class ProductResourceController {

	private ProductDTOService productService;

	public ProductResourceController(ProductDTOService productService) {
		this.productService = productService;
	}

	/**
	 * Servicio guardar producto
	 * 
	 * @param product Datos del producto
	 * 
	 * @return Producto creado
	 */
	@PostMapping("/addProduct")
	@ApiOperation(value = "Crear Producto", notes = "Servicio para crear un nuevo producto")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Producto creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {

		System.out.println("Servicio[/api/product/addProduct] - PETICION: " + product.toString());

		ProductDTO output = productService.create(product);

		System.out.println("Servicio[/api/product/addProduct] - RESPUESTA: " + output.toString());
		
		return new ResponseEntity<>(output, HttpStatus.CREATED);

	}

	/**
	 * Servicio actualizar producto
	 * 
	 * @param product Datos del producto
	 * 
	 * @return Producto modificado
	 */
	@PutMapping("/updateProduct")
	@ApiOperation(value = "Actualizar Producto", notes = "Servicio para actualizar un producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Producto actualizado correctamente"),
			@ApiResponse(code = 404, message = "Producto no encontrado") })
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product) {
		return new ResponseEntity<>(productService.update(product), HttpStatus.OK);
	}

	/**
	 * Servicio borrar producto
	 * 
	 * @param idProduct Identificador del producto
	 * 
	 * @return Producto borrado
	 */
	@SuppressWarnings("unused")
	@DeleteMapping("/deleteProduct/{idProduct}")
	@ApiOperation(value = "Borrar Producto", notes = "Servicio para borrar un producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Producto borrado correctamente"),
			@ApiResponse(code = 404, message = "Producto no encontrado") })
	public ResponseEntity<String> deleteProduct(@PathVariable("idProduct") String idProduct) {

		System.out.println("Servicio[/api/product/deleteProduct]: " + idProduct);

		ProductDTO product = productService.findByIdProduct(idProduct);

		System.out.println("Servicio[/api/product/deleteProduct] - respuesta: " + product.toString());

		if (null == product) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND.value() + " -- " + HttpStatus.NOT_FOUND.getReasonPhrase(),
					HttpStatus.NOT_FOUND);
		}

		productService.delete(product);

		return new ResponseEntity<>(HttpStatus.OK.value() + " -- " + HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);

	}

	/**
	 * Servicio de consulta de todos los productos
	 * 
	 * @return LIsta de productos
	 */
	@GetMapping("getAllProduct")
	@ApiOperation(value = "Consultar Productos", notes = "Servicio para consultar todos los producto")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Productos encontrados"),
			@ApiResponse(code = 404, message = "Prodcutos no encontrados") })
	public ResponseEntity<List<ProductDTO>> findAllProducts() {
		System.out.println("Servicio[/api/product/getAllProduct]: ");
		return ResponseEntity.ok(productService.findAll());
	}

}
