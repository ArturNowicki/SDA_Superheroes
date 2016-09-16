package com.sda.utils;

import com.sda.teams.InvalidHeroTeamException;
import com.sda.teams.Team;
import com.sda.teams.TeamType;

public class TeamUtils {

	private static final int DEFAULT_TEAM_SIZE = 10;
	
	public static boolean isFirstTeamStrongerThanSecond(Team firstTeam, Team secondTeam) {
		return firstTeam.getTeamPower() > secondTeam.getTeamPower() ? true : false;
	}

	public static Team generateRedTeam() {
		return generateRandomTeam(TeamType.RED);
	}

	public static Team generateBlueTeam() {
		return generateRandomTeam(TeamType.BLUE);
	}

	public static Team generateGreenTeam() {
		return generateRandomTeam(TeamType.GREEN);
	}

	public static Team generateRandomTeam(TeamType type) {
		Team team = new Team(type);
		for (int ii = 0; ii < DEFAULT_TEAM_SIZE; ii++) {
			try {
				team.addHeroToTeam(HeroCreator.createRandomHeroForSpecificTeam(type));
			} catch (InvalidHeroTeamException e) {
				System.err.println("Error while creating random team. Hero type must be the same as team type!" + e.getMessage());
			}
		}
		return team;
	}

}
