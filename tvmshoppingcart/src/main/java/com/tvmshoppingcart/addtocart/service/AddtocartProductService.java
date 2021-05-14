package com.tvmshoppingcart.addtocart.service;

import java.util.List;


import com.tvmshoppingcart.addtocart.model.Product;

public interface AddtocartProductService {
	List< Product > getAllAddtocartProduct();
	Product getProductById(long productid);
	

}
