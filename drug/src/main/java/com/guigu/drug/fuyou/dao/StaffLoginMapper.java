package com.guigu.drug.fuyou.dao;

import java.util.List;


import com.guigu.drug.fuyou.pojo.Staff;


public interface StaffLoginMapper {
    //登录
	Staff login(Staff username);
	//查询用户是否存在
	int loginexit(Staff username);
}
