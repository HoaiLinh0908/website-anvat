package com.websiteanvat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
		
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity userComment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity productCommented;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserEntity getUserComment() {
		return userComment;
	}

	public void setUserComment(UserEntity userComment) {
		this.userComment = userComment;
	}

	public ProductEntity getProductCommented() {
		return productCommented;
	}

	public void setProductCommented(ProductEntity productCommented) {
		this.productCommented = productCommented;
	}
}