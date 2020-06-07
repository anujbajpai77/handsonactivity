package com.ibm.casestudy.accountlogin.controller;


import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.ibm.casestudy.accountlogin.service.ProductService;

@Controller
public class HomeController {

    private static final int INITIAL_PAGE = 0;

    private final ProductService productService;
    
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public ModelAndView home(@RequestParam("page") Optional<Integer> page) {
    	HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Optional<Integer>> entity = new HttpEntity<Optional<Integer>>(page,headers);
    	//Page<Product> product = restTemplate.exchange("http://localhost:8071/home", HttpMethod.GET, entity, Page<Product>.class).getBody();
    	//Page<Product> product = restTemplate.getForEntity("http://localhost:8071/home", new TypeReference<Page<Product>>(){}.class);
    	//Pager pager = new Pager(product);

        ModelAndView modelAndView = new ModelAndView();
		/*
		 * modelAndView.addObject("products", products); modelAndView.addObject("pager",
		 * pager); modelAndView.setViewName("/home");
		 */
   	 	return modelAndView;
    }
	/*
	 * // Evaluate page. If requested parameter is null or less than 0 (to //
	 * prevent exception), return initial size. Otherwise, return value of // param.
	 * decreased by 1. int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE :
	 * page.get() - 1;
	 * 
	 * Page<Product> products = productService.findAllProductsPageable(new
	 * PageRequest(evalPage, 5)); Pager pager = new Pager(products);
	 * 
	 * 
	 */

}
