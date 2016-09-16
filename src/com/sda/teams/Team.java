package com.sda.teams;

import java.util.ArrayList;

import com.sda.superheroes.AbstractHero;
import com.sda.superheroes.SuperHero;
import com.sda.superheroes.Villain;

public class Team {

	private TeamType type;
	private ArrayList<AbstractHero> heroesList;
	private int teamPower;
	private Side teamSide;

	public Team(TeamType type) {
		this.type = type;
		heroesList = new ArrayList<AbstractHero>();
		teamPower = getTeamPower();
		teamSide = Side.UNKNOWN;
	}

	private void updateTeamSide() {
		int heroesBanalce = 0;
		for (AbstractHero hero : heroesList) {
			if (hero instanceof Villain) {
				heroesBanalce--;
			} else if (hero instanceof SuperHero) {
				heroesBanalce++;
			}
		}
		switch (Integer.signum(heroesBanalce)) {
		case (1):
			teamSide = Side.GOOD;
			break;
		case (-1):
			teamSide = Side.EVIL;
			break;
		case (0):
			teamSide = Side.UNKNOWN;
			break;
		}
	}

	public Side getTeamSide() {
		return teamSide;
	}

	public void addHeroToTeam(AbstractHero hero) throws InvalidHeroTeamException {
		if (hero.getTeam().equals(type)) {
			heroesList.add(hero);
			updateTeamSide();
		} else {
			throw new InvalidHeroTeamException("Cannot add member of other team!");
		}
	}

	public void listTeamMembers() {
		for (AbstractHero hero : heroesList) {
			System.out.println(hero.getName());
		}
	}
	
	public int getTeamSize() {
		return heroesList.size();
	}

	public int getTeamPower() {
		for (AbstractHero hero : heroesList) {
			teamPower += hero.getPower();
		}
		return teamPower;
	}
	
	public TeamType getTeamType() {
		return type;
	}
}
