package com.eauto100.app.server.member.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eauto100.app.server.framework.util.StringUtil;
import com.eauto100.app.server.member.context.MySessionContext;
import com.eauto100.app.server.member.service.IMemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = "/member")
@Controller
public class MemberController {
//	static String KEY = "12345678";//密钥key
	static Logger logger = Logger.getLogger(MemberController.class.getName());
	@Autowired(required=true)
	private IMemberService memberService;
	@Value("#{configProperties['KEY']}")//从app.properties中读取服务器ip
	private String KEY;
	@Value("#{configProperties['URL_SERVER']}")//从app.properties中读取服务器ip
	private String url_server;
	
	@Value("#{configProperties['URL_REQUEST']}")//从app.properties中读取请求路径
	private String url_request;
	
	@RequestMapping(value = "/login" , produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(HttpServletRequest request) {
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String sign = request.getParameter("sign");
		Map<String, Object> m = new HashMap<>();
		String test = StringUtil.md5(phone+KEY);
		if(test.equals(sign)){
//		if(true){
			if(memberService.loginJudge(phone, pwd)){
				m.put("messagecode", 100);
				m.put("message", "成功");
				m.put("guid",memberService.getGuidByPhone(phone));
			}else{
				m.put("messagecode", 114);
				m.put("message", "登录用户名或密码不正确");
				m.put("guid","");
			}
		}else{
			m.put("messagecode", 113);
			m.put("message", "URL签名验证失败");
			m.put("guid","");
		}
		return JSONObject.toJSONString(m);
	}
	
	@RequestMapping(value = "/regcode", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String regcode(HttpServletRequest request){
		String phone = request.getParameter("phone");
		String sign = request.getParameter("sign");
		Map<String, Object> m = new HashMap<>();
		String test = StringUtil.md5(phone+KEY);
		String result = "";
		//签名验证
		if(test.equals(sign)){
			if(memberService.judgeMemberExist(phone)){
				String validcode ="";
				validcode=String.valueOf((int)((Math.random()*9+1)*100000));
				//发送短信(验证码)			
				try {
					// 新建url连接
					StringBuffer sb = new StringBuffer(url_server+url_request);
					sb.append("?type=1");//type参数
					sb.append("&phone=").append(phone);//phone参数
					sb.append("&content=").append(URLEncoder.encode("您的验证码为", "utf-8")).append(validcode).append(URLEncoder.encode(",有效期为60s", "utf-8"));//content参数
					URL url = new URL(sb.toString());
					// 打开url连接
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					// 设置url请求方式    get或者 post
					connection.setRequestMethod("POST");
					
					// 发送
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF8"));
					result = in.readLine().toString();
					ObjectMapper objectMapper = new ObjectMapper();
					Map<String, Object> map = objectMapper.readValue(result, Map.class);
					if(map.get("message").equals("成功")){
						m.put("validcode", validcode);
						m.put("messagecode", 100);
						m.put("message", "成功");
						HttpSession session = request.getSession();
						session.setAttribute("validcode", validcode);
						session.setAttribute("phone", phone);
						String sessionId=session.getId();
						m.put("sessionId", sessionId);
					}else{
						m.put("validcode", "");
						m.put("messagecode", 110);
						m.put("message", "发送验证码失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
					m.put("validcode", "");
					m.put("messagecode", 110);
					m.put("message", "发送验证码失败");
					return JSONObject.toJSONString(m);
				}
				
			}else{
				m.put("validcode", "");
				m.put("messagecode", 111);
				m.put("message", "手机号已被注册");
			}
		}else{
			m.put("validcode", "");
			m.put("messagecode", 113);
			m.put("message", "URL签名验证失败");
		}
		
		return JSONObject.toJSONString(m);
	}
	
	@RequestMapping(value = "/reg", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String reg(HttpServletRequest request){
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String validcode = request.getParameter("validcode");
		String sign = request.getParameter("sign");
		String sessionId = request.getParameter("sessionId");
		Map<String, Object> m = new HashMap<>();
		String test = StringUtil.md5(phone+pwd+validcode+KEY);
		//签名验证
		if(test.equals(sign)){
			String rightValicode = (String) MySessionContext.getSession(sessionId).getAttribute("validcode");
			String rightPhone=(String) MySessionContext.getSession(sessionId).getAttribute("phone");
			if(validcode.equals(rightValicode)&&phone.equals(rightPhone)){
				String guid=memberService.register(phone, pwd);
				m.put("guid", guid);
				m.put("messagecode", 100);
				m.put("message", "成功");
			}else{
				m.put("guid", "");
				m.put("messagecode", 112);
				m.put("message", "手机号与验证码不匹配");
			}
		}else{
			m.put("guid", "");
			m.put("messagecode", 113);
			m.put("message", "URL签名验证失败");
		}
		return JSONObject.toJSONString(m);
	}

}