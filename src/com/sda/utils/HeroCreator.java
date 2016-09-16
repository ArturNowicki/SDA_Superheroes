package com.sda.utils;

import java.util.Random;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;

public class HeroCreator {

	public static final String[] AVAILABLE_NAMES = { "Mark", "Tom", "Jackson", "Harry", "Barry" };

	public static SuperHero createHero(String name, HeroStatistics stats, TeamType team) {
		return new SuperHero(name, stats, team);
	}

	public static Villain createVillain(String name, HeroStatistics stats, TeamType team) {
		return new Villain(name, stats, team);
	}

	private static String pickRandomHeroName() {
		int index = new Random().nextInt(AVAILABLE_NAMES.length);
		return AVAILABLE_NAMES[index];
	}

	private static HeroStatistics generateRandomStats() {
		HeroStatistics randomStats = readDefaultHeroStatistics();
		int randomizationRange = Integer.parseInt(System.getProperty("config.randomizationRange"));
		Random rand = new Random();
		randomStats.addToAttack(rand.nextInt(2*randomizationRange)+1-randomizationRange);
		randomStats.addToDefense(rand.nextInt(2*randomizationRange)+1-randomizationRange);
		randomStats.addToHealth(rand.nextInt(2*randomizationRange)+1-randomizationRange);
		return randomStats;
	}

	private static HeroStatistics readDefaultHeroStatistics() {
		PropertyReader.loadPropertyValues();
		return new HeroStatistics(Integer.parseInt(System.getProperty("config.superHeroBaseHealth")),
				Integer.parseInt(System.getProperty("config.superHeroBaseAttack")),
				Integer.parseInt(System.getProperty("config.superHeroBaseDefence")));
	}

	public static AbstractHero createRandomHeroForSpecificTeam(TeamType team) {
		if (Math.random() < 0.5) {
			return createHero(pickRandomHeroName(), generateRandomStats(), team);
		} else {
			return createVillain(pickRandomHeroName(), generateRandomStats(), team);
		}
	}

	public static SuperHero createHeroWithDefaultStats(String name, TeamType team) {
		PropertyReader.loadPropertyValues();
		return createHero(name, readDefaultHeroStatistics(), team);
	}

	public static Villain createVillainWithDefaultStats(String name, TeamType team) {
		PropertyReader.loadPropertyValues();
		return createVillain(name, readDefaultHeroStatistics(), team);
	}

}
