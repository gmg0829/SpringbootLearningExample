/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.topic;

import com.example.demo.bean.UserInfo;
import com.example.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
class Consumer {

	@Autowired
	UserInfoMapper userInfoMapper;

	@KafkaListener(topics = "testTopic")
	public void processMessage(SampleMessage message) {
//		JSONObject jsonObject=JSONObject.parseObject(message.getMessage());
//		String name=jsonObject.getString("name");
//		int id=jsonObject.getInteger("id");
//		int age=jsonObject.getInteger("age");
//		UserInfo userInfo=new UserInfo();
//		userInfo.setName(name);
//		userInfo.setUserId(id);
//		userInfo.setAge(age);
//		userInfoMapper.updateByUserid(userInfo);
			System.out.println("Received sample message [" + message + "]");
	}

}
