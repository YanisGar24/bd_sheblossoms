package com.sheblossoms.sheblossoms.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "paymentmethods", schema = "base_sheblossoms")
public class PaymentMethods {
	//PK
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpayment", nullable = false)
    private int idPayment;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "payment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @Column(name = "payment_amount", nullable = false)
    private double paymentAmount;
			
   
    
	
			// Relación uno a uno con Orders
		    @OneToOne
		    @JsonIgnore // Evita la serialización del lado de los Posts
		    @JoinColumn(name = "order_idorder", referencedColumnName = "idorder") // Nombre de la columna en la tabla paymentmethods que referencia a orders
		    private Order order;

    
    /*
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "order_idorder", referencedColumnName = "idorder"),
        @JoinColumn(name = "order_user_iduser", referencedColumnName = "user_iduser")
    })
    private Order order; */

    //  @ManyToOne
    //@JoinColumn(name = "order_idorder", referencedColumnName = "idorder")
    //private Order order;
    


		    
	public PaymentMethods() {
		
	}
			public PaymentMethods(int idPayment, PaymentMethod paymentMethod, Date paymentDate, double paymentAmount,
					Order order) {
				super();
				this.idPayment = idPayment;
				this.paymentMethod = paymentMethod;
				this.paymentDate = paymentDate;
				this.paymentAmount = paymentAmount;
				this.order = order;
			}
			public int getIdPayment() {
				return idPayment;
			}
			public void setIdPayment(int idPayment) {
				this.idPayment = idPayment;
			}
			public PaymentMethod getPaymentMethod() {
				return paymentMethod;
			}
			public void setPaymentMethod(PaymentMethod paymentMethod) {
				this.paymentMethod = paymentMethod;
			}
			public Date getPaymentDate() {
				return paymentDate;
			}
			public void setPaymentDate(Date paymentDate) {
				this.paymentDate = paymentDate;
			}
			public double getPaymentAmount() {
				return paymentAmount;
			}
			public void setPaymentAmount(double paymentAmount) {
				this.paymentAmount = paymentAmount;
			}
			public Order getOrder() {
				return order;
			}
			public void setOrder(Order order) {
				this.order = order;
			}
			@Override
			public String toString() {
				return "PaymentMethods [idPayment=" + idPayment + ", paymentMethod=" + paymentMethod + ", paymentDate="
						+ paymentDate + ", paymentAmount=" + paymentAmount + ", order=" + order + "]";
			}
	
			
			public enum PaymentMethod {
				Tarjeta, Efectivo
			}
   
	
			
		

			
}
