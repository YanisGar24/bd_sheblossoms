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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "shops", schema = "base_sheblossoms") 
public class Shops {
	
	//PK

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idshops", nullable = false)
    private int idShops;

    @Column(name = "store_name", nullable = false)
    private String storeName;

    @Column(name = "store_description", nullable = false)
    private String storeDescription;

    @Column(name = "reg_date_store", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDateStore;

    @Column(name = "url_logo", nullable = false)
    private String urlLogo;

    @Column(name = "shop_location", nullable = false)
    private String shopLocation;



	
	//FK
	//private Long user_iduser; //Int
	
	/*@OneToOne
	@JoinColumn(name = "user_iduser") // Columna de la clave foránea en la tabla shops
	private User user;*/
	
	// Relación uno a uno con User chatgpt
    @OneToOne
    @JsonIgnore // Evita la serialización del lado de los user
    @JoinColumn(name = "user_iduser", unique = true) // Nombre de la columna en la tabla shops que referencia a user
    private User user;
	
    // Relación uno a muchos con Product
	@OneToMany(mappedBy = "shop") // La propiedad en Product que mapea la relación
	@JsonIgnore // Evita la serialización del lado de los products
    private Set<Product> products; // O List<Product> dependiendo de tu preferencia
	
	/* // Relación uno a muchos con Product chatgpt
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;*/
	
	

	// Relación uno a muchos con Shop_Category
	@OneToMany(mappedBy = "shop")
	@JsonIgnore // Evita la serialización del lado de los Posts
    private Set<ShopCategory> shopCategories; // Colección de la tabla pivote

	
    /*// Relación uno a muchos con ShopCategory chatgpt
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShopCategory> shopCategories; */
    
	public Shops() {	
	}


	public Shops(int idShops, String storeName, String storeDescription, Date regDateStore, String urlLogo,
			String shopLocation, User user, Set<Product> products, Set<ShopCategory> shopCategories) {
		super();
		this.idShops = idShops;
		this.storeName = storeName;
		this.storeDescription = storeDescription;
		this.regDateStore = regDateStore;
		this.urlLogo = urlLogo;
		this.shopLocation = shopLocation;
		this.user = user;
		this.products = products;
		this.shopCategories = shopCategories;
	}


	public int getIdShops() {
		return idShops;
	}


	public void setIdShops(int idShops) {
		this.idShops = idShops;
	}


	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreDescription() {
		return storeDescription;
	}


	public void setStoreDescription(String storeDescription) {
		this.storeDescription = storeDescription;
	}


	public Date getRegDateStore() {
		return regDateStore;
	}


	public void setRegDateStore(Date regDateStore) {
		this.regDateStore = regDateStore;
	}


	public String getUrlLogo() {
		return urlLogo;
	}


	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}


	public String getShopLocation() {
		return shopLocation;
	}


	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	public Set<ShopCategory> getShopCategories() {
		return shopCategories;
	}


	public void setShopCategories(Set<ShopCategory> shopCategories) {
		this.shopCategories = shopCategories;
	}


	@Override
	public String toString() {
		return "Shops [idShops=" + idShops + ", storeName=" + storeName + ", storeDescription=" + storeDescription
				+ ", regDateStore=" + regDateStore + ", urlLogo=" + urlLogo + ", shopLocation=" + shopLocation
				+ ", user=" + user + ", products=" + products + ", shopCategories=" + shopCategories + "]";
	}


	
}
