package com.sda.utils;

import com.sda.superheroes.HeroStatistics;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;
import com.sda.teams.TeamType;

public class HeroCreator {

	public static SuperHero createHero(String name, HeroStatistics stats, TeamType team) {
		return new SuperHero(name, stats, team);
	}

	public static Villain createVillain(String name, HeroStatistics stats, TeamType team) {
		return new Villain(name, stats, team);
	}

	public static SuperHero createHeroWithDefaultStats(String name, TeamType team) {
		PropertyReader.loadPropertyValues();
		return createHero(name,
				new HeroStatistics(Integer.parseInt(System.getProperty("config.superHeroBaseHealth")),
						Integer.parseInt(System.getProperty("config.superHeroBaseAttack")),
						Integer.parseInt(System.getProperty("config.superHeroBaseDefence"))),
				team);
	}

	public static Villain createVillainWithDefaultStats(String name, TeamType team) {
		PropertyReader.loadPropertyValues();
		return createVillain(name,
				new HeroStatistics(Integer.parseInt(System.getProperty("config.superHeroBaseHealth")),
						Integer.parseInt(System.getProperty("config.superHeroBaseAttack")),
						Integer.parseInt(System.getProperty("config.superHeroBaseDefense"))),
				team);
	}

}
