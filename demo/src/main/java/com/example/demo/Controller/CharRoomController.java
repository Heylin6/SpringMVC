package com.example.demo.Controller;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.Model.ChatClientModel;
import com.example.demo.Model.ServerResponseModel;

@Controller
public class CharRoomController {
	
	@GetMapping("/Chat")
    public String login(){

        return "chatRoom";
    }	
	
	@MessageMapping("/messageControl")
	@SendTo("/topic/getResponse")
		public ServerResponseModel said(ChatClientModel name) throws Exception{
			
			Thread.sleep(1000);			
			return new ServerResponseModel("read");
			//return new ServerResponseModel("歡迎來到," + respMessage);
	}
}
