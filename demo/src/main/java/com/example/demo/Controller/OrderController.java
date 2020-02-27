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
	
	 private orderService orderS;
	 
	 @RequestMapping(value={"/testforPage"})
	 public String testforPage() {
		 		 
	     return "testforPage";
	 }
	 
	 @RequestMapping(value={"/"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public String getOrderList(Model model) {
		 	
		 List<Order> res =  orderS.getAllOrderList();
		 model.addAttribute("OrderList",res);
		 
		 return "OrderList";
	 }
	 
	 @RequestMapping(value={"/{orderId}"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public String getOrder(@PathVariable long orderId,Model model) {
		 
		 Optional<Order> res = orderS.getOrder(orderId);
		 model.addAttribute("Order",res);
		 
		 return "OrderDetail";
	 }
	 
	 @RequestMapping(value={"/"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.POST)
	 @ResponseBody
	 public String addOrder(@RequestBody Order order){
		 	
		 orderS.save(order);
		 return "OrderList";
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.PUT)
	 @ResponseBody
	 public String modifyOrderPut(@RequestBody Order order){
		 
		 orderS.modify(order);
		 return "OrderList";
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.PATCH)
	 @ResponseBody
	 public String modifyOrderPatch(@RequestBody Order order){		 	
		 
		 orderS.modify(order);
		 return "OrderList";
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.DELETE)
	 @ResponseBody
	 public String deleteOrder(@PathVariable long orderId) {
		
		 orderS.delete(orderId);
		 return "OrderList";
	 }
	 
}
