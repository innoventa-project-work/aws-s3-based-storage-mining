package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;
import VO.countryVO;
import VO.stateVO;

public class CityDAO {
	

	public List searchState(countryVO cv) {
		
		List ls = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from stateVO where countryVO='"+cv.getId()+"'");
			ls=w.list();
			System.out.println("state list size :"+ls);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}
	
	

	public void InsertCity(CityVO v) {
		// TODO Auto-generated method stub
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
	public List SearchCity(stateVO v2) {
		// TODO Auto-generated method stub
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from CityVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	public List EditCity(CityVO v)
	{
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from CityVO where cid='"+v.getCid()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	public  void UpdateCity(CityVO v)
	{
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



	public List SearchCity(CityVO ctv) {
		// TODO Auto-generated method stub
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from CityVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	
	}



	public static List searchCountry(countryVO cv) {
		// TODO Auto-generated method stub
		List ls = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from countryVO");
			ls=w.list();
			System.out.println("country list size :"+ls);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}



	public static List loadState(countryVO countryVO) {
		// TODO Auto-generated method stub
		List ls = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from stateVO where cv='"+countryVO.getId()+"'");
			ls=w.list();
			System.out.println("state list size :"+ls);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}



	



	
}
