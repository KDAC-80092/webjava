package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;
import com.app.pojos.Team;

import static com.app.utils.HibernaterUtils.getFactory;

import java.util.Scanner;
public class AddTeamDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in))
		{
			TeamDao tDao=new TeamDaoImpl();
			System.out.println("Enter team details:");
			System.out.println("Enter team name:");
			String teamName=sc.nextLine();
			System.out.println("Enter team Abbrevation:");
			String abv=sc.nextLine();
			System.out.println("Enter team owner:");
			String owner=sc.nextLine();
			System.out.println("Enter max age:");
			int maxAge=sc.nextInt();
			System.out.println("Enter batting average:");
			double battingAvg=sc.nextDouble();
			System.out.println("Enter wickets taken:");
			int wicketsTaken=sc.nextInt();
			
			Team team=new Team(teamName, abv, owner, maxAge, battingAvg, wicketsTaken);
			
			System.out.println(tDao.addTeamDetails(team));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
