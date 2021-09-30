package com.project.cucumber.stepdefs;

import com.project.utilities.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import com.project.utilities.en;

public class Hooks extends BasePage implements en {

        @Before
        public void setUp() throws InterruptedException {

            System.out.println("Launch site");
                    System.out.println("Enter URL for environment");

            initialization(defaultEnv);

        }

        @After
        public void tearDown() throws Throwable {

            driver.quit();
            tempMapName_1 = "";
            tempMapName_2 = "";
            tempPlanName_1 = "";
            tempPlanName_2 = "";
            setTempTotalCards(0);
            tempTotalCards = 0;
            currentMapCards.clear();

            System.out.println("Closed the browser");
            Thread.sleep(6000);
        }


        @Given("^I navigated to  site \"([^\"]*)\" Environment$")
        public void I_navigated_to_site_Environment(String env) throws Throwable {

            initialization(env);

        }

        @Given("^I navigated to site$")
        public void I_navigated_to_site() throws Throwable {

            driver.get(baseURL);
        }
            @And("^I wait 3 secs$")
            public void I_wait_3_secs () throws Throwable {

                Thread.sleep(3000);

            }

            @And("^I wait 5 secs$")
            public void I_wait_5_secs () throws Throwable {

                Thread.sleep(5000);

            }
            @And("^I wait 10 secs$")
            public void I_wait_10_secs () throws Throwable {

                Thread.sleep(10000);
            }
            @And("^I refresh the current page$")
            public void And_I_refresh_the_current_page () throws Throwable {
                driver.manage().deleteAllCookies();
                driver.get(driver.getCurrentUrl());
                Thread.sleep(7000);
            }
        }

