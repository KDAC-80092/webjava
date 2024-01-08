package com.app.dao;

import java.util.List;

import com.app.pojos.Team;

public interface TeamDao {
	//add a method to insert team details
	String addTeamDetails(Team newTeam);
	List<Team> geTeamAbv();
	Team getDetailById(int teamId);
	List<Team> getMaxAgeAndWicketsTaken(int maxAge,int wicketsTaken);
	String updateMaxageAndBattingAvg(String name,int maxAge,double battingAverage);
	String deleteTeamById(int id);
}
