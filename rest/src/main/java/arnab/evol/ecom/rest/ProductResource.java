package arnab.evol.ecom.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entity.ProductInfo;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("product")
public class ProductResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductInfo> GelProductList() {
        return new ecombl.ServiceProduct().GetProductList(0);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public ProductInfo GelProductDetails(@PathParam("id") long id) {
        return new ecombl.ServiceProduct().GetProductDetails(id);
    }   
    
    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String ProductSave(
    		@FormParam("prod_id") @DefaultValue("0") String prod_id, 
    		@FormParam("prod_name") @DefaultValue("0") String prod_name, 
    		@FormParam("prod_desc") @DefaultValue("0") String prod_desc, 
    		@FormParam("cat_Id") @DefaultValue("0") String cat_Id, 
    		@FormParam("div_id") @DefaultValue("0") String div_id, 
    		@FormParam("brand_id") @DefaultValue("0") String brand_id
    )
    {
    	try {
    		if(new ecombl.ServiceProduct().SaveProductMaster(
    				Long.parseLong(prod_id), prod_name, prod_desc, Long.parseLong(cat_Id), 
    				Long.parseLong(div_id), Long.parseLong(brand_id)))
    		{
    			return "Saved";
    		}
    		
        	return "not saved";
    	}
    	catch (Exception e) {
			return e.toString();
		}
 	}
}