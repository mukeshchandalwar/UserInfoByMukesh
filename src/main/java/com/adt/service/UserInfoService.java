package com.adt.service;

import java.util.List;

import com.adt.model.UserInfo;

public interface UserInfoService {
	public void getAllUserEmail();
	public void sendMail(List<String> emails) ;
	public List<UserInfo> searchByEmail(String email);
}
