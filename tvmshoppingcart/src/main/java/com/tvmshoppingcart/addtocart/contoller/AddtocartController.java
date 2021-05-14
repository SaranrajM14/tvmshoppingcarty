package com.tvmshoppingcart.addtocart.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tvmshoppingcart.addtocart.model.Addtocart;
import com.tvmshoppingcart.addtocart.model.Payment;
import com.tvmshoppingcart.addtocart.model.Product;
import com.tvmshoppingcart.addtocart.model.User;
import com.tvmshoppingcart.addtocart.service.AddtocartPaymentService;
import com.tvmshoppingcart.addtocart.service.AddtocartProductService;
import com.tvmshoppingcart.addtocart.service.AddtocartService;
import com.tvmshoppingcart.addtocart.service.AddtocartUserService;

@Controller
public class AddtocartController {
	@Autowired

	private AddtocartService addtocartService;
	@Autowired
	private AddtocartUserService addtocartUserService; 
	@Autowired
	private AddtocartProductService addtocartProductService;
	@Autowired
	private AddtocartPaymentService addtocartPaymentService;
	@GetMapping("/")
    public String viewAddtocart(Model model) {
        model.addAttribute("listAddtocart", addtocartService.getAllAddtocart());
        return "index";
	}
	@GetMapping("/addtocartfromproduct/{userid}/{productid}")
    public String AddtocartfromProduct(@PathVariable(value = "userid") long userid,@PathVariable(value = "productid") long productid) {
    	Addtocart addtocart=new Addtocart();
    	addtocart.setUserid(userid);
    	addtocart.setProductid(productid);
    	addtocartService.saveAddtocart(addtocart);
    	return "redirect:/addtocaart/{userid}";
    }
	@GetMapping("/addtocaart/{userid}")
	public String Addtocartpage(@PathVariable(value="userid") long userid,Model model) {
		Addtocart addtocart=addtocartService.getAddtocartById(userid);
		long user1=addtocart.getProductid();
		
		Product product=addtocartProductService.getProductById(user1);
		model.addAttribute("product", product);
		model.addAttribute("addtocart",addtocart);
		return "addtocart";
	}
	@GetMapping("/deleteAddtocartItem/{userid}")
	public String DeleteAddtocartItem(@PathVariable(value="userid") long userid) {
		
		addtocartService.deleteAddtocartById(userid);
		return "redirect:/";
	}
	
    
    
   
    @GetMapping("/placeorder/{userid}")
    public String showPlaceOrder(@PathVariable(value="userid") long userid,Model model) {
    	User user = addtocartUserService.getUserById(userid);
    	Addtocart addtocart=addtocartService.getAddtocartById(userid);
    	long user1;
    	user1=addtocart.getProductid();
    	Product product=addtocartProductService.getProductById(user1);
    	Payment payment=new Payment();
    	model.addAttribute("user",user);
    	model.addAttribute("product", product);
    	model.addAttribute("payment", payment);
    	return "orderpage";
    }
    
    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute("payment") Payment payment) {
        // save employee to database
    	addtocartPaymentService.saveAddtocartPayment(payment);
        return "redirect:/";
        
    }
    
    
    
    
	
}
