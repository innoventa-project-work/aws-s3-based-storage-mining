package DAO;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.categoryVO;
import VO.countryVO;

public class countryDAO {
	public void InsertCountry(countryVO v)
	{
		
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(v);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
	
	public List  SearchCountry(countryVO v1)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from countryVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}

	public static List editcountry(countryVO cv) {
		// TODO Auto-generated method stub
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from countryVO where id='"+cv.getId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}

	public static void UpdateCountry(countryVO v) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(v);
			
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
	}

	public static void DeleteCountry(countryVO cv) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.delete(cv);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		
	}
		
	}
	

	

