package com.wlopera.shopping.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Modelo de Base de datos - Producto
 * 
 * @author William Lopera
 */
@Data
@NoArgsConstructor
@ToString
public class ProductDTO {
	
	private String idProduct;
	private String name;
	private byte[] image;
	private String description;
	private BigDecimal prece; 
	private Integer stock;

}
