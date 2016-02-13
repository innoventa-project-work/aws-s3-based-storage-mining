package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;
import VO.countryVO;
import VO.loginVO;
import VO.regVO;
import VO.stateVO;

public class regDAO {

	public static void InsertInfo(regVO rv) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(rv);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	
		
	}

	public static List SearchCountry(countryVO countryVO) {
		// TODO Auto-generated method stub
		List lscountry = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from countryVO");
			lscountry=w.list();
			System.out.println("country list size :"+lscountry);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return lscountry;
	}

	public static List SearchState(stateVO stateVO) {
		// TODO Auto-generated method stub
		List lsstate = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from stateVO");
			lsstate=w.list();
			System.out.println("state list size :"+lsstate);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return lsstate;
	}

	public static List SearchCity(CityVO cityVO) {
		// TODO Auto-generated method stub
		List lscity = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from CityVO");
			lscity=w.list();
			System.out.println("city list size :"+lscity);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return lscity;
	}

	public static List EditReg(regVO rv) {
		// TODO Auto-generated method stub
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from regVO where rid='"+rv.getRid()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}

	public static List SearchUser(regVO rv) {
		// TODO Auto-generated method stub
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from regVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}

	public static void UpdateReg(regVO regVO) {
		// TODO Auto-generated method stub
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(regVO);
		
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}

	public static void DeleteReg(regVO rv) {
		// TODO Auto-generated method stub
		
	}

	public static List loadCity(stateVO stateVO) {
		// TODO Auto-generated method stub
		List ls=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from CityVO where sv='"+stateVO.getStateId()+"'");
			
			ls=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;

	

}

	public static List loademail(loginVO loginVO) {
		// TODO Auto-generated method stub
		List ls=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from loginVO where email='"+loginVO.getEmail()+"'");
			
			ls=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}
}