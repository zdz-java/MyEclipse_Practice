package com.zdz.springmvc.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.zdz.bean.User;

public class InfoFillWizardFormController extends AbstractWizardFormController{

	public InfoFillWizardFormController()
	{
		setCommandClass(User.class);
		setCommandName("user");
	}
	@Override
	protected ModelAndView processFinish(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		System.out.println(arg2);
		return new ModelAndView("redirect:success");
	}
	@Override
	protected Map referenceData(HttpServletRequest request, int page)
			throws Exception {
		 Map map = new HashMap();  
	        if(page==1) { //如果是填写学校信息页 需要学校类型信息  
	            map.put("schoolTypeList", Arrays.asList("高中", "中专", "大学"));  
	        }  
	        if(page==2) {//如果是填写工作信息页 需要工作城市信息  
	            map.put("cityList", Arrays.asList("济南", "北京", "上海"));  
	        }  
	        return map;  
	}
	@Override
	protected void validatePage(Object command, Errors errors, int page) {
//		为每一页提供检验
		super.validatePage(command, errors, page);
	}
	@Override
	protected void postProcessPage(HttpServletRequest request, Object command,
			Errors errors, int page) throws Exception {
//		每一页完成后的处理
		User user = (User)command;
		System.out.println(user);
		super.postProcessPage(request, command, errors, page);
	}
	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		System.out.println(command);
		return new ModelAndView("redirect:cancel");
	}
	
	
	
	

}
