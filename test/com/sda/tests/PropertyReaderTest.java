package com.sda.tests;

import org.junit.Test;

import com.sda.utils.PropertyReader;

public class PropertyReaderTest {

	@Test
	public void testReadPropertyFile(){
		PropertyReader.loadPropertyValues();
		System.out.println("Hero base name is: "+System.getProperty("config.superHeroBaseName"));
		System.out.println("Hero healty is: "+System.getProperty("config.superHeroBaseHealth"));
		System.out.println("Hero attack is: "+System.getProperty("config.superHeroBaseAttack"));
		System.out.println("Hero defense is: "+System.getProperty("config.superHeroBaseDefence"));
	}
}
