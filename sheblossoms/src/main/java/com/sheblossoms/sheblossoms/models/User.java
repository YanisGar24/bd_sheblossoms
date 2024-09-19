package com.sheblossoms.sheblossoms.models;

import java.util.Date; 
import java.util.Set;

import javax.management.relation.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "user", schema = "base_sheblossoms") 

public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser", nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Column(name = "reg_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date regDate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
	
	
	//relacion 1-1  usuario a shops
	@OneToOne(mappedBy = "user")
	@JsonIgnore // Evita la serialización del lado de los shops
    private Shops shops;
	
	/*// Relación uno a uno con Shops chatgpt
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Shops shop;*/
			
	
	//Relación uno a muchos con Orders
	@OneToMany(mappedBy = "user") // La propiedad en order que mapea la relación
	@JsonIgnore // Evita la serialización del lado de los order
    private Set<Order> order; // O List<Product> dependiendo de tu preferencia
	
    /* Relación uno a muchos con Orders version chatgpt
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders; */
	
	 //@ManyToOne
	  //  @JoinColumn(name = "idshops", nullable = false) // columna de la clave foránea en la tabla product
	  //  private Shops shops;
	
	public User() {	
	}

	public User(int id, String name, String email, String password, Role role, Date regDate, String address,
			String phoneNumber, Shops shops, Set<Order> order) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regDate = regDate;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.shops = shops;
		this.order = order;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Shops getShops() {
		return shops;
	}

	public void setShops(Shops shops) {
		this.shops = shops;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", regDate=" + regDate + ", address=" + address + ", phoneNumber=" + phoneNumber + ", shops=" + shops
				+ ", orders=" + order + "]";
	}

	
	public enum Role {
		seller, admin, shopper
	}

	

	
}
