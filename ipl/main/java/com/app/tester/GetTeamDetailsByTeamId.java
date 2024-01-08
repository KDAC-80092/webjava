package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;

import static com.app.utils.HibernaterUtils.getFactory;

import java.util.Scanner;
public class GetTeamDetailsByTeamId {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in))
		{
			TeamDao tDao=new TeamDaoImpl();
			tDao.getMaxAgeAndWicketsTaken(40, 10).forEach(System.out::println);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
