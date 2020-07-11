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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ecombl.ServiceMasters;
import entity.BrandInfo;
import entity.CategoryInfo;
import entity.DivisionInfo;
import entity.UnitInfo;

@Path("master")
public class MasterResources {
	
	@GET
    @Path("unit")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UnitInfo> UnitList()
    {
    	return new ServiceMasters().GetUnitList();
 	}
	
	@GET
    @Path("brand")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BrandInfo> BrandList()
    {
    	return new entity.BrandInfo().GetList();
 	}
    
	@GET
    @Path("cat")
	@Produces(MediaType.APPLICATION_JSON)
    public List<CategoryInfo> CategoryList()
    {
    	return new entity.CategoryInfo().GetList();
 	}

    
	@GET
    @Path("div")
	@Produces(MediaType.APPLICATION_JSON)
    public List<DivisionInfo> DivisionList()
    {	
    	return new entity.DivisionInfo().GetList();
 	}

	@GET
    @Path("unit/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UnitInfo UnitDetails(
    		@PathParam("id") String id)
    {
    	return new ServiceMasters().GetUnitDetails(Long.parseLong(id));
 	}
    
	
	@GET
    @Path("brand/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BrandInfo BrandDetails(
    		@PathParam("id") String id)
    {
    	return new entity.BrandInfo().GetDetails(Long.parseLong(id));
 	}
    
	@GET
    @Path("cat/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryInfo CategoryDetails(
    		@PathParam("id") String id)
    {
    	return new entity.CategoryInfo().GetDetails(Long.parseLong(id));
 	}

    
	@GET
    @Path("div/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public DivisionInfo DivisionDetails(
    		@PathParam("id") String id)
    {
    	return new entity.DivisionInfo().GetDetails(Long.parseLong(id));
 	}

    
	@POST
    @Path("unit-save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String UnitSave(
    		@FormParam("id") String id,
    		@FormParam("name") String name,
    		@FormParam("country") int country)
    {
    	try {
    		name = name == null ? "" : name;
        	
    		if(new ServiceMasters().saveUnit(Long.parseLong(id), name, country))
    		{
    			return name;
    		}
    		
        	return "not saved";
    	}
    	catch (Exception e) {
			return e.toString();
		}
    	
    }
	
    @POST
    @Path("brand-save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String BrandSave(
    		@FormParam("id") String id,
    		@FormParam("name") String name)
    {
    	try {
    		name = name == null ? "" : name;
        	
    		if(new entity.BrandInfo().save(Long.parseLong(id), name))
    		{
    			return name;
    		}
    		
        	return "not saved";
    	}
    	catch (Exception e) {
			return e.toString();
		}
    	
    }
    
    @POST
    @Path("cat-save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String CategorySave(
    		@FormParam("id") String id,
    		@FormParam("name") String name)
    {
    	try {
    		name = name == null ? "" : name;
        	
    		if(new entity.CategoryInfo().save(Long.parseLong(id), name))
    		{
    			return name;
    		}
    		
        	return "not saved";
    	}
    	catch (Exception e) {
			return e.toString();
		}
 	}

    
    @POST
    @Path("div-save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_FORM_URLENCODED)
    public String DivisionSave(
    		@FormParam("id") String id,
    		@FormParam("name") String name)
    {
    	try {
    		name = name == null ? "" : name;
        	
    		if(new entity.DivisionInfo().save(Long.parseLong(id), name))
    		{
    			return name;
    		}
    		
        	return "not saved";
    	}
    	catch (Exception e) {
			return e.toString();
		}
 	}

}