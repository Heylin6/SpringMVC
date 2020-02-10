package com.example.demo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.Controller.MemberController;
import com.example.demo.Dao.MemberRepository;
import com.example.demo.Model.Member;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(MemberController.class)
@WebAppConfiguration
public class memberTest {
	
	@MockBean
	private MemberRepository memberRepository;
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	MockMvc mvc; //創建MockMvc類的物件
	@Autowired
	ObjectMapper objectMapper;
	
	Member member;
	
	@Before
	public void setup() {

		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}	
	
	@Test
	public void contextLoads() throws Exception {
			
		String uri = "/Member/1";		
	
		System.out.println("Heylin");		

		
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders
				.get(uri)
			.content(objectMapper.writeValueAsString(member))
			.accept(MediaType.APPLICATION_JSON))
			.andReturn();
	
		int status = result.getResponse()
				.getStatus();
		
		System.out.println("回傳結果 : "+result.getResponse()+"\n");
		System.out.println("回傳狀態 : "+status+"\n");
		//Assert.assertEquals("",200,status);
	}
}
