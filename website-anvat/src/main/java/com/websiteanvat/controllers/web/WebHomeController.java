package com.websiteanvat.controllers.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websiteanvat.dto.ProductDTO;
import com.websiteanvat.service.IProductService;
import com.websiteanvat.util.MessageUtil;


@Controller
public class WebHomeController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private MessageUtil messageUtil;

	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	   public ModelAndView homePage(@RequestParam(value = "page", required = false) Integer page,
			   						@RequestParam(value = "limit", required = false) Integer limit,
			   						HttpServletRequest request) {
		  ProductDTO model = new ProductDTO();
		  ModelAndView mav = new ModelAndView("web/home");
		  Pageable pageable;
		  if(page != null && limit != null) {
			  model.setPage(page);
			  model.setLimit(limit);
			  pageable = new PageRequest(page-1, limit);
		  }else {
			  model.setPage(1);
			  model.setLimit(6);
			  pageable = new PageRequest(0, 6);
		  }
	      model.setListResult(productService.findAll(pageable));
	      model.setTotalItem(productService.getTotalItem());
	      model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
	      mav.addObject("model", model);
	      return mav;
	   }
	
	@RequestMapping(value = "/dang-nhap", method = RequestMethod.GET)
	   public ModelAndView loginPage() {
	      ModelAndView mav = new ModelAndView("login");
	      return mav;
	   }
	@RequestMapping(value = "/thoat", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Check user info, if there is info then delete it
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		//return to home page
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/dang-nhap?accessDenied");
	}
	
	@RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
	   public ModelAndView signupPage(HttpServletRequest request) {
	      ModelAndView mav = new ModelAndView("signup");
	      if(request.getParameter("message") != null) {
	    	  Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
	    	  mav.addObject("message", message.get("message"));
	    	  mav.addObject("alert", message.get("alert"));
	      }
	      return mav;
	   }
}
