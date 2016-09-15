package com.sda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.Team;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;

public class TeamTest {

	@Test
	public void testAddHeroToTeamFalse() {
		Team team = new Team(TeamType.RED);
		assertFalse(team.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("Artur", TeamType.BLUE)));
	}

	@Test
	public void testAddHeroToTeamTrue() {
		Team team = new Team(TeamType.RED);
		assertTrue(team.addHeroToTeam(HeroCreator.createHeroWithDefaultStats("Artur", TeamType.RED)));
	}

	@Test
	public void testGetTeamPower() {
		int health1 = 120, health2 = 110;
		int attack1 = 150, attack2 = 90;
		int defense1 = 90, defense2 = 160;

		Team teamBlue = new Team(TeamType.BLUE);
		Team teamGreen = new Team(TeamType.GREEN);

		teamBlue.addHeroToTeam(new SuperHero("Artur", new HeroStatistics(health1, attack2, defense1), TeamType.BLUE));
		teamBlue.addHeroToTeam(new SuperHero("Monika", new HeroStatistics(health2, attack2, defense2), TeamType.BLUE));
		teamBlue.addHeroToTeam(new SuperHero("Pawel", new HeroStatistics(health1, attack2, defense1), TeamType.BLUE));
		teamBlue.addHeroToTeam(new SuperHero("Tomek", new HeroStatistics(health1, attack2, defense1), TeamType.BLUE));
		teamBlue.addHeroToTeam(new SuperHero("Magda", new HeroStatistics(health1, attack2, defense1), TeamType.BLUE));

		teamGreen.addHeroToTeam(new Villain("Artur", new HeroStatistics(health2, attack1, defense2), TeamType.GREEN));
		teamGreen.addHeroToTeam(new Villain("Monika", new HeroStatistics(health2, attack1, defense2), TeamType.GREEN));
		teamGreen.addHeroToTeam(new Villain("Pawel", new HeroStatistics(health2, attack1, defense2), TeamType.GREEN));
		teamGreen.addHeroToTeam(new Villain("Tomek", new HeroStatistics(health1, attack2, defense2), TeamType.GREEN));
		teamGreen.addHeroToTeam(new Villain("Magda", new HeroStatistics(health1, attack2, defense2), TeamType.GREEN));

		int powerBlue = 4 * (defense1 + (attack2 + 50)) * health1 + (defense2 + (attack2 + 50)) * health2;
		int powerGreen = 3 * (health2 + attack1) * (defense2 + 50) + 2 * (health1 + attack2) * (defense2 + 50);
		assertEquals(teamBlue.getTeamPower(), powerBlue);
		assertEquals(teamGreen.getTeamPower(), powerGreen);
	}
}
