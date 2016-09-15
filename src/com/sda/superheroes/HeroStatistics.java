
package com.sda.superheroes;

public class HeroStatistics {
	private int health;
	private int attack;
	private int defense;

	public HeroStatistics(int health, int attack, int defense) {
		this.health = health;
		this.attack = attack;
		this.defense = defense;
	}

	public int getHealth() {
		return health;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefense() {
		return defense;
	}

	public void addToHealth(int health) {
		this.health += health;
	}

	public void addToAttack(int attack) {
		this.attack += attack;
	}

	public void addToDefense(int defense) {
		this.defense += defense;
	}
}
