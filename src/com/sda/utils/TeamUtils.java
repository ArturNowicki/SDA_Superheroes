package com.sda.utils;

import com.sda.teams.Team;

public class TeamUtils {

	public static Team chooseStrongerTeam(Team firstTeam, Team secondTeam) {
		return firstTeam.getTeamPower()>secondTeam.getTeamPower() ? firstTeam : secondTeam;
	}
}
