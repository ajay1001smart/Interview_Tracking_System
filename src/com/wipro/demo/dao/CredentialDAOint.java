package com.wipro.demo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.demo.bean.CredentialBean;
import com.wipro.demo.bean.EmployeeBean;
@Repository("credentialDAO")
public class CredentialDAOint implements CredentialDAO {
	@Autowired
	SessionFactory sessionfac;
	public String register(CredentialBean bean)
	{
		bean.setStatus(0);
		sessionfac.getCurrentSession().save(bean);
		return "SUCCESS";
	
	}
	public String checkUser(CredentialBean bean)
	{
		String result=null;
		Criteria cr=sessionfac.getCurrentSession().createCriteria(CredentialBean.class);
		cr.add(Restrictions.and(Restrictions.like("username",bean.getUsername()), Restrictions.like("password",bean.getPassword())));
		ArrayList<CredentialBean> cerds=(ArrayList<CredentialBean>) cr.list();
			if(cerds.isEmpty())
			{
				result="FAIL";
				
			}
			else
			{
				CredentialBean bean1=(CredentialBean) sessionfac.getCurrentSession().get(CredentialBean.class,bean.getUsername());
				if(bean1.getStatus()==0)
				{
					bean1.setStatus(1);
					sessionfac.getCurrentSession().update(bean1);	
				result="SUCCESS";
			}
				else
				{
					result="EXIST";
				}
			
			}
		
		
		return result;
	}
	public String updateLoginStatus(CredentialBean credBean) {
		sessionfac.getCurrentSession().update(credBean);
		
		return "SUCCESS";
	}
	@SuppressWarnings("unchecked")
	public String addDept(EmployeeBean bean) {
		// TODO Auto-generated method stub
		int val=0;
		String id=null;
		String sql = "select emp_seq.nextval from dual";
		SQLQuery query = sessionfac.getCurrentSession().createSQLQuery(sql);
		ArrayList<BigDecimal> arr = (ArrayList<BigDecimal>) query.list();
		if(!arr.isEmpty())
		{
		id=bean.getEmpname().substring(0,2)+String.valueOf(arr.get(0));
		
		
		bean.setEmpid(id);
		sessionfac.getCurrentSession().save(bean);
		return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
	}
	public EmployeeBean fatchDept(String empid)
	{
		EmployeeBean bean=(EmployeeBean) sessionfac.getCurrentSession().get(EmployeeBean.class,empid);
		
		return bean;
	}
	public String update(EmployeeBean bean)
	{
		sessionfac.getCurrentSession().saveOrUpdate(bean);
		return "SUCCESS";
		
	}
	public String delete(EmployeeBean bean)
	{
		sessionfac.getCurrentSession().delete(bean);
		return "SUCCESS";
		
	}
	public ArrayList<EmployeeBean> viewAll()
	{
		Criteria c= sessionfac.getCurrentSession().createCriteria(EmployeeBean.class);
		ArrayList<EmployeeBean> dept=(ArrayList<EmployeeBean>) c.list();
		return dept;
		
	}

		
	}


