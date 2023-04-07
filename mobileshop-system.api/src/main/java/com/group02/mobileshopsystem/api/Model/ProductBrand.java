package com.group02.mobileshopsystem.api.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class ProductBrand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String brandName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return brandName;
	}
	public void setName(String branName) {
		this.brandName = branName;
	}
	public ProductBrand(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String branName) {
		this.brandName = branName;
	}
}