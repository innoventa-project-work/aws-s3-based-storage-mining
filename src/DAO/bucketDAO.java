package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.bucketVO;
import VO.regionVO;

public class bucketDAO {

	public void InsertBucket(bucketVO bucketVO) {
		// TODO Auto-generated method stub
		
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.save(bucketVO);
			
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

	public static List SearchBucket(bucketVO bucketVO) {
		// TODO Auto-generated method stub
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from bucketVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
}

	

	public List EditBucket(bucketVO bucketVO) {
		// TODO Auto-generated method stub
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from bucketVO where id='"+bucketVO.getId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
}

	public void UpdateBucket(bucketVO bucketVO) {
		// TODO Auto-generated method stub
		
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			session.saveOrUpdate(bucketVO);
			
		
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
}
}