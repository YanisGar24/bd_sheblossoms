package com.sheblossoms.sheblossoms.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name = "`order`", schema = "base_sheblossoms") // Cambiado para evitar conflicto con palabras reservadas como 'order'
public class Order {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idorder", nullable = false)
	    private int id;

	    @Enumerated(EnumType.STRING)
	    @Column(name = "order_status", nullable = false) //Se cambio Enun
	    private OrderStatus orderStatus;

	    @Column(name = "order_date", nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date orderDate;

	    @Column(name = "order_total", nullable = false)
	    private double orderTotal;

	    @Column(name = "address", nullable = false)
	    private String address;

    // Relación muchos a uno con User
    @ManyToOne
    @JsonIgnore // Evita la serialización del lado de los Posts
    @JoinColumn(name = "user_iduser") // Nombre de la columna en la tabla orders que referencia a user
    private User user;

    
    // Relación uno a uno con Order_details
    @OneToOne(mappedBy = "order")
    @JsonIgnore // Evita la serialización del lado de los Posts
    private OrderDetails orderDetails; 
    
    /*@OneToOne(mappedBy = "order")
    private OrderDetails orderDetails;*/
    //@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    //private List<OrderDetails> orderDetails;
    


     //Relación uno a uno con Payment_methods
    @OneToOne(mappedBy = "order")
    @JsonIgnore // Evita la serialización del lado de los PaymentMethods
    private PaymentMethods paymentMethods;
    
    
    /*
    
 // Relación uno a muchos con PaymentMethods
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<PaymentMethods> paymentMethods;

    // Relación uno a muchos con OrderDetails
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

*/
    // Constructor vacío para Hibernate
    public Order() {}

	
	
	public Order(int id, OrderStatus orderStatus, Date orderDate, double orderTotal, String address, User user,
			OrderDetails orderDetails, PaymentMethods paymentMethods) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.address = address;
		this.user = user;
		this.orderDetails = orderDetails;
		this.paymentMethods = paymentMethods;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public OrderStatus getOrderStatus() {
		return orderStatus;
	}



	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public double getOrderTotal() {
		return orderTotal;
	}



	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public OrderDetails getOrderDetails() {
		return orderDetails;
	}



	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}



	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}



	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}



	public enum OrderStatus {
	    Enviado, Transito, Entregado
	}

    

	
    
}
