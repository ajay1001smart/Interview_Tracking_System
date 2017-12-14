package com.wipro.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.demo.bean.CredentialBean;
import com.wipro.demo.bean.EmployeeBean;
import com.wipro.demo.dao.CredentialDAO;

@Service("user")
public class UserImp implements User {
	@Autowired
	CredentialDAO creDAO;
	@Transactional(propagation=Propagation.REQUIRED)
	public String login(CredentialBean bean)
	{
		
		return creDAO.register(bean);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public String logincon(CredentialBean bean)
	{
		return creDAO.checkUser(bean);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public String changeLoginStatus(CredentialBean credBean) {
		// TODO Auto-generated method stub
		return creDAO.updateLoginStatus(credBean);
	}

	@Transactional (propagation=Propagation.REQUIRED)
	public String insertDept(EmployeeBean deptbean) {
		// TODO Auto-generated method stub
		return creDAO.addDept(deptbean);
	}
@Transactional (propagation=Propagation.REQUIRED)
	public EmployeeBean viewDept(String empid)
{
	return creDAO.fatchDept(empid);
}
@Transactional (propagation=Propagation.REQUIRED)
public String updateDept(EmployeeBean bean)
{
	return creDAO.update(bean);
}
@Transactional (propagation=Propagation.REQUIRED)
public String deleteDept(EmployeeBean bean)
{
 return creDAO.delete(bean);	
}
@Transactional (propagation=Propagation.REQUIRED)
public ArrayList<EmployeeBean> viewAllDept()
{
	return creDAO.viewAll();
}

	
}
