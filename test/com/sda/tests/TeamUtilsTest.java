package com.sda.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.teams.InvalidHeroTeamException;
import com.sda.teams.Team;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;
import com.sda.utils.TeamUtils;

public class TeamUtilsTest {

	@Test
	public void testIsFirstTeamStrongerThanSecond() throws InvalidHeroTeamException {
		Team strongerTeam = new Team(TeamType.BLUE);
		Team weakerTeam = new Team(TeamType.GREEN);
		strongerTeam.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("Artur", TeamType.BLUE));
		strongerTeam.addHeroToTeam(new SuperHero("Michal", new HeroStatistics(50, 50, 50), TeamType.BLUE));
		weakerTeam.addHeroToTeam(new SuperHero("Tomasz", new HeroStatistics(50, 50, 50), TeamType.GREEN));
		assertTrue(TeamUtils.isFirstTeamStrongerThanSecond(strongerTeam, weakerTeam));
		assertFalse(TeamUtils.isFirstTeamStrongerThanSecond(weakerTeam, strongerTeam));
	}

	@Test
	public void testGenerateRedTeam() {
//		Team redTeam = TeamUtils.generateRedTeam();
		
	}

}
