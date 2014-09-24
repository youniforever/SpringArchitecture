package com.spring_arch.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_arch.common.lib.message.MessageSetter;
import com.spring_arch.common.lib.network.RestclientService;

@Controller
public class TestController {
	@Resource(name="RestclientService")
	RestclientService restClientService;
	
	@Resource(name = "MessageSetter")
	private MessageSetter messageSetter;
	
	@RequestMapping(value="/getJson")
	public String getJson(Model model) {
		List<Object> list = null;
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		list = new ArrayList<Object>();
		list.add("1번");
		list.add("2번");
		list.add("3번");
		list.add("4번");
		map.put("1반", list);
		
		list = new ArrayList<Object>();
		list.add("1번");
		list.add("2번");
		list.add("3번");
		list.add("4번");
		map.put("2반", list);
		
		messageSetter.message0000(model, map);
		
		return "jsonViewer";
	}
	/*
	@RequestMapping(value="/reqJson")
	public String reqJson(Model model) throws Exception {
		
		HashMap<String, String> getResp = restClientService.restGet("http://localhost:8080/getJson", new HashMap<String,String>(), 0);
		if ( getResp.get("status").equals("200") ) {
			String response = getResp.get("response");
			JSONObject responseJson = JSONObject.fromObject(response);
			
//			String a = responseJson.get("data").toString().replaceAll("\"", "\\\\\"");
			String a = "{\"2반\":[\"1번\",\"2번\",\"3번\",\"4번\"],\"1반\":[\"1번\",\"2번\",\"3번\",\"4번\"]}";
//			JSONObject aJsonArray = JSONObject.fromObject(a);
//			System.out.println(aJsonArray.toString());
//			JSONObject aJsonEl = aJsonArray.toJSONArray(aJsonArray);
//			JSONObject aJson = JSONObject.fromObject(aJsonEl.get("2반"));
			
			String t = "{\"2반\":[\"1번\",\"2번\",\"3번\",\"4번\"],\"1반\":[\"1번\",\"2번\",\"3번\",\"4번\"]}";
			JSONObject aJson = JSONObject.fromObject(t);
			
			model.addAttribute("response", aJson);
		}
		else {
			model.addAttribute("response", getResp);
		}

		return "jsonViewer";
	}
	*/
}
