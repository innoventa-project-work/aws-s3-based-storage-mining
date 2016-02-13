package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import VO.CityVO;
import VO.ExtensionVO;
import VO.countryVO;
import VO.stateVO;
public class stateDAO {
	

		public List searchCountry(countryVO countryVO) {
			
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
		
		public void InsertState(stateVO v)
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

		

		public List  SearchState(stateVO v2)
		{
			List l = null;
			try
			{
				SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				
				Session session =sessionFactory.openSession();
				
				Transaction tr = session.beginTransaction();
				
				Query w=session.createQuery("from stateVO ");
				
				l=w.list();
				
				tr.commit();
			}
			catch(Exception z)
			{
				z.printStackTrace();
			}
			return l;
		}
		public List EditState(stateVO v)
		{
			List l=null;
			try
			{
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				
				Session session=sessionFactory.openSession();
				
				Transaction tr=session.beginTransaction();
				
				Query w=session.createQuery("from stateVO where stateId='"+v.getStateId()+"'");
				
				l=w.list();
				
				tr.commit();
			}
			catch(Exception z)
			{
				z.printStackTrace();
			}
			return l;
		}
		public void UpdateState(stateVO v)
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

		public static void DeleteState(stateVO sv) {
			// TODO Auto-generated method stub
			try
			{
				SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
				
				Session session=sessionFactory.openSession();
				
				Transaction tr=session.beginTransaction();
				
				session.delete(sv);
				
				tr.commit();
			}
			catch(Exception z)
			{
				z.printStackTrace();
			}
		}

		
}

		
	

