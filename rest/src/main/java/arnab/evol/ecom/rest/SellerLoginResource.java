package arnab.evol.ecom.rest;


import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ecombl.SellerLogin;
import entity.SellerInfo;

@Path("/sellerlogin")
public class SellerLoginResource {


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UserLogin(
    		@FormParam("UserName") @DefaultValue("") String UserName, 
    		@FormParam("Password") @DefaultValue("") String Password) {
    	return new ecombl.SellerLogin().UserLogin(UserName, Password);
    }
    
    
    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UserRegistration(
    		@FormParam("shop_name") String shop_name, 
    		@FormParam("mobile") String mobile, 
    		@FormParam("email") String email,
    		@FormParam("Password") String Password)
    {
    	shop_name = shop_name == null ? "" : shop_name;
    	email = email == null ? "" : email;
    	mobile = mobile == null ? "" : mobile;
    	Password = Password == null ? "" : Password;

    	return new SellerLogin().SaveSellerRegistration(shop_name, mobile, email, Password).toString();
 	}
       
}