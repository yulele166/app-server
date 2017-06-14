package com.eauto100.app.server.member.service;



import com.eauto100.app.server.common.util.PageView;

public interface IMemberService{
	

	/**
	 * 检测手机是否已注册
	 * @param phonenum
	 * @return
	 */
	public boolean judgeMemberExist(String phonenum);
	/**
	 * 手机注册
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public  String register(String phone,String pwd);
	/**
	 * 手机登录验证
	 * @param phone
	 * @param pwd
	 * @return
	 */
	public boolean loginJudge(String phone,String pwd);
	/**
	 * 通过手机号获得guid
	 * @param phone
	 * @return
	 */
	public String getGuidByPhone(String phone);
}
