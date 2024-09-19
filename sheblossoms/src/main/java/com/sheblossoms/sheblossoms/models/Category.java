package com.sheblossoms.sheblossoms.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category", schema = "base_sheblossoms") 
public class Category {
	//PK
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory", nullable = false)
    private int idCategory;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_description", nullable = false)
    private String categoryDescription;
	
	
	
    // Relación uno a muchos con ShopCategory
	@OneToMany(mappedBy = "category")
	@JsonIgnore // Evita la serialización del lado de los shopcategory
    private Set<ShopCategory> shopCategories; // Colección de la tabla pivote
	
    /*// Relación uno a muchos con ShopCategory
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShopCategory> shopCategories;*/
    
    @OneToMany(mappedBy = "category")
    @JsonIgnore // Evita la serialización del lado de los productCategory
    private Set<ProductCategory> productsCategories; // Colección de la tabla pivote
    
    /*// Relación muchos a muchos con Product a través de ProductsCategories CHATGPT
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductsCategories> productsCategories;*/
    
    
	//constructor
	public Category() {	
	}

	public Category(int idCategory, String categoryName, String categoryDescription, Set<ShopCategory> shopCategories,
			Set<ProductCategory> productsCategories) {
		super();
		this.idCategory = idCategory;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.shopCategories = shopCategories;
		this.productsCategories = productsCategories;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Set<ShopCategory> getShopCategories() {
		return shopCategories;
	}

	public void setShopCategories(Set<ShopCategory> shopCategories) {
		this.shopCategories = shopCategories;
	}

	public Set<ProductCategory> getProductsCategories() {
		return productsCategories;
	}

	public void setProductsCategories(Set<ProductCategory> productsCategories) {
		this.productsCategories = productsCategories;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + ", shopCategories=" + shopCategories + ", productsCategories="
				+ productsCategories + "]";
	}
	
	
	
	
	
	
	
		
}
