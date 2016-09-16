package com.sda.superheroes;

import com.sda.teams.TeamType;

public class SuperHero extends AbstractHero {

	public SuperHero(String name, HeroStatistics stats, TeamType team) {
		super(name, stats, team);
	}

	@Override
	public int getPower() {
		return (this.getStats().getAttack() + this.getStats().getDefense()) * this.getStats().getHealth();
	}

}
