package com.guigu.drug.fuyou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.drug.fuyou.dao.StaffLoginMapper;
import com.guigu.drug.fuyou.pojo.Staff;

@Service
public class StaffLoginServletImport implements StaffLoginServlet {
	@Autowired
	private StaffLoginMapper dao;

	@Override
	public Staff login(Staff username) {
	//	System.out.println(username.getUsername()+","+username.getPwd());
		//int loginexit = dao.loginexit(username);
		//System.out.println(loginexit);
		//if(loginexit>0) {
		//	System.out.println(dao.login(username));
			return dao.login(username);
		//}
		//return null;
	}

}
