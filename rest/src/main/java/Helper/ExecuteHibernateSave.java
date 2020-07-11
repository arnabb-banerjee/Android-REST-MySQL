package Helper;

import java.util.List;

import org.eclipse.persistence.exceptions.QueryException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import ecombl.common;

public class ExecuteHibernateSave<T> {
	static StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	private SessionFactory factory;  
	private Session session;
	
	public ExecuteHibernateSave(){
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();  
		session = factory.openSession();  
	}
		
	public boolean Save(T obj) 
	{
		Transaction t = session.beginTransaction();   
		boolean flag = false;
		
		try 
	    {
			session.save(obj);
			flag = true;
			t.commit();	
		}
		catch(QueryException e)
	    {
	    	t.rollback();
	    	common.ErrorLog("Execute Helper >> Save", e);
	    }
		catch(org.hibernate.QueryException e)
	    {
	    	t.rollback();
	    	common.ErrorLog("Execute Helper >> Save", e);
	    }
		catch(Exception e)
	    {
	    	t.rollback();
	    	common.ErrorLog("Execute Helper >> Save", e);
	    }
		finally 
	    {
		    session.close();    
	    	factory.close();
	    }
		
		return flag;
	}	

	@SuppressWarnings("unchecked")
	public List<T> GetList(String SQL, Class type){
		return session.createQuery(SQL, type).getResultList();
	}

	@SuppressWarnings("unchecked")
	public T GetDetails(String SQL, long id, Class type){
		Query<T> query = session.createQuery(SQL);
		query.setParameter("id", id);
		if(query.getResultList()==null || (query.getResultList()!=null && query.getResultList().size()==0)) 
		{
			return null;
		}
		
		return query.getResultList().get(0);
	}
}
