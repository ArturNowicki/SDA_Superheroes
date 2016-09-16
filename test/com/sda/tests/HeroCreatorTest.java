package com.sda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;
import com.sda.utils.HeroCreator;
import com.sda.utils.PropertyReader;

public class HeroCreatorTest {

	@Test
	public void testCreateHero() {
		AbstractHero testHero = new SuperHero("Adam", new HeroStatistics(50, 10, 40), TeamType.RED);
		assertTrue(testHero.getName().equals("Adam"));
		assertTrue(testHero.getTeam().equals(TeamType.RED));
		assertEquals(testHero.getStats().getHealth(), 100);
		assertEquals(testHero.getStats().getAttack(), 10);
		assertEquals(testHero.getStats().getDefense(), 40);
	}

	@Test
	public void testCreateVillain() {
		AbstractHero testHero = new Villain("Adam", new HeroStatistics(50, 10, 40), TeamType.RED);
		assertTrue(testHero.getName().equals("Adam"));
		assertTrue(testHero.getTeam().equals(TeamType.RED));
		assertEquals(testHero.getStats().getHealth(), 100);
		assertEquals(testHero.getStats().getAttack(), 10);
		assertEquals(testHero.getStats().getDefense(), 40);
	}

	@Test
	public void testCreateHeroWithDefaultStats() {
		AbstractHero testHero = HeroCreator.createHeroWithDefaultStats("Tom", TeamType.BLUE);
		assertTrue(testHero.getName().equals("Tom"));
		assertTrue(testHero.getTeam().equals(TeamType.BLUE));
		assertEquals(testHero.getPower(), 25000);
	}

	@Test
	public void testCreateVillainWithDefaultStats() {
		AbstractHero testHero = HeroCreator.createVillainWithDefaultStats("Tom", TeamType.RED);
		assertTrue(testHero.getName().equals("Tom"));
		assertTrue(testHero.getTeam().equals(TeamType.RED));
		assertEquals(testHero.getPower(), 25000);
	}

	@Test
	public void testCreateRandomHeroForSpecificTeam() {
		PropertyReader.loadPropertyValues();
		int defaultAttack = Integer.parseInt(System.getProperty("config.superHeroBaseAttack"));
		int randomizationRange = Integer.parseInt(System.getProperty("config.randomizationRange"));
		AbstractHero testHero = HeroCreator.createRandomHeroForSpecificTeam(TeamType.RED);
		assertTrue(TeamType.RED.equals(testHero.getTeam()));
		assertTrue(Arrays.asList(HeroCreator.AVAILABLE_NAMES).contains(testHero.getName()));
//		zamiast tego mo¿na sprawdziæ czy h/a/d s¹ w odpowiednim przedziale wartoœci
		System.out.println(testHero.getName() + " " + testHero.getTeam() + " " + testHero.getStats());
//		itd dla pozosta³ych, ale jak sobie  poradziæ z losowoœci¹?
		assertTrue(testHero.getStats().getAttack()>defaultAttack-randomizationRange && testHero.getStats().getAttack()<defaultAttack+randomizationRange);
	}
}
