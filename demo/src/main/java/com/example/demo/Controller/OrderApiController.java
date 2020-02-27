package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dao.OrderRepository;
import com.example.demo.Model.Order;
import com.example.demo.Model.Result;
import com.example.demo.Service.orderService;
import com.google.gson.Gson;

/**
 * 	寫法 : 請求 用 RequestParam , JPA , Repository
 * 	
 *  produces={"application/json;charset=UTF-8"}
 *  可以設定返回的response的媒體類型和文字的編碼,ex:返回為JSON格式,字元編碼為UTF-8
 *         
 *  consumes = MediaType.APPLICATION_JSON_VALUE       
 *   指定處理請求的類型（Content-Type），ex:application/json
 *   
 *   @PathVariable : 指定請求參數中要含有某一項參數
 */

@RestController
@RequestMapping("/OrderApi")
public class OrderApiController extends baseContoller {

	 private orderService orderS;
		
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @RequestMapping(value={"/test"})
	 public Result test() {
		 
	     return setTestFeedback();
	 }
	 
	 
	 @RequestMapping(value={"/"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public List<Order> getOrderList() {
		 	
		 return orderS.getAllOrderList();		 
	 }
	 
	 @RequestMapping(value={"/{orderId}"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public Optional<Order> getOrder(@PathVariable long orderId) {
		 
		 return orderS.getOrder(orderId);
	 }
	 
	 @RequestMapping(value={"/"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.POST)
	 @ResponseBody
	 public void addOrder(@RequestBody Order order){
		 	
		 orderS.save(order);		 
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.PUT)
	 @ResponseBody
	 public void modifyOrderPut(@RequestBody Order order){		 
		 	 
		 orderS.modify(order);		 
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.PATCH)
	 @ResponseBody
	 public void modifyOrderPatch(@RequestBody Order order){		 	
		 
		 orderS.modify(order);		 
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.DELETE)
	 @ResponseBody
	 public void deleteOrder(@PathVariable long orderId) {
		
		 orderS.delete(orderId);		 
	 }
	 
}
