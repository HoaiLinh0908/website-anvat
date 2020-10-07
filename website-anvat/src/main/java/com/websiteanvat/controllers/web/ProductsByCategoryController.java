package com.websiteanvat.controllers.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websiteanvat.dto.ProductDTO;
import com.websiteanvat.service.IProductService;
import com.websiteanvat.util.MessageUtil;
import com.websiteanvat.util.SecurityUtils;

@Controller
public class ProductsByCategoryController {
	@Autowired
	private IProductService productService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/productbycategory", method = RequestMethod.GET)
	   public ModelAndView homePage(@RequestParam(value = "page", required = false) Integer page,
			   						@RequestParam(value = "limit", required = false) Integer limit,
			   						@RequestParam(value = "code", required = false) String code) {
		  ProductDTO model = new ProductDTO();
		  ModelAndView mav = new ModelAndView("web/category");
		  Pageable pageable;
		  if(page != null && limit != null) {
			  model.setPage(page);
			  model.setLimit(limit);
			  pageable = new PageRequest(page-1, limit);
		  }else {
			  model.setPage(1);
			  model.setLimit(2);
			  pageable = new PageRequest(0, 2);
		  }
	      model.setListResult(productService.findByCategoryCode(code, pageable));
	      model.setTotalItem(productService.getTotalItemByCategoryCode(code));
	      model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
	      mav.addObject("code", code);
	      mav.addObject("model", model);
	      return mav;
	   }
	
	@RequestMapping(value = "/productdetails", method = RequestMethod.GET)
	   public ModelAndView showProduct(@RequestParam(value = "code", required = false) String code, HttpServletRequest request) {
		  ProductDTO model = productService.findByCode(code);
		  ModelAndView mav = new ModelAndView("web/productdetails");
		  if(request.getParameter("message") != null) {
	    	  Map<String,String> message = messageUtil.getMessage(request.getParameter("message"));
	    	  mav.addObject("message", message.get("message"));
	    	  mav.addObject("alert", message.get("alert"));
	      }
		  mav.addObject("model", model);
		  mav.addObject("code", code);
	      return mav;
	   }

}
