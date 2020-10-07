package com.websiteanvat.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders01")
public class OrderEntity extends BaseEntity{
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_id")
	private SupplierEntity supplier;
	
	@OneToMany(mappedBy = "orders")
	private List<OrderProductEntity> orderProducts = new ArrayList<>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserEntity getUsers() {
		return users;
	}

	public void setUsers(UserEntity user) {
		this.users = user;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	public List<OrderProductEntity> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProductEntity> orderProducts) {
		this.orderProducts = orderProducts;
	}	
}
