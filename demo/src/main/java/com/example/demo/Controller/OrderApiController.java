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
import com.example.demo.Model.ResPackage.Result;
import com.example.demo.Model.ResPackage.ResultOrder;
import com.example.demo.Model.ResPackage.ResultLOrders;
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
	
	 @Autowired
	 private orderService orderS;
		
	 /** 
	  * 
	  * API : test
	  * 
	  **/
	 @RequestMapping(value={"/test"})
	 public Result test() {
		 
	     return setTestResult();
	 }
	 
	 
	 @RequestMapping(value={"/","/all"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public ResultLOrders getAllOrderList() {

		 ResultLOrders res = null;
		 List<Order> _orderL = orderS.getAllOrderList();
		 if(_orderL.size()>0)
		 {
			 res = orderS.setResultOrderList(_orderL,200,"ok",true);
			 return res;
		 }
		 else
		 {
			 res = orderS.setResultOrderList(null,99,"no data",false);
			 return res;
		 }		  
	 }
	 
	 @RequestMapping(value={"/{orderId}"},
			 produces={"application/json;charset=UTF-8"}, 
			 method = RequestMethod.GET)
	 @ResponseBody
	 public ResultOrder getOrder(@PathVariable long orderId) {
		 
		 ResultOrder res = null;
		 Optional<Order> _order = orderS.getOrder(orderId);
		 if(_order != null)
		 {
			 res = orderS.setResultOrder(_order,200,"ok",true);
			 return res;
		 }
		 else
		 {
			 res = orderS.setResultOrder(null,99,"no data",false);
			 return res;
		 }		 
	 }
	 
	 @RequestMapping(value={"/"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.POST)
	 @ResponseBody
	 public Result addOrder(@RequestBody Order order){
		 	
		 Result res = null;
		 orderS.save(order);
		 
		 res = orderS.setResult(null,200,"has save");
		 return res;
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.PUT)
	 @ResponseBody
	 public Result modifyOrderPut(@RequestBody Order order){		 
		 
		 Result res = null;
		 orderS.modify(order);	
		 
		 res = orderS.setResult(null,200,"has modify");
		 return res;
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.PATCH)
	 @ResponseBody
	 public Result modifyOrderPatch(@RequestBody Order order){		 	
		 
		 Result res = null;
		 orderS.modify(order);		 
		 
		 res = orderS.setResult(null,200,"has modify");
		 return res;
	 }
	 
	 @RequestMapping(value={"/{orderId}"}, 
			 consumes = MediaType.APPLICATION_JSON_VALUE, 
			 method = RequestMethod.DELETE)
	 @ResponseBody
	 public Result deleteOrder(@PathVariable long orderId) {
		 
		 Result res = null;
		 orderS.delete(orderId);		 
		 
		 res = orderS.setResult(null,200,"delete ok");
		 return res;
	 }
	 
}
