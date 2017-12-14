package com.wipro.demo.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.demo.bean.CredentialBean;
import com.wipro.demo.bean.EmployeeBean;
import com.wipro.demo.service.User;
@SessionAttributes("nav")
@Controller
public class UserController {
	@Autowired
	User user;
	SessionFactory sessionfac1;
	@RequestMapping("/goToSignup")
	public ModelAndView goToLogin(@ModelAttribute("cred")CredentialBean bean)
	{
		ModelAndView mview=new ModelAndView("register");
		return mview;
		
	}
	@RequestMapping("/login")
	public ModelAndView signup(@ModelAttribute("cred")CredentialBean bean)
	{
		int flag=1,flag1=0;
		ModelAndView modelAndView=null;
		String pass=bean.getPassword();
		String empid=bean.getEmpid();
		Map<String,String> model=new HashMap<String,String>();
		if(!(pass.contains("#") || pass.contains("$")))
		{
			model.put("msg","password must contain special character");
			 modelAndView=new ModelAndView("register",model);
			return modelAndView;
			
		}
		else if(pass.length()!=6)
		{
			model.put("msg","password must be of 6 char");
			 modelAndView=new ModelAndView("register",model);
			return modelAndView;
		}
		if(empid.length()!=5)
		{
			model.put("msg","password must be of 5 char");
			 modelAndView=new ModelAndView("register",model);
			return modelAndView;
		}
		else if((empid.charAt(0)>='a' && empid.charAt(0)<='z')||(empid.charAt(0)>='A' && empid.charAt(0)<='Z'))
		{
			
			
			for(int i=1;i<=4;i++)
			{
				if(!(empid.charAt(i)>=48 && empid.charAt(i)<=57))
				{
					model.put("msg","Last 4 digit must be enter");
					 modelAndView=new ModelAndView("register",model);
					return modelAndView;
					
				}
				
			}

		}
		else
		{
			model.put("msg","1st letter must be char");
			 modelAndView=new ModelAndView("register",model);
			return modelAndView;
			
		}
		
		
		String result=user.login(bean);
		if(result.equals("SUCCESS"))
		{
			modelAndView=new ModelAndView("login");
			
			
			
		}
		else
		{
			modelAndView=new ModelAndView("error");	
			modelAndView.addObject("nav",bean);
			
		}
		return modelAndView;
		
	}
	@RequestMapping("/goToLogin")
	public ModelAndView gotologin(@ModelAttribute("cred")CredentialBean bean)
	{
		ModelAndView mview=new ModelAndView("login");
		return mview;	
		
	}
	@RequestMapping("/Login")
	public ModelAndView login(@ModelAttribute("cred")CredentialBean bean)
	{
		ModelAndView modelAndView=null;
		String result=user.logincon(bean);
		System.out.println(result);
		if(result.equals("SUCCESS"))
		{
			modelAndView=new ModelAndView("home");
			modelAndView.addObject("nav",bean);
			
			
		}
		else if(result.equals("FAIL"))
		{
			modelAndView=new ModelAndView("error");
			modelAndView.addObject("nav",bean);
			
		}
		else if(result.equals("EXIST"))
		{
		
			modelAndView=new ModelAndView("error1");
			modelAndView.addObject("nav",bean);
			
		}
		return modelAndView;
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute("cred")CredentialBean bean ,WebRequest request,SessionStatus status,@ModelAttribute("nav") CredentialBean credentialBean)
	{
	
	
		
			credentialBean.setStatus(0);
			user.changeLoginStatus(credentialBean);
		
		status.setComplete();
		request.removeAttribute("nav",WebRequest.SCOPE_SESSION);
		ModelAndView mview=new ModelAndView("login");
		return mview; 
		
	}

	@RequestMapping(value="/add")
	public ModelAndView callFirst(@ModelAttribute("dept") EmployeeBean deptobj)
	{
		ModelAndView mView=new ModelAndView("add");
		return mView;
	}
	@RequestMapping(value="/add1")
	public ModelAndView insertDept(@ModelAttribute("dept") EmployeeBean deptObj){
		ModelAndView modelView=null;
		
		String result=user.insertDept(deptObj);
		if(result.equals("SUCCESS")){
			modelView=new ModelAndView("success");
		}else{
			modelView=new ModelAndView("adderror");
		}
		return modelView;
		
	}

	@RequestMapping(value="/selectid")
	public ModelAndView view(@ModelAttribute("dept") EmployeeBean deptObj)
	{
		ModelAndView mView=new ModelAndView("view");
		return mView;
	}
	@RequestMapping(value="/viewDept")
	public ModelAndView viewDept(@ModelAttribute("dept") EmployeeBean deptObj){
		deptObj=user.viewDept(deptObj.getEmpid());
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("dept",deptObj);
		ModelAndView mview=new ModelAndView("displayEmp",model);
		return mview;
		
		
	}
	@RequestMapping(value="/selectAll")
	public ModelAndView view(@ModelAttribute("dept") ArrayList<EmployeeBean> Alistbean)
	{
		Alistbean=user.viewAllDept();
		Map<String,Object> model=new HashMap<String, Object>();
		model.put("dept",Alistbean);
		ModelAndView mView=new ModelAndView("viewAll",model);
		return mView;
	}
	@RequestMapping(value="/updateDept")
	public ModelAndView updatedept(@ModelAttribute("dept") EmployeeBean deptbean,@RequestParam("ops")String operation)
	{ModelAndView modelView=null;
		if(operation.equals("update"))
	{
		
		String result=user.updateDept(deptbean);
		if(result.equals("SUCCESS"))
		{
			modelView=new ModelAndView("updatesucc");
		}else{
			modelView=new ModelAndView("errorupdate");
		}
	}
		
		else if(operation.equals("delete"))
		{
			String result=user.deleteDept(deptbean);
			if(result.equals("SUCCESS"))
			{
				modelView=new ModelAndView("deletesucc");
			}else{
				modelView=new ModelAndView("errordelete");
			}
			
		}
		
		return modelView;
	}
	

}
