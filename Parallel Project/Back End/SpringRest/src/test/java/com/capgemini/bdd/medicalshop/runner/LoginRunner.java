package com.capgemini.bdd.medicalshop.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="features", glue={"com.capgemini.bdd.medicalshop"})
public class LoginRunner {
	
}
