package com.sheblossoms.sheblossoms.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails" , schema = "base_sheblossoms") 
public class OrderDetails {
	//PK
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorderdetails", nullable = false)
    private int idOrderDetails;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "number_of_items", nullable = false)
    private int numberOfItems;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "order_total", nullable = false)
    private double orderTotal;

    @Column(name = "address", nullable = false)
    private String address;

		
		//FK
		/*@OneToOne
		@JoinColumn(name = "order_idorder") // Columna de la clave foránea en la tabla order
		private Orders orders;*/
		
		/*// Relación uno a uno con Orders chatgpt
	    @OneToOne
	    @JoinColumn(name = "order_idorder", referencedColumnName = "idorder", unique = true) // Nombre de la columna en la tabla orderdetails que referencia a order
	    private Order order;*/
	    
    /*
	    @OneToOne
	    @JoinColumn(name = "order_id")
	    private Order order;
	
	*/
    
    
    //@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    //private List<PaymentMethods> paymentMethods;
    
    /*@ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "idorder")
    private Order order;*/

    /*
    // Relación muchos a uno con Order
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "order_idorder", referencedColumnName = "idorder"),
        @JoinColumn(name = "order_user_iduser", referencedColumnName = "user_iduser")
    })
    private Order order;
    */
    
    @OneToOne
    @JoinColumn(name = "order_idorder", referencedColumnName = "idorder")
    @JsonIgnore // Evita la serialización del lado de los order
    private Order order;

    
    /*@OneToOne    
    @JoinColumns({
        @JoinColumn(name = "order_idorder", referencedColumnName = "idorder"),
        @JoinColumn(name = "order_user_iduser", referencedColumnName = "user_iduser")
    })*/
	    
		
	   
		
		public OrderDetails() {
			
		}


		public OrderDetails(int idOrderDetails, int productId, int numberOfItems, double unitPrice, String description,
				double orderTotal, String address, Order order) {
			super();
			this.idOrderDetails = idOrderDetails;
			this.productId = productId;
			this.numberOfItems = numberOfItems;
			this.unitPrice = unitPrice;
			this.description = description;
			this.orderTotal = orderTotal;
			this.address = address;
			this.order = order;
		}


		public int getIdOrderDetails() {
			return idOrderDetails;
		}


		public void setIdOrderDetails(int idOrderDetails) {
			this.idOrderDetails = idOrderDetails;
		}


		public int getProductId() {
			return productId;
		}


		public void setProductId(int productId) {
			this.productId = productId;
		}


		public int getNumberOfItems() {
			return numberOfItems;
		}


		public void setNumberOfItems(int numberOfItems) {
			this.numberOfItems = numberOfItems;
		}


		public double getUnitPrice() {
			return unitPrice;
		}


		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
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


		public Order getOrder() {
			return order;
		}


		public void setOrder(Order order) {
			this.order = order;
		}


		@Override
		public String toString() {
			return "OrderDetails [idOrderDetails=" + idOrderDetails + ", productId=" + productId + ", numberOfItems="
					+ numberOfItems + ", unitPrice=" + unitPrice + ", description=" + description + ", orderTotal="
					+ orderTotal + ", address=" + address + ", order=" + order + "]";
		}


		
		
		
		
		
}
