package com.sheblossoms.sheblossoms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_category", schema = "base_sheblossoms")
public class ProductCategory {
	  // PK
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_idcategory", nullable = false)
    private int categoryIdCategory;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_shops_idshops", nullable = false)
    private int categoryShopsIdShops;
	
    
    @ManyToOne
    @JsonIgnore // Evita la serialización del lado de los product
    @JoinColumn(name = "product_idproduct", nullable = false)
    private Product product;
    
    @ManyToOne
    @JsonIgnore // Evita la serialización del lado de los category
    @JoinColumn(name = "category_idcategory", referencedColumnName = "idcategory")
    private Category category;
	
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // Identificador único para la tabla pivote

    @ManyToOne
    @JoinColumn(name = "idproduct", nullable = false) // Clave foránea que apunta a la entidad Product
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idcategory", nullable = false) // Clave foránea que apunta a la entidad Category
    private Category category;
    */

	
	
	
	
    /*
      @EmbeddedId
    private ProductsCategoriesId id;

    // Relación con Category
    @MapsId("categoryId")
    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    // Relación con Product
    @MapsId("productId")
    @ManyToOne
    @JoinColumn(name = "idproduct")
    private Product product;

    // Relación con Shop
    @MapsId("shopId")
    @ManyToOne
    @JoinColumn(name = "idshop")
    private Shop shop;
     * */
    
    
    

}
