package com.guigu.drug.fuyou.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * Shiro的配置类
 * @author lenovo
 *
 */
@Configuration
public class ShiroConfig {

	/**
	 * 创建ShiroFilterFactoryBean
	 *//**
	 * Shiro内置过滤器，可以实现权限相关的拦截器
	 *    常用的过滤器：
	 *       anon: 无需认证（登录）可以访问
	 *       authc: 必须认证才可以访问
	 *       user: 如果使用rememberMe的功能可以直接访问
	 *       perms： 该资源必须得到资源权限才可以访问
	 *       role: 该资源必须得到角色权限才可以访问
	 */
	@Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }

	
	
	@Bean                                                              
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		shiroFilterFactoryBean.setLoginUrl("/fuyou/login.html");
		//添加Shiro内置过滤器
		Map<String,String> filterMap = new LinkedHashMap<String,String>();
		/*filterMap.put("/add", "authc");
		filterMap.put("/update", "authc");*/
		
		filterMap.put("/*.js","anon");
		filterMap.put("/*.css", "anon");
		filterMap.put("/*.png","anon");
		filterMap.put("/*.jpeg","anon");
		filterMap.put("/*.jpg","anon");
		filterMap.put("/*.do","anon");
		filterMap.put("/wujunfan/login.*","anon");
		
		
		//放行login.html页面
		filterMap.put("/fuyou/login.html", "anon");
		filterMap.put("/web/stafflogin.do","anon");
		filterMap.put("/fangqi/YDmanagement/web/logout.do","logout");
		filterMap.put("/fuyou/login.jsp", "anon");
		
		//leading
		filterMap.put("/leading/borrow.html", "anon");
		filterMap.put("/leading/charge.html", "anon");
		filterMap.put("/leading/company.html", "anon");
		filterMap.put("/leading/data.html", "anon");
		filterMap.put("/leading/debt.html", "anon");
		filterMap.put("/leading/findpwd.html", "anon");
		filterMap.put("/leading/identification.html", "anon");
		filterMap.put("/leading/index.html", "anon");
		filterMap.put("/leading/jstlogin.html", "anon");
		filterMap.put("/leading/jstregister.html", "anon");
		filterMap.put("/leading/lenders.html", "anon");
		filterMap.put("/leading/main.html", "anon");
		filterMap.put("/leading/MyAccount.html", "anon");
		filterMap.put("/leading/MyInvest.html", "anon");
		filterMap.put("/leading/project.html", "anon");
		filterMap.put("/leading/query.html", "anon");
		filterMap.put("/leading/rememberpwd.html", "anon");
		filterMap.put("/leading/report.html", "anon");
		filterMap.put("/leading/risk.html", "anon");
		filterMap.put("/leading/security.html", "anon");
		filterMap.put("/leading/stated.html", "anon");
		filterMap.put("/leading/The.html", "anon");
		filterMap.put("/leading/updatepwd.html", "anon");
		filterMap.put("/leading/warning.html", "anon");
		
		//lizhiqiang
		filterMap.put("/lizhiqiang/lzqindex.html", "anon");
		filterMap.put("/lizhiqiang/lzqMyAccount.html", "anon");
		filterMap.put("/lizhiqiang/lzqMyInvest", "anon");
		filterMap.put("/lizhiqiang/NewFile.html", "anon");
		
		//前台请求
		filterMap.put("/web/selectaccontmoney.do", "anon");
		filterMap.put("/web/updateaccontmoney.do", "anon");
		filterMap.put("/web/selectcardno.do", "anon");
		filterMap.put("web/QueryRiskwarning.do", "anon");
		filterMap.put("web/QueryRiskwarningList.do", "anon");
		filterMap.put("web/QueryPlatformadvantageList.do", "anon");
		filterMap.put("web/QueryInvestmentList.do", "anon");
		filterMap.put("web/QueryRepaymentList.do", "anon");
		filterMap.put("web/QueryLoanapplicationList.do", "anon");
		filterMap.put("web/ContracttableList.do", "anon");
		filterMap.put("web/QueryApproveList.do", "anon");
		filterMap.put("web/QueryTassignorList.do", "anon");
		filterMap.put("/web/selectxinyufen.do", "anon");
		filterMap.put("/web/selectCradNo.do", "anon");
		filterMap.put("/web/report.do", "anon");
		filterMap.put("/wujunfan/Realname", "anon");
		filterMap.put("/findinvestments.do", "anon");
		filterMap.put("/web/QueryRiskwarningList.do", "anon");
		filterMap.put("/xiaojinqing/jiekuanhetong.html*", "anon");
		filterMap.put("/wujunfan/selectpayment*", "anon");
		filterMap.put("/wujunfan/selectpayment2*", "anon");
		filterMap.put("/wujunfan/selectRecharge*", "anon");
		filterMap.put("/wujunfan/selectRechargeCash*", "anon");
		filterMap.put("/web/QueryRepaymentList.do*", "anon");
		filterMap.put("/web/QueryLoanapplicationList.do*", "anon");
		filterMap.put("/web/ContracttableList.do*", "anon");
		filterMap.put("/web/QueryApproveList.do*", "anon");
		filterMap.put("/wujunfan/Rechearge*", "anon");
		filterMap.put("/wujunfan/RecheargeCash*", "anon");
		filterMap.put("/findinvestments.do*", "anon");
		filterMap.put("/web/QueryPlatformadvantageList.do*", "anon");
		filterMap.put("/findinvestmentbypid.do*", "anon");
		filterMap.put("/findtassignorbytid.do*", "anon");
		filterMap.put("/findinvestnotesbypid.do*", "anon");
		filterMap.put("/wujunfan/finduserbyuserid.do*", "anon");
		filterMap.put("/findquestion.do*", "anon");
		filterMap.put("/fangqi/calculator/counter.html*", "anon");
		filterMap.put("/wujunfan/finduserbyuserid.do*", "anon");
		filterMap.put("/web/stmtsel3.do*", "anon");
		filterMap.put("/web/invesel2.do*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("/findinvestmentbypid.do*", "anon");
		filterMap.put("/wujunfan/forgetPwd*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("/web/report.do*", "anon");
		filterMap.put("jstlogin.html*", "anon");
		filterMap.put("/findinvestments.do*", "anon");
		filterMap.put("/web/QueryRiskwarningList.do*", "anon");
		filterMap.put("/xiaojinqing/jiekuanhetong.html*", "anon");
		filterMap.put("/wujunfan/selectpayment*", "anon");
		filterMap.put("/wujunfan/selectpayment2*", "anon");
		filterMap.put("/wujunfan/selectRecharge*", "anon");
		filterMap.put("/wujunfan/selectRechargeCash*", "anon");
		filterMap.put("jstlogin.html*", "anon");
		filterMap.put("/web/QueryRepaymentList.do*", "anon");
		filterMap.put("/web/QueryLoanapplicationList.do*", "anon");
		filterMap.put("/web/ContracttableList.do*", "anon");
		filterMap.put("/web/QueryApproveList.do*", "anon");
		filterMap.put("/wujunfan/Rechearge*", "anon");
		filterMap.put("/wujunfan/RecheargeCash*", "anon");
		filterMap.put("/findinvestments.do*", "anon");
		filterMap.put("/web/QueryPlatformadvantageList.do*", "anon");
		
		
		filterMap.put("/wjf/jstregister.html", "anon");
		filterMap.put("/leading/jstlogin.html", "anon");
		filterMap.put("/leading/jstregister.html", "anon");
		filterMap.put("/leading/jstlogin.html", "anon");
		filterMap.put("/leading/jstregister.html", "anon");
		filterMap.put("/leading/jstlogin.html", "anon");
		filterMap.put("/leading/jstregister.html", "anon");
		
		
		filterMap.put("/fangqi/calculator/counter.html","anon");
		filterMap.put("/fangqi/Bootstrapday2/counter.html","anon");
		
		
		filterMap.put("/**","authc");
		 
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 创建DefaultWebSecurityManager
	 */
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")Realm Realm){
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		//关联realm
		securityManager.setRealm(Realm);
		return securityManager;
	}
	
	/**
	 * 创建Realm
	 */
	@Bean(name="userRealm")
	public Realm getRealm(){
		return new Realm();
	} 
	
	/**
	 * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
	 */
	@Bean
	public ShiroDialect getShiroDialect(){
		return new ShiroDialect();
	}
}
