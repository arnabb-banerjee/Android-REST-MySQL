package Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class ExecuteStoredProcedure {
	static StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
	private List<String> OutParaeterList;
	private SessionFactory factory;  
	private Session session;
	private StoredProcedureQuery seller_registration;
	
	public ExecuteStoredProcedure(String ProcedureName){
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		factory = meta.getSessionFactoryBuilder().build();  
		session = factory.openSession();  
		OutParaeterList = new ArrayList<String>();
		seller_registration = session.createStoredProcedureQuery(ProcedureName);
	}
	
	public void addParameter(String ParameterName, Object value, Class type, ParameterMode mode) {
		seller_registration.registerStoredProcedureParameter(ParameterName, type, mode);
		
		if(mode != ParameterMode.OUT) {
			seller_registration.setParameter(ParameterName, value);
		}
		
		if(mode != ParameterMode.IN) {
			OutParaeterList.add(ParameterName);
		}
	}
	
	@SuppressWarnings("unused")
	public Map<String, Object> ExecuteAndReturnMultipleOutParameter() 
	{
		Transaction t = session.beginTransaction();   
		Map<String, Object> hashmap = new HashMap<String, Object>();
		
		try 
	    {
			if(seller_registration.executeUpdate()>0)
			{
				t.commit();	
				
				/*if(OutParaeterList != null && OutParaeterList.size() > 0) {
					for(int i = 0; i < OutParaeterList.size(); i++)
					{
						hashmap.put(OutParaeterList.get(i), seller_registration.getOutputParameterValue("out_userid"));
					}
				}*/
			}
			else {
				t.rollback();
			}
		}
	    catch(JDBCException e)
	    {
	    	t.rollback();
	    	throw e;
	    }
		catch(Exception e)
	    {
	    	throw e;
	    }
	    finally 
	    {
		    session.close();    
	    	factory.close();
	    }
		
		if(hashmap == null) {
			hashmap = new HashMap<String, Object>();
			hashmap.put("Error", "No ouput has been generated, Ouput Parameter Size: "+ OutParaeterList.size());
		}
    
		return hashmap;
	}	
	
	public Object ExecuteAndReturnSingleOutParameter() 
	{
		Transaction t = session.beginTransaction();   
		Object value = null;
		
		try 
	    {
			if(seller_registration.executeUpdate()>0)
			{
				t.commit();
				if(OutParaeterList != null && OutParaeterList.size() > 0) {
					value = seller_registration.getOutputParameterValue(OutParaeterList.get(0));
				}
			}
			else {
				t.rollback();
			}
		}
	    catch(Exception e)
	    {
	    	t.rollback();
	    	throw e;
	    }
	    finally 
	    {
		    session.close();    
	    	factory.close();
	    }
    
		return value;
	}	

	public boolean Execute() 
	{
		Transaction t = session.beginTransaction();   
		boolean flag = false;
		
		try 
	    {
			if(seller_registration.executeUpdate()>0)
			{
				flag = true;
				
				t.commit();
			}
			else {
				t.rollback();
			}
		}
	    catch(Exception e)
	    {
	    	t.rollback();
	    	throw e;
	    }
	    finally 
	    {
		    session.close();    
	    	factory.close();
	    }
    
		return flag;
	}	
}
