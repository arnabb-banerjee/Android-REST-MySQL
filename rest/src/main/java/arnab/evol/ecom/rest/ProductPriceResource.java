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

import ecombl.common;
import entity.ProductPrice;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("productprice")
public class ProductPriceResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{prod_id}/{seller_id}")
    public List<ProductPrice> GetProductPriceList(
    		@PathParam("prod_id") long prod_id, 
    		@PathParam("seller_id") long seller_id) {
        return new ecombl.ServiceProduct().GetProductPriceList(prod_id, seller_id);
    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String SaveProductPrice(
    		@FormParam("prod_price_id") @DefaultValue("0") long prod_price_id, 
    		@FormParam("Qty") @DefaultValue("0") double Qty, 
			@FormParam("Unit") @DefaultValue("0") String Unit, 
			@FormParam("prod_id") @DefaultValue("0") long prod_id, 
			@FormParam("price_Buying") @DefaultValue("0") double price_Buying, 
			@FormParam("price_Packing") @DefaultValue("0") double price_Packing, 
			@FormParam("price_Delivery") @DefaultValue("0") double price_Delivery, 
			@FormParam("price_Making") @DefaultValue("0") double price_Making, 
			@FormParam("price_Service") @DefaultValue("0") double price_Service, 
			@FormParam("price_Storage") @DefaultValue("0") double price_Storage, 
			@FormParam("tax") @DefaultValue("0") double tax, 
			@FormParam("price_Total") @DefaultValue("0") double price_Total, 
			@FormParam("seller_code") @DefaultValue("0") String seller_code)
    {
    	try {
    		if(new ecombl.ServiceProduct().SaveProductPrice(
    				prod_price_id, 
    				Qty, 
    				Unit, 
    				prod_id, 
    				price_Buying, 
    				price_Packing, 
    				price_Delivery, 
    				price_Making, 
    				price_Service, 
    				price_Storage, 
    				tax, 
    				price_Total, 
    				seller_code))
    		{
    			return "Saved";
    		}
    	}
    	catch (Exception e) {
			common.ErrorLog("SaveProductPrice", e);
		}
		
    	return "not saved";
 	}
}