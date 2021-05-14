package com.tvmshoppingcart.addtocart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addtocart")
public class Addtocart {
	@Id
	private long userid;
	private long productid;
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	//<td> <a th:href="@{/showFormForProduct/{userid}(userid=${addtocart.userid})}/{productid}(productid=${addtocart.productid})}" class="btn btn-primary">Update</a></td>
	
	
}
