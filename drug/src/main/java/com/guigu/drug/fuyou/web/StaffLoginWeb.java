package com.guigu.drug.fuyou.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.guigu.drug.fuyou.pojo.Staff;
import com.guigu.drug.fuyou.service.StaffLoginServlet;

@RestController
public class StaffLoginWeb {
	@Autowired
	private StaffLoginServlet service;
	
	@RequestMapping("/web/stafflogin.do")
	public Staff login(Staff user,HttpServletRequest request){
		HttpSession session = request.getSession();
		Subject subject=SecurityUtils.getSubject();
		Staff lo=new Staff();
		if (!subject.isAuthenticated()){
			 UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPwd());
			 try{
				 subject.login(token);
				  lo = service.login(user);
				  session.setAttribute("staffinfo", lo);
				 return lo; 
			 }catch(AuthenticationException e) {
				 e.printStackTrace();
				 return null;
			 } 
		}else {
			Staff attribute = (Staff) session.getAttribute("staffinfo");
			System.out.println(attribute);
			return attribute;
		}
		
	}
	
	@Test
	public void T1(){
		System.out.println(new SimpleHash("MD5", "123456",null, 1024));
	}
}
