package com.boco.xxzx.ksh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@RequestMapping("listMenu")
	public String listMenu(){
		return "toolbar_all";
	}
}
