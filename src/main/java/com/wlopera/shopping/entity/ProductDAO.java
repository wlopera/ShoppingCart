package com.wlopera.shopping.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Modelo de Base de datos - Producto
 * 
 * @author Willian Lopera
 */
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="product")
public class ProductDAO {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idProduct;
	
	private String name;
	private byte[] image;
	private String description;
	private BigDecimal prece; 
	private Integer stock;

}
