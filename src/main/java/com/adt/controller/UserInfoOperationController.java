package com.adt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adt.model.UserInfo;
import com.adt.service.UserInfoService;

@Controller
public class UserInfoOperationController {
	@Autowired
	private UserInfoService infoService;
	@GetMapping("/search")
	public String searchByEmail(Map<String, Object>  map, @RequestParam("email") String email) {
		List<UserInfo> list=  infoService.searchByEmail(email);
		map.put("list", list);
		return "index.html";
	}
}
