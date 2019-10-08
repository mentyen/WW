package com.ww.steps;

import com.ww.utils.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	
	
	@Before
	public void start() {
		
		BaseClass.setUp();
	}
	
	
	@After
	public void finish() {
		
		BaseClass.tearDown();
		
	}

}
