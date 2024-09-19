package com.sheblossoms.sheblossoms.models;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "product", schema = "base_sheblossoms") 
public class Product {
	//PK
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idproduct", nullable = false)
	    private int idProduct;

	    @Column(name = "product_name", nullable = false)
	    private String productName;

	    @Column(name = "description", nullable = false)
	    private String description;

	    @Column(name = "product_price", nullable = false)
	    private double productPrice;

	    @Column(name = "product_stock", nullable = false)
	    private int productStock;

	    @Column(name = "product_category", nullable = false)
	    private String productCategory;

	    @Column(name = "add_date", nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date addDate;

	    @Column(name = "url_img", nullable = false)
	    private String urlImg;
		 
		//FK
		//private Long shops_idshops; //int
	 	/*@ManyToOne
	    @JoinColumn(name = "shops_idshops", nullable = false) // columna de la clave foránea en la tabla product
	    private Shops shop; */
	 
	// Relación muchos a uno con Shop CHATGPT
	    @ManyToOne
	    @JsonIgnore // Evita la serialización del lado de los shop
	    @JoinColumn(name = "shops_idshops") // Nombre de la columna en la tabla product que referencia a shop
	    private Shops shop;

	 
	 // Relación muchos a muchos con Category a través de ProductsCategories
	 @OneToMany(mappedBy = "product")
	 @JsonIgnore // Evita la serialización del lado de los ProductCategory
	    private Set<ProductCategory> productsCategories; // Colección de la tabla pivote
	    
	    /*// Relación muchos a muchos con Category a través de ProductsCategories CHATGPT
	    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	    private Set<ProductsCategories> productsCategories;*/
	

		public Product() {	
		}

		public Product(int idProduct, String productName, String description, double productPrice, int productStock,
				String productCategory, Date addDate, String urlImg, Shops shop,
				Set<ProductCategory> productsCategories) {
			super();
			this.idProduct = idProduct;
			this.productName = productName;
			this.description = description;
			this.productPrice = productPrice;
			this.productStock = productStock;
			this.productCategory = productCategory;
			this.addDate = addDate;
			this.urlImg = urlImg;
			this.shop = shop;
			this.productsCategories = productsCategories;
		}

		public int getIdProduct() {
			return idProduct;
		}

		public void setIdProduct(int idProduct) {
			this.idProduct = idProduct;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}

		public int getProductStock() {
			return productStock;
		}

		public void setProductStock(int productStock) {
			this.productStock = productStock;
		}

		public String getProductCategory() {
			return productCategory;
		}

		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}

		public Date getAddDate() {
			return addDate;
		}

		public void setAddDate(Date addDate) {
			this.addDate = addDate;
		}

		public String getUrlImg() {
			return urlImg;
		}

		public void setUrlImg(String urlImg) {
			this.urlImg = urlImg;
		}

		public Shops getShop() {
			return shop;
		}

		public void setShop(Shops shop) {
			this.shop = shop;
		}

		public Set<ProductCategory> getProductsCategories() {
			return productsCategories;
		}

		public void setProductsCategories(Set<ProductCategory> productsCategories) {
			this.productsCategories = productsCategories;
		}

		@Override
		public String toString() {
			return "Product [idProduct=" + idProduct + ", productName=" + productName + ", description=" + description
					+ ", productPrice=" + productPrice + ", productStock=" + productStock + ", productCategory="
					+ productCategory + ", addDate=" + addDate + ", urlImg=" + urlImg + ", shop=" + shop
					+ ", productsCategories=" + productsCategories + "]";
		}

		
}
