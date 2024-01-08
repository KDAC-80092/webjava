package com.app.tester;
import org.hibernate.*;
import static com.app.utils.HibernaterUtils.getFactory;

public class TestHibernate {
	public static void main(String[] args) {
	
		//Get the session factory from utils
		try(SessionFactory sf=getFactory())
		{
			System.out.println("Hibernate up and running");
		}//sf.close() --> Hibernate will auto clean up DBCP	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
