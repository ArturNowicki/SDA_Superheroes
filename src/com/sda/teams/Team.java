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

	private void updateTeamSide(AbstractHero hero) {
		if(hero instanceof Villain) {
			teamSide = Side.EVIL;
		}
		if(hero instanceof SuperHero) {
			teamSide = Side.GOOD;
		}
	}

	public Side getTeamSide() {
		return teamSide;
	}

	public boolean addHeroToTeam(AbstractHero hero) {
		if(hero.getTeam().equals(type)) {
			heroesList.add(hero);
			updateTeamSide(hero);
			return true;
		} else {
			System.out.println("Cannot add member of other team!");
			return false;			
		}
	}

	public void listTeamMembers() {
		for (AbstractHero hero : heroesList) {
			System.out.println(hero.getName());
		}
	}
	
	public int getTeamPower() {
		for (AbstractHero hero : heroesList) {
			teamPower += hero.getPower();
		}
		return teamPower;
	}
}
