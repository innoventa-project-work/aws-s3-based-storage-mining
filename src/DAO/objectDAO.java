package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import VO.bucketVO;
import VO.categoryVO;

public class objectDAO {

	public static List searchbucket(bucketVO bucketVO) {
		// TODO Auto-generated method stub
		List ls = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from bucketVO");
			ls=w.list();
			System.out.println("bucket list size :"+ls);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}

	public  List searchcategory(categoryVO categoryVO) {
		// TODO Auto-generated method stub
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

	public static List loadExtension(categoryVO categoryVO) {
		// TODO Auto-generated method stub
		List ls = null;
		try
		{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query w=session.createQuery("from ExtensionVO where ct='"+categoryVO.getId()+"'");
			ls=w.list();
			System.out.println("Extension list size :"+ls);
		}
		catch(Exception z)
		{
			z.printStackTrace();
		}
		return ls;
	}
}
