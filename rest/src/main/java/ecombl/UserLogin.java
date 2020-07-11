package ecombl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

import entity.SellerInfo;

import org.hibernate.query.*;

import com.google.gson.Gson;

import Helper.ExecuteStoredProcedure;

public class UserLogin {

	public String UserLoginActivity(String UserName, String Password)
	{
		try {
			Metadata meta = new MetadataSources(common.ssr).getMetadataBuilder().build();  
			SessionFactory factory = meta.getSessionFactoryBuilder().build();  
			Session session = factory.openSession();  

			StringBuilder sb = new StringBuilder();
			
			sb.append("SELECT NEW entity.SellerInfo(s.email, s.mobile, s.user_code, s.shop_name, s.user_type) ");
			sb.append(" FROM SellerInfo s, SellerPassword p");
			sb.append(" where s.user_id = p.seller_id ");
			sb.append(" and s.email = :UserName ");
			sb.append(" and p.password = :password ");

			Query<SellerInfo> query = session.createQuery(sb.toString());
			query.setParameter("UserName", UserName);
			query.setParameter("password", Password);
			
			if(query.getResultList()!=null && query.getResultList().size()>0)
				return new Gson().toJson(query.getResultList().get(0));
			}
			catch (Exception e) {
				return e.toString();
			}
			return new Gson().toJson(new SellerInfo());
	}

	public Map<String, Object> UserRegistration(String user_type, String shop_name, String mobile, String email, String Password) 
	{
		Map<String, Object> obj = new HashMap<String, Object>();
		
		try {
			ExecuteStoredProcedure hb = new ExecuteStoredProcedure("user_registration");

			hb.addParameter("p_user_type", user_type, String.class, ParameterMode.IN);
			hb.addParameter("p_user_code", "", String.class, ParameterMode.IN);
			hb.addParameter("p_shop_name", shop_name, String.class, ParameterMode.IN);
			hb.addParameter("p_email", email, String.class, ParameterMode.IN);
			hb.addParameter("p_mobile", mobile, String.class, ParameterMode.IN);
			hb.addParameter("p_password", Password, String.class, ParameterMode.IN);
			hb.addParameter("out_userid", "", String.class, ParameterMode.OUT);
			hb.addParameter("out_usertype", "", String.class, ParameterMode.OUT);
			
			obj = hb.ExecuteAndReturnMultipleOutParameter();	
		}
		catch(Exception ex) {
			obj.put("Error", ex.toString());
		}
		return obj;
	}


	/*public String SaveSellerRegistration(String shop_name, String mobile, String email, String Password) 
	{
		String out_userid = "";
		Metadata meta = new MetadataSources(common.ssr).getMetadataBuilder().build();  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		
		Transaction t = session.beginTransaction();   
	    
		try 
	    {
			StoredProcedureQuery seller_registration = session.createStoredProcedureQuery("user_registration");
			
			seller_registration.registerStoredProcedureParameter("p_user_type", String.class, ParameterMode.IN);
			seller_registration.registerStoredProcedureParameter("p_uer_code", String.class, ParameterMode.IN);
			seller_registration.registerStoredProcedureParameter("p_shop_name", String.class, ParameterMode.IN);
			seller_registration.registerStoredProcedureParameter("p_email", String.class, ParameterMode.IN);
			seller_registration.registerStoredProcedureParameter("p_mobile", String.class, ParameterMode.IN);
			seller_registration.registerStoredProcedureParameter("p_password", String.class, ParameterMode.IN);
			seller_registration.registerStoredProcedureParameter("out_userid", String.class, ParameterMode.OUT);
			seller_registration.registerStoredProcedureParameter("out_usertype", String.class, ParameterMode.OUT);
		
			seller_registration.setParameter("p_user_type", "S");
			seller_registration.setParameter("p_uer_code", "");
			seller_registration.setParameter("p_shop_name", shop_name);
			seller_registration.setParameter("p_email", email);
			seller_registration.setParameter("p_mobile", mobile);
			seller_registration.setParameter("p_password", Password);
			
			if(seller_registration.executeUpdate() > 0)
			{
				
				t.commit();
				//out_userid = seller_registration.getOutputParameterValue("out_userid").toString();
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
    
		return out_userid;
	}*/
}
