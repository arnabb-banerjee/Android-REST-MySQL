package arnab.evol.ecom.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/userlogin")
public class UserLoginResource {


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UserLogin(
    		@FormParam("UserName") @DefaultValue("") String UserName, 
    		@FormParam("Password") @DefaultValue("") String Password) {
    	return new ecombl.UserLogin().UserLoginActivity(UserName, Password);
    }
    
    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UserRegistration(
    		@FormParam("user_type") String user_type, 
    		@FormParam("shop_name") String shop_name, 
    		@FormParam("mobile") String mobile, 
    		@FormParam("email") String email,
    		@FormParam("Password") String Password)
    {
    	user_type = user_type == null ? "" : user_type;
    	shop_name = shop_name == null ? "" : shop_name;
    	email = email == null ? "" : email;
    	mobile = mobile == null ? "" : mobile;
    	Password = Password == null ? "" : Password;

    	return new ecombl.UserLogin().UserRegistration(user_type, shop_name, mobile, email, Password).toString();
 	}
       
}