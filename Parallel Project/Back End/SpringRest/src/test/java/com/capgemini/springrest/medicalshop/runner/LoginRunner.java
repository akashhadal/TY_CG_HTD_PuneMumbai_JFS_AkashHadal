package com.capgemini.springrest.medicalshop.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue={"com.capgemini.springrest.medicalshop"})
public class LoginRunner {
	
}
