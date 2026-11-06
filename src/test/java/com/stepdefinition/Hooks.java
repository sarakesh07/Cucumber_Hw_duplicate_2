package com.stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void browserLaunch() {
		System.out.println("Before");
		}
	
	@After
	public void browserQuit() {
		System.out.println("After");
	}

}
