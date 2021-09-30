package com.project.utilities;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.github.mkolisnyk.cucumber.reporting.CucumberUsageReporting;

import java.io.File;

public class Report  extends BasePage {

    public static void reportGen() throws Exception{
        CucumberResultsOverview results = new CucumberResultsOverview();
        results.setOutputDirectory("target/Report");
        results.setOutputName("cucumber-results");
        results.setSourceFile("./target/cucumber.json");
        results.executeFeaturesOverviewReport();

        CucumberUsageReporting report = new CucumberUsageReporting();
        report.setOutputDirectory("target/Report");
        report.setJsonUsageFile("./target/cucumber-usage.json");
        report.executeReport();

    }

    public static void reportHTML(){
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"//Report//report_config.xml"));
        Reporter.setSystemInfo("Project", "SG-Merge");
//        Reporter.setSystemInfo("Environment", BasePage.defaultEnv);
        Reporter.setSystemInfo("Executed By", System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
    }

}

