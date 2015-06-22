package com.app.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;
import com.app.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	   public String login() {
		return "loginPage";

	   }
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public String registration()
	{
		
		return "redirect:/pages/index.html";
	}
	
	@RequestMapping(value="/pages/secured/profile")
	public String profile(Principal principal, Model model)
	{
		
		User user = service.getUser(principal.getName());
		List<User> listUsers = service.getAllMerchants();
		model.addAttribute("user", user);
		model.addAttribute("listUsers", listUsers);
		return "pages/secured/profile";
	}
	
	  @RequestMapping(value = "/logoutPage", method = RequestMethod.GET)
	    public String logoutPage() {
	        return "logoutPage";
	    }
	
	/*@RequestMapping(value="/registrationConfirmation.html")
	public String login(Principal principal, Model model)
	{
		
		model.addAttribute("user", principal.getName());
		return "pages/secured/profile";
	}*/
	
	@RequestMapping(value="/registrationConfirmation.html", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user , BindingResult bindingResult)
	{
		
		if(bindingResult.hasErrors())
		{
			ModelAndView mView = new ModelAndView("registration");
			return mView;
		}
		service.addUser(user);
		ModelAndView modelAndView = new ModelAndView("pages/secured/profile");
		return modelAndView;
	}
	
}
