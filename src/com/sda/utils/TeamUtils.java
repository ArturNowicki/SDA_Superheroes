package com.sda.utils;

import com.sda.teams.Team;

public class TeamUtils {

	public static boolean isFirstTeamStrongerThanSecond(Team firstTeam, Team secondTeam) {
		return firstTeam.getTeamPower()>secondTeam.getTeamPower() ? true : false;
	}
	
//	public static Team generateRandomTeam() {
//		
//	}
}
