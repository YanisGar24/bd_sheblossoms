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
@Table(name = "shop_category", schema = "base_sheblossoms")
public class ShopCategory {
	
	//private Long shops_idshops;
	//private Long category_idcategory;
	
	// PK
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    //private Long id; // Identificador único para la tabla pivote

	
	//Cambios del 17-09
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "shops_idshops", nullable = false)
	    private int shopsIdShops;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "category_idcategory", nullable = false)
	    private int categoryIdCategory;

	    
    /* @ManyToOne //une con shop
    @JoinColumn(name = "idshop", nullable = false) // Clave foránea que apunta a la entidad Shop
    private Shops shop;*/
    
	    @ManyToOne
	    @JsonIgnore // Evita la serialización del lado de los shop
	    @JoinColumn(name = "shops_idshops", nullable = false)
	    private Shops shop;
    
    /*@ManyToOne 
    @JoinColumn(name = "idcategory", nullable = false) // Clave foránea que apunta a la entidad Category
    private Category category;*/
    
    @ManyToOne
    @JsonIgnore // Evita la serialización del lado de los category
    @JoinColumn(name = "category_shops_idshops", nullable = false)
    private Category category;
    
    
    public ShopCategory() {
    	
    }
	public ShopCategory(int shopsIdShops, int categoryIdCategory, Shops shop, Category category) {
		super();
		this.shopsIdShops = shopsIdShops;
		this.categoryIdCategory = categoryIdCategory;
		this.shop = shop;
		this.category = category;
	}
	
	public int getShopsIdShops() {
		return shopsIdShops;
	}
	public void setShopsIdShops(int shopsIdShops) {
		this.shopsIdShops = shopsIdShops;
	}
	public int getCategoryIdCategory() {
		return categoryIdCategory;
	}
	public void setCategoryIdCategory(int categoryIdCategory) {
		this.categoryIdCategory = categoryIdCategory;
	}
	public Shops getShop() {
		return shop;
	}
	public void setShop(Shops shop) {
		this.shop = shop;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "ShopCategory [shopsIdShops=" + shopsIdShops + ", categoryIdCategory=" + categoryIdCategory + ", shop="
				+ shop + ", category=" + category + "]";
	}
	
    

	
	
	
	
    
    
    //-----------Version de chatgpt----------------------------------------
    /*// Clave primaria compuesta
    @EmbeddedId
    private ShopCategoryId id;

    // Relación con Shop
    @MapsId("shopId") // Mapea la parte de la clave primaria compuesta relacionada con shop
    @ManyToOne
    @JoinColumn(name = "idshop")
    private Shop shop;

    // Relación con Category
    @MapsId("categoryId") // Mapea la parte de la clave primaria compuesta relacionada con category
    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;*/
    
    
}
