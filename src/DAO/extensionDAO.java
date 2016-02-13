package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.ExtensionVO;
import VO.categoryVO;
import VO.countryVO;
import VO.stateVO;

public class extensionDAO {
	
	public  List searchCategory(categoryVO categoryVO) {
	List ls = null;
	try
	{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query w=session.createQuery("from categoryVO");
		ls=w.list();
		System.out.println("category list size :"+ls);
	}
	catch(Exception z)
	{
		z.printStackTrace();
	}
	return ls;

}
	
	public void InsertExtension(ExtensionVO v)
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

	public List  SearchExtension(ExtensionVO v2)
	{
		List l = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			Session session =sessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			Query w=session.createQuery("from ExtensionVO ");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	public List EditExtension(ExtensionVO v)
	{
		List l=null;
		try
		{
			SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction tr=session.beginTransaction();
			
			Query w=session.createQuery("from ExtensionVO where extensionId='"+v.getExtensionId()+"'");
			
			l=w.list();
			
			tr.commit();
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return l;
	}
	
	
	public  void UpdateExtension(ExtensionVO v)
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

	
}