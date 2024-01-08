package com.app.pojos;

//all annotations are inside this pkg
import javax.persistence.*;
/*
 * create table teams (team_id int primary key auto_increment,name varchar(100),
 * abbrevation varchar(10),owner varchar(20),max_age int,
 * batting_avg double,wickets_taken int);
 * */

@Entity
@Table(name="teams")
public class Team {
	//Recommendation: Make ID property explicitly serializable(All wrapper classes are serializable)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
	@Column(name = "id")
	private Integer teamId;
	@Column(length = 100,unique = true)
	private String name;
	@Column(length = 10,unique = true)
	private String abbreviation;
	@Column(length = 20)
	private String owner;
	@Column(name = "max_age")
	private int maxAge;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wickets_taken")
	private int wicketsTaken;
	
	public Team() {

	}

	public Team(Integer teamId, String abbreviation) {
		super();
		this.teamId = teamId;
		this.abbreviation = abbreviation;
	}

	public Team(String name, String abbreviation, String owner, int maxAge, double battingAvg, int wicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", battingAvg=" + battingAvg + ", wicketsTaken=" + wicketsTaken + "]";
	}
	
	
}
