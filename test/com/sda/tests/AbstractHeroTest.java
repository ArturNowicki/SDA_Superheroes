package com.sda.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;

public class AbstractHeroTest {

	@Test
	public void testGetName() {
		AbstractHero hero = new SuperHero("MyHero", new HeroStatistics(100, 150, 120), TeamType.RED);
		AbstractHero villain = new Villain("MyVillain", new HeroStatistics(100, 150, 120), TeamType.RED);
		assertEquals(villain.getName(), "MyVillain");
		assertEquals(hero.getName(), "MyHero");
	}

	@Test
	public void testGetStats() {
		AbstractHero hero = new SuperHero("MyHero", new HeroStatistics(100, 150, 120), TeamType.RED);
		AbstractHero villain = new Villain("MyVillain", new HeroStatistics(120, 110, 100), TeamType.BLUE);
		assertTrue(hero.getStats().getHealth() == 150);
		assertTrue(hero.getStats().getAttack() == 150);
		assertTrue(hero.getStats().getDefense() == 120);
		assertTrue(villain.getStats().getHealth() == 120);
		assertTrue(villain.getStats().getAttack() == 160);
		assertTrue(villain.getStats().getDefense() == 100);
	}

	@Test
	public void testGetTeam() {
		AbstractHero hero = new SuperHero("MyHero", new HeroStatistics(100, 150, 120), TeamType.RED);
		AbstractHero villain = new Villain("MyVillain", new HeroStatistics(100, 150, 120), TeamType.GREEN);
		assertEquals(hero.getTeam(), TeamType.RED);
		assertEquals(villain.getTeam(), TeamType.GREEN);
	}

	@Test
	public void testGetPower() {
		AbstractHero hero = new SuperHero("MyHero", new HeroStatistics(110, 150, 120), TeamType.RED);
		AbstractHero villain = new Villain("MyVillain", new HeroStatistics(110, 150, 120), TeamType.RED);
		assertTrue(hero.getPower() == (150 + 120) * 160);
		assertTrue(villain.getPower() == (160 + 150) * 120);
	}
}
