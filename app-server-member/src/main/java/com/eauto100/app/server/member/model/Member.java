package com.eauto100.app.server.member.model;

import com.eauto100.app.server.framework.database.NotDbField;
import com.eauto100.app.server.framework.database.PrimaryKeyField;

public class Member implements java.io.Serializable {
	private Integer member_id;
	private Integer lv_id;
	private String uname;
	private String email;
	private String password;
	private Long regtime;
	private String pw_answer;
	private String pw_question;
	private String name;
	private Integer sex;
	private Long birthday;
	private Double advance;
	private Integer province_id;
	private Integer city_id;
	private Integer region_id;
	private String province;
	private String city;
	private String region;
	private String address;
	private String zip;
	private String mobile;
	private String tel;

	private int info_full;
	private int recommend_point_state;
	private Integer is_store;
	private Integer store_id;

	private Integer point;
	private String qq;
	private String msn;
	private String remark;
	private Long lastlogin;
	private Integer logincount;
	private Integer mp; // 消费积分
	// 会员等级名称，非数据库字段
	private String lvname;
	private Integer parentid; // 父代理商id
	private Integer agentid; // 代理商id
	private Integer is_cheked; // 是否已验证
	private String registerip; // 注册IP
	private String guid;
 
	
	//昵称
	private String nickname;
	//头像
	private String face;
	//身份
	private Integer midentity;
	//最后发送激活邮件的时间
	private Long last_send_email;
	
	private String find_code;
	/*******lijia***************************************************/
//	private EntMember ent_member_id;
//	
//	public EntMember getEnt_member_id() {
//		return ent_member_id;
//	}
//
//	public void setEnt_member_id(EntMember ent_member_id) {
//		this.ent_member_id = ent_member_id;
//	}
     /*******lijia************************************************/
	@PrimaryKeyField
	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer memberId) {
		member_id = memberId;
	}

	public Integer getLv_id() {
		// lv_id = lv_id==null?0:lv_id;
		return lv_id;
	}

	public void setLv_id(Integer lvId) {
		lv_id = lvId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRegtime() {
		return regtime;
	}

	public void setRegtime(Long regtime) {
		this.regtime = regtime;
	}

	public String getPw_answer() {
		return pw_answer;
	}

	public void setPw_answer(String pwAnswer) {
		pw_answer = pwAnswer;
	}

	public String getPw_question() {
		return pw_question;
	}

	public void setPw_question(String pwQuestion) {
		pw_question = pwQuestion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		sex= sex==null?-1:sex;
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	public Double getAdvance() {
		return advance;
	}

	public void setAdvance(Double advance) {
		this.advance = advance;
	}

	public Integer getProvince_id() {
		
		return province_id;
	}

	public void setProvince_id(Integer provinceId) {
		province_id = provinceId;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer cityId) {
		city_id = cityId;
	}

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer regionId) {
		region_id = regionId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getPoint() {
		if (point == null)
			point = 0;
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getMsn() {
		return msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	public Integer getMidentity() {
		return midentity;
	}

	public void setMidentity(Integer midentity) {
		this.midentity = midentity;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@NotDbField
	public String getLvname() {
		return lvname;
	}

	public void setLvname(String lvname) {
		this.lvname = lvname;
	}

	public Long getLastlogin() {
		return lastlogin;
	}

	public void setLastlogin(Long lastlogin) {
		this.lastlogin = lastlogin;
	}

	public Integer getMp() {
		return mp;
	}

	public void setMp(Integer mp) {
		this.mp = mp;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getIs_cheked() {
		return is_cheked;
	}

	public void setIs_cheked(Integer is_cheked) {
		this.is_cheked = is_cheked;
	}

	public Integer getLogincount() {
		return logincount;
	}

	public void setLogincount(Integer logincount) {
		this.logincount = logincount;
	}

	public Integer getAgentid() {
		return agentid;
	}

	public void setAgentid(Integer agentid) {
		this.agentid = agentid;
	}

	public String getRegisterip() {
		return registerip;
	}

	public void setRegisterip(String registerip) {
		this.registerip = registerip;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}


	public String getFind_code() {
		return find_code;
	}

	public void setFind_code(String find_code) {
		this.find_code = find_code;
	}



	public Long getLast_send_email() {
		return last_send_email;
	}

	public void setLast_send_email(Long last_send_email) {
		this.last_send_email = last_send_email;
	}

	public int getInfo_full() {
		return info_full;
	}

	public void setInfo_full(int info_full) {
		this.info_full = info_full;
	}

	public int getRecommend_point_state() {
		return recommend_point_state;
	}

	public void setRecommend_point_state(int recommend_point_state) {
		this.recommend_point_state = recommend_point_state;
	}

	public Integer getIs_store() {
		return is_store;
	}

	public void setIs_store(Integer is_store) {
		this.is_store = is_store;
	}
	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	

}
