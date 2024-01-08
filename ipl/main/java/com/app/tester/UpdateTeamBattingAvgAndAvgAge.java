package com.app.tester;

import org.hibernate.SessionFactory;

import com.app.dao.TeamDao;
import com.app.dao.TeamDaoImpl;

import static com.app.utils.HibernaterUtils.getFactory;

import java.util.Scanner;
public class UpdateTeamBattingAvgAndAvgAge {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in))
		{
			TeamDao tDao=new TeamDaoImpl();
			System.out.println(tDao.updateMaxageAndBattingAvg("Chennai Kings", 45, 42.1));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
