package com.demo.rewardsprogram.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long customerId;
		@NotBlank
		private String customerName;
		
		@Column(nullable = false, updatable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @CreatedDate
	    private Date createdTimestamp;

	    @Column(nullable = false)
	    @Temporal(TemporalType.TIMESTAMP)
	    @LastModifiedDate
	    private Date updatedTimestamp;

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public Date getCreatedTimestamp() {
			return createdTimestamp;
		}

		public void setCreatedTimestamp(Date createdTimestamp) {
			this.createdTimestamp = createdTimestamp;
		}

		public Date getUpdatedTimestamp() {
			return updatedTimestamp;
		}

		public void setUpdatedTimestamp(Date updatedTimestamp) {
			this.updatedTimestamp = updatedTimestamp;
		}
	    
	    
	    
	    
}