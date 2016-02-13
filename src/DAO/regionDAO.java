package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.regionVO;

public class regionDAO {

	public void insert(regionVO regionVO) {
		// TODO Auto-generated method stub

		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(regionVO);
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}

	public static List searchRegion(regionVO regionVO) {
		// TODO Auto-generated method stub
		List ls = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from regionVO");
			ls=w.list();
			System.out.println("region list size :"+ls);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}

	public static List editregion(regionVO regionVO) {
		// TODO Auto-generated method stub
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from regionVO where regionId='"+regionVO.getRegionId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}

	public static void UpdateRegion(regionVO regionVO) {
		// TODO Auto-generated method stub
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(regionVO);
			
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
	}
}

