package arnab.evol.ecom.rest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import com.sun.jersey.multipart.FormDataParam;

import ecombl.ServiceProduct;
import ecombl.common;

@Path("prodimg")
public class ProductImageResource {
	
	/*@POST
	@Path("/upload")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.WILDCARD)
	public String uploadFile(
		@FormParam("image") Object uploadedInputStream) {

		try {
			return uploadedInputStream.toString();
		}
		catch (Exception e) {
			return e.toString();
		}
		
		
	}*/
	
	
    @POST
    @Path("upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response handleUpload(@FormDataParam("file") InputStream stream) throws Exception 
    {
    	try 
    	{
    		ByteArrayOutputStream baos = new ByteArrayOutputStream();

	  	      byte[] buffer = new byte[1000];
	  	      int wasRead = 0;
	  	      do 
	  	      {
	  	         wasRead = stream.read(buffer);
	  	         if (wasRead > 0) 
	  	         {
	  	            baos.write(buffer, 0, wasRead);
	  	         }
	  	      }while (wasRead > -1);
	  	      
	  	      byte[] fileData = baos.toByteArray();
	  	      
	  	      common.ErrorLog("Byte Array", new String(fileData, StandardCharsets.UTF_8));
	  	      
	  	      new ServiceProduct().SaveProductImage(0, 0, 0, fileData, "fileName", "fileType", 0, true);
    		
        }
    	catch (Exception e) 
    	{
        		common.ErrorLog("ProductImageResource >> handleUpload", e);
  		}
    	
    	return Response.ok(IOUtils.toString(stream)).build();
    }
}



class DataPart {
    private String fileName;
    private byte[] content;
    private String type;

    public DataPart() {}

    public DataPart(String name, byte[] data) {
        fileName = name;
        content = data;
    }

    String getFileName() { return fileName; }

    byte[] getContent() { return content; }

    String getType() { return type; }
}

