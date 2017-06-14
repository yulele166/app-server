package com.eauto100.app.server.repair.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eauto100.app.server.framework.util.StringUtil;
import com.eauto100.app.server.repair.service.impl.RepairService;
@RequestMapping(value = "/repair")
@Controller
public class RepairController {
	static Logger logger = Logger.getLogger(RepairController.class.getName());
	static String KEY = "12345678";//密钥key
	@Autowired
	private RepairService repairService;
	
	@RequestMapping(value = "/login")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/getrepairtype",method=RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getrepairtype(HttpServletRequest request) {
		String guid = request.getParameter("guid");
		String sign = request.getParameter("sign");
		Map<String, Object> m = new HashMap<>();
		String test = "";
		if(guid!=null){
			test=StringUtil.md5(guid+KEY);
		}else{
			test=StringUtil.md5(KEY);
		}
		
		List list = new ArrayList<>();
//		if(true){
		if(test.equals(sign)){
			list=this.repairService.getList();
			m.put("messagecode", 100);
			m.put("message", "成功");
			m.put("repairtype", list);
		}else{
			m.put("messagecode", 113);
			m.put("message", "失败");
			m.put("repairtype", list);
		}
		System.out.println(JSONObject.toJSONString(m));
		return JSONObject.toJSONString(m);
	}	
}
