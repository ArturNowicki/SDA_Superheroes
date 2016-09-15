package com.sda.superheroes;

import com.sda.teams.TeamType;

public class Villain extends AbstractHero {

	public Villain(String name, HeroStatistics stats, TeamType team) {
		super(name, stats, team);
	}

	@Override
	public double getPower() {
		return (this.getStats().getHealth() + this.getStats().getAttack()) * this.getStats().getDefense();
	}

}
