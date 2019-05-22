package com.guigu.drug.fuyou.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.guigu.drug.fuyou.pojo.Staff;
import com.guigu.drug.fuyou.service.StaffLoginServlet;
import com.guigu.drug.fuyou.service.StaffLoginServletImport;



public class Realm extends AuthorizingRealm{

	@Autowired
	private StaffLoginServlet service;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取Token对象
		UsernamePasswordToken token2=(UsernamePasswordToken) token;
		//String password = new String((char[])token2.getCredentials());
		//String hex = new Md5Hash(password,token2.getUsername()).toHex();
		//获取token对象中的name
		//String name=
	//	System.out.println(name);
		//获取name的盐值
		//ByteSource bytes=ByteSource.Util.bytes(token2.getUsername());
		//根据盐值加密
		// SimpleHash hash=new SimpleHash("MD5",token2.getPassword(), bytes, 1024);
		// System.out.println(hash.toString());
		// String pwd=hash.toString();
		//调用service中的登录方法
		 Staff st=new Staff();
		 st.setUsername(token2.getUsername());
		 Staff login =service.login(st);
		 if(login == null){
	            throw new UnknownAccountException(); //没找到账号
	        }
		//shiro认证
		
		
		/*
		 * SimpleHash pwd=new SimpleHash("MD5",token2.getPassword(),null,1024);
		 * System.out.println("加密后"+pwd);
		 */
		
		 
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
				login.getUsername(), login.getPwd(),getName());
		
		System.out.println("zzzzzzz"+login.getUsername()+",mmmmm"+login.getPwd()+",qqqqqq"+getName());
		return info;
	}
}
