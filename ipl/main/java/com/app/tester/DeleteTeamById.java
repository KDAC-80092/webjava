package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;
import com.app.pojos.Team;

import static com.app.utils.HibernaterUtils.getFactory;

import java.util.Scanner;
public class DeleteTeamById {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in))
		{
			TeamDao tDao=new TeamDaoImpl();
			System.out.println("Enter team Id:");
			System.out.println(tDao.deleteTeamById(sc.nextInt()));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
