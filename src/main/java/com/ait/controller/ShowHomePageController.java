package com.ait.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ait.command.UserCommand;
import com.ait.dto.UserDTO;
import com.ait.service.LoginMgmtService;

@Controller
public class ShowHomePageController {
	@Autowired
private LoginMgmtService Service;
	@GetMapping("/login.htm")
	public String ShowLoginFrom(@ModelAttribute("userCmd")UserCommand cmd) {
		return "show_from";	
	}
	@PostMapping("/login.htm")
	public String ShowResultPage(Map<String,Object>map,@ModelAttribute("userCmd")UserCommand cmd,BindingResult br) {
		UserDTO dto=null;
		String msg=null;
		//convert dto to cmd
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=Service.authentiction(dto);
		//keep result logic view name
		map.put("resMsg",msg);
		return "show_result";
		
	}
}
