package com.niit.shoptime.dao;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoptime.model.UserDetails;
@Repository(value = "userDetailsDAO")
public abstract class UserDetailsDAOImpl implements UserDetailsDAO{
 
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
		
	@Transactional
		public boolean save(UserDetails userDetails){
			try {
				sessionFactory.getCurrentSession().save(userDetails);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}
	@Transactional
		public boolean update(UserDetails userDetails){
			try {
				sessionFactory.getCurrentSession().update(userDetails);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
			@Transactional
		public boolean delete(UserDetails userDetails){
			try {
				sessionFactory.getCurrentSession().delete(userDetails);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
		}
			@Transactional
		public UserDetails get(String id){
			//select*from userDetails where id ="101"
			String hql ="from UserDetails where id = "+"'"+id+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<UserDetails> list = query.list();
			if(list == null){
				return null;
			}
			else{
			return list.get(0);
			}
}
			@Transactional
		public List<UserDetails>   list(){
			String hql ="from UserDetails";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			return query.list();
			
			
		}
	}

