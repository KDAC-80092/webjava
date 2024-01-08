package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;

import static com.app.utils.HibernaterUtils.getFactory;

import java.util.Scanner;
public class GetTeamMaxAgeAndWicketsTaken {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter team id:");
			TeamDao tDao=new TeamDaoImpl();
			System.out.println(tDao.getDetailById(sc.nextInt()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
