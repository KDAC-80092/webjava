package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;//give session factory

public class HibernaterUtils {
	private static SessionFactory factory;
	
	//static init block to create singleton SF
	//Configuration -->configure --> buildSessionFactory
	
	static
	{
		System.out.println("in static init block");
		//build SF
		factory=new Configuration()//empty config created
						.configure()//reads hibernate config xml file and populates
							.buildSessionFactory();//builds instance of SF from the populated 
		System.out.println("SF created.....");
	}				
	
	public static SessionFactory getFactory()
	{
		return factory;
	}
}
