package com.sheblossoms.sheblossoms.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "productreviews", schema = "base_sheblossoms")
public class ProductReviews {
	
	//PK
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproductreviews", nullable = false)
    private int idProductReviews;

    @Column(name = "productreview", nullable = false)
    private String productReview;

    @Column(name = "review_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;

		
		//FK
		//private Long shops_idshops; //int
		 @ManyToOne
		 @JsonIgnore // Evita la serialización del lado de los Product
		 @JoinColumn(name = "product_idproduct", referencedColumnName = "idproduct") // columna de la clave foránea en la tabla product
		  private Product product; //esto esta en plural

		 public ProductReviews() {}
		 
		public ProductReviews(int idProductReviews, String productReview, Date reviewDate, Product product) {
			super();
			this.idProductReviews = idProductReviews;
			this.productReview = productReview;
			this.reviewDate = reviewDate;
			this.product = product;
		}


		public int getIdProductReviews() {
			return idProductReviews;
		}


		public void setIdProductReviews(int idProductReviews) {
			this.idProductReviews = idProductReviews;
		}


		public String getProductReview() {
			return productReview;
		}


		public void setProductReview(String productReview) {
			this.productReview = productReview;
		}


		public Date getReviewDate() {
			return reviewDate;
		}


		public void setReviewDate(Date reviewDate) {
			this.reviewDate = reviewDate;
		}


		public Product getProduct() {
			return product;
		}


		public void setProduct(Product product) {
			this.product = product;
		}


		@Override
		public String toString() {
			return "ProductReviews [idProductReviews=" + idProductReviews + ", productReview=" + productReview
					+ ", reviewDate=" + reviewDate + ", product=" + product + "]";
		}
		 
		 

		
}
