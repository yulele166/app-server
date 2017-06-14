package com.eauto100.app.server.member.service.impl;


import java.util.Date;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import com.eauto100.app.server.framework.database.BaseSupport;
import com.eauto100.app.server.framework.util.DateUtil;
import com.eauto100.app.server.framework.util.StringUtil;
import com.eauto100.app.server.member.model.Member;
import com.eauto100.app.server.member.service.IMemberService;


@Service("memberService")
public class MemberService extends BaseSupport<Member> implements IMemberService {


	@Override
	public boolean judgeMemberExist(String phonenum) {
		boolean b =false;
		String sql = "select count(*) from es_member where mobile = ?";
		int count=this.daoSupport.queryForInt(sql, phonenum);
		if(count==0){
			b=true;
		}
		return b;
	}

	@Override
	public String register(String phone, String pwd) {
		Member member = new Member();
		member.setMobile(phone);
		member.setPassword(StringUtil.md5(pwd));
		long regtime = DateUtil.getDateline();
		member.setRegtime(regtime);
		String guid = regtime+""+((int)(Math.random()*9000+1000)+"");
		member.setGuid(guid);
		daoSupport.insert("es_member", member);
		return guid;
	}

	@Override
	public boolean loginJudge(String phone, String pwd) {
		String sql = "select count(*) from es_member where mobile=? and password=?";
		int count = daoSupport.queryForInt(sql, phone,StringUtil.md5(pwd));
		if(count==0){
			return false;
		}else{
			return true;
		}
		
	}

	@Override
	public String getGuidByPhone(String phone) {
		String sql = "select * from es_member where mobile = ?";
		Member m = daoSupport.queryForObject(sql, Member.class, phone);
		if(m!=null){
			return m.getGuid();
		}else{
			return null;
		}
	}
	
}
