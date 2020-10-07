package com.websiteanvat.dto;

public class CartDTO {
	private Long id;
	private Long price;
	private Long quantity;
	private Long productId;
	private Long userId;
	private String productCode;
	private String userName;
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public Long getProductId() {
		return productId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
