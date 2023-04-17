package com.adt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.adt.model.UserInfo;
import com.adt.repository.UserInfoRepository;
import com.adt.service.UserInfoService;
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoRepository infoRepository;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	public UserInfoServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	@Override
	public void getAllUserEmail() {
		List<String> emails=infoRepository.getAllEmail();
		sendMail(emails);
		
	}
	@Override
	@Async
	public void sendMail(List<String> emails) {
		System.out.println();
		for(String email: emails) {
			SimpleMailMessage mail=new SimpleMailMessage();
			mail.setTo(email);
			mail.setFrom("mukeshchandalwar.adt@gmail.com");
			mail.setSubject("Simple Message");
			mail.setText("Hi");
			javaMailSender.send(mail);
			System.out.println("Mail has been Sent");
		}
	}
	@Override
	public List<UserInfo> searchByEmail(String email) {
		List<UserInfo> list= infoRepository.searchUserByEmail(email);
		return list;
	}
}
