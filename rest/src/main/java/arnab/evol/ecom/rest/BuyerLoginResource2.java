package arnab.evol.ecom.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ecombl.BuyerLogin;

@Path("/buyerlogin")
public class BuyerLoginResource2 {


	@POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UserLogin(
    		@FormParam("UserName") @DefaultValue("") String UserName, 
    		@FormParam("Password") @DefaultValue("") String Password) {
    	
        return new ecombl.BuyerLogin().UserLogin(UserName, Password);
    }
    
    
    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UserRegistration(
    		@FormParam("mobile") String mobile, 
    		@FormParam("email") String email,
    		@FormParam("Password") String Password)
    {
    	email = email == null ? "" : email;
    	mobile = mobile == null ? "" : mobile;
    	Password = Password == null ? "" : Password;

    	return new BuyerLogin().SaveBuyerRegistration(mobile, email, Password).toString();
 	}
       
}