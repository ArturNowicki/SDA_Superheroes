package com.sda.superheroes;

import com.sda.teams.TeamType;

public abstract class AbstractHero {
	
	private String name;
	private HeroStatistics stats;
	private TeamType team;
	private static final int bonusValue = 50;

	public AbstractHero(String name, HeroStatistics stats, TeamType team) {
		this.name = name;
		this.stats = stats;
		this.team = team;
		switch (team) {
		case RED:
			stats.addToHealth(bonusValue);
			break;
		case BLUE:
			stats.addToAttack(bonusValue);
			break;
		case GREEN:
			stats.addToDefense(bonusValue);
			break;
		}
	}

	public String getName() {
		return name;
	}
	
	public HeroStatistics getStats() {
		return stats;
	}

	public TeamType getTeam() {
		return team;
	}

	public abstract int getPower();
	
}
