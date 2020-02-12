package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
	  	
		@Override
	    public void configureMessageBroker(MessageBrokerRegistry config) {
		  
	        config.enableSimpleBroker("/topic");
	    }

	    @Override
	    public void registerStompEndpoints(StompEndpointRegistry registry) {
	        registry.addEndpoint("/Sgs-guide-websocketS").withSockJS();
	        //registry.addEndpoint("/endpointChatRoom").withSockJS();
	        //上面命名用這段會RESPONSE不回來 懷疑是用到保留字
	    }
}