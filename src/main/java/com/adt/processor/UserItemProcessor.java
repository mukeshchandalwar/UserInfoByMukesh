package com.adt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.adt.model.UserInfo;
@Component
public class UserItemProcessor implements ItemProcessor<UserInfo, UserInfo> {

	@Override
	public UserInfo process(UserInfo item) throws Exception {
		
		return item;
	}

}
