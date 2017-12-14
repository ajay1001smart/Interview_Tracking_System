package com.wipro.demo.dao;

import java.util.ArrayList;

import com.wipro.demo.bean.CredentialBean;
import com.wipro.demo.bean.EmployeeBean;


public interface CredentialDAO {
	String register(CredentialBean bean);
	String checkUser(CredentialBean bean);
	String updateLoginStatus(CredentialBean credBean);
	String addDept(EmployeeBean deptnean);
	EmployeeBean fatchDept(String empid);
	public String update(EmployeeBean bean);
	public String delete(EmployeeBean bean);
	public ArrayList<EmployeeBean> viewAll();
	
}
