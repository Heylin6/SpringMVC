package com.example.demo.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView exception(Exception ex,WebRequest request){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("errorSomething","somerror");
//		modelAndView.setViewName("error");
//		return modelAndView;
//	}
//	
//	//如果我們要讓所有的@RequestMapping擁有此鍵值
//	@ModelAttribute
//	public void addAttribute(Model md){
//		md.addAttribute("message","你可以設定一些錯誤訊息");
//	}	
//	
//	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Page is not Exist")
//	@ExceptionHandler(NullPointerException.class)
//	public ResponseEntity<Object> Not_Found() {
//		 	System.out.println("進入NullPointerException例外處理");
//		 	return new ResponseEntity<Object>(
//		          "NOT FOUND THE DATA ", new HttpHeaders(), HttpStatus.NOT_FOUND);
//		 }
}
