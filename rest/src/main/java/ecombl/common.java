package ecombl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class common {
	static StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	static String UploadDirectory = "C://uploadedFiles/";
	
	public static Date Today() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			return formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	
	
	public static void ErrorLog(String Module, Exception e)
	{
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter("c:/test/ErrorLog.txt", true));
			writer.newLine();
			writer.write(Module);
			writer.newLine();
			writer.write(e.toString());
		    writer.close();

		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
	}
	
	public static void ErrorLog(String Module, String e)
	{
	    try {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter("c:/test/ErrorLog.txt", true));
	    	writer.newLine();
			writer.write(Module);
			writer.newLine();
			writer.write(e.toString());
		    writer.close();

		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}  
	}

}


