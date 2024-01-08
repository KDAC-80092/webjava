package com.app.dao;

import com.app.pojos.Team;
import org.hibernate.*;
import static com.app.utils.HibernaterUtils.getFactory;
import java.io.Serializable;
import java.util.List;
public class TeamDaoImpl implements TeamDao {

	@Override
	public String addTeamDetails(Team newTeam) {
		String message="Adding team failed";
		
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		
		//2.Begin transaction
		Transaction tx=session.beginTransaction();
		
		try
		{
			//Output						Inpute-->newTeam
			Serializable teamId=session.save(newTeam);
			tx.commit();
			message="Added new team to the table"+teamId;
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;	
		}
		return message;
	}

	@Override
	public List<Team> geTeamAbv() {
		
		List<Team> teams=null;
		
		String jpql="select new com.app.pojos.Team(teamId,abbreviation) from Team t";
		
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin transaction
		Transaction tx=session.beginTransaction();
		try
		{
			teams=session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;	
		}
		return teams;
	}

	@Override
	public Team getDetailById(int teamId) {
		Team team=null;
		
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin transaction
		Transaction tx=session.beginTransaction();
		try
		{
			team= session.get(Team.class, teamId);
			tx.commit();//
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;	
		}
		return team;
	}

	
	@Override
	public List<Team> getMaxAgeAndWicketsTaken(int maxAge,int wicketsTaken) {
		String jpql="select t from Team t where t.maxAge< :age and t.wicketsTaken > :wkts";
		List<Team> list=null;
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin transaction
		Transaction tx=session.beginTransaction();
		try
		{
			list = session.createQuery(jpql, Team.class)
					.setParameter("age", maxAge)
						.setParameter("wkts", wicketsTaken).getResultList();
			tx.commit();
		}
		catch(RuntimeException e)
		{
		if(tx!=null)
			tx.rollback();
		throw e;	
		}
		return list;
	}

	@Override
	public String updateMaxageAndBattingAvg(String name,int maxAge,double battingAverage) {
		String message="Failed updation";
		Team team=null;
		String jpql="select t from Team t where t.name=:name";
		//1.Get session from SF
		Session session=getFactory().getCurrentSession();
		//2.Begin transaction
		Transaction tx=session.beginTransaction();
		try
		{
//			Query<Team> query=session.createQuery(jpql);
//			query.setParameter("name", name);
//			Object result=query.getSingleResult();
//			team=(Team)result;
			
			team=session.createQuery(jpql,Team.class).setParameter("name",name).getSingleResult();
			team.setBattingAvg(battingAverage);
			team.setMaxAge(maxAge);
			tx.commit();
			message="Team Update successfully";
		}
		catch(RuntimeException e)
		{
				if(tx!=null)
					tx.rollback();
		throw e;	
		}
		return message;
	}

	@Override
	public String deleteTeamById(int id) {
		String message="Deletion failed";
		Session session=getFactory().getCurrentSession();
		//2.Begin transaction
		Transaction tx=session.beginTransaction();
		try
		{
			Team team=session.get(Team.class, id);
			session.delete(team);
			tx.commit();
			if(team!=null)
				message="Deletion done";
		}
		catch(RuntimeException e)
		{
		if(tx!=null)
			tx.rollback();
		throw e;	
		}
		return message;
	}

	
	
}
