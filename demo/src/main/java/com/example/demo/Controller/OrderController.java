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

import com.example.demo.Business.orderBusiness;
import com.example.demo.Common.UserInfo;
import com.example.demo.Dao.OrderRepository;
import com.example.demo.Model.Order;
import com.example.demo.Model.Result;
import com.google.gson.Gson;

/**
 * 	寫法 : 請求 用 RequestParam , JPA , Repository
 * 	然後 JWT 做驗證
 *       註:還沒寫完 還差 JWT驗證
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
@RequestMapping("/Order")
public class OrderController extends baseContoller {

	
	@Autowired
	OrderRepository orderRepository;
		
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @RequestMapping(value={"/test"})
	 public Result test() {
		 
		 Result _result = new Result();
		 Map _user = null;
		 
		 _result.setdata(_user);
		 _result.setcode(200);
		 _result.setmsg("ok");
		 
	     return _result;
	 }
	 
	 /** 
	  * 
	  * API : test for Page(thymeleaf)
	  * 
	  **/
	 @RequestMapping(value={"/testforPage"})
	 public String testforPage() {
		 
		 Result _result = new Result();
		 Map _user = null;
		 
		 _result.setdata(_user);
		 _result.setcode(200);
		 _result.setmsg("ok");
		 
	     return "testforPage";
	 }
	 
	 /** 
	  * 
	  * API : Search orderlist
	  * 
	  **/
	 @RequestMapping(value={"/"},produces={"application/json;charset=UTF-8"}, method = RequestMethod.GET)
	 @ResponseBody
	 public List<Order> getUserList() {
		 	
		 return orderRepository.findAll();
	 }
	 
	 /** 
	  * 
	  * API : Search one order
	  * 
	  **/
	 @RequestMapping(value={"/{orderId}"},produces={"application/json;charset=UTF-8"}, method = RequestMethod.GET)
	 @ResponseBody
	 public Optional<Order> getUser(@PathVariable long orderId) {
		 	
		 return orderRepository.findById(orderId);
	 }
	 
	 /** 
	  * 
	  * API : insert order
	  * 
	  **/
	 @RequestMapping(value={"/"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	 @ResponseBody
	 public void addUser(@RequestBody Order order){
		 	
		 orderRepository.save(order);
	 }
	 
	 /** 
	  * 
	  * API : modify order
	  * 
	  **/
	 @RequestMapping(value={"/{orderId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	 @ResponseBody
	 public void modifyUserPut(@RequestBody Order order){
		 
		 orderRepository.save(order);
	 }
	 
	 /** 
	  * 
	  * API : modify order
	  * 
	  **/
	 @RequestMapping(value={"/{orderId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PATCH)
	 @ResponseBody
	 public void modifyUserPatch(@RequestBody Order order){		 	
		 
		 orderRepository.save(order);
	 }
	 
	 /** 
	  * 
	  * API : delete order
	  * 
	  **/
	 @RequestMapping(value={"/{orderId}"}, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	 @ResponseBody
	 public void deleteUser(@PathVariable long orderId) {
		
		 orderRepository.deleteById(orderId);
	 }
	 
}
