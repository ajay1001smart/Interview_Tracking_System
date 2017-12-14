package com.wipro.demo.service;

import java.util.ArrayList;

import com.wipro.demo.bean.CredentialBean;
import com.wipro.demo.bean.EmployeeBean;

public interface User {

	String login(CredentialBean bean);
	String logincon(CredentialBean bean);
	String changeLoginStatus(CredentialBean credBean);
	public String insertDept(EmployeeBean deptObj);
	public EmployeeBean viewDept(String empid);
	public String updateDept(EmployeeBean credBean);
	public String deleteDept(EmployeeBean bean);
	public ArrayList<EmployeeBean> viewAllDept();
}
