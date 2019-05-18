@jobdescription
Feature: Simple creation of a job description


  As a manager
  I want to fill in a job description
  So that i can find potential candidates for the job

  Scenario: Create a job description
    Given there are 0 job descriptions in the system:
    Given A manager fills a job description with the following information:
      | title          | description                                              |
      | Java developer | Backend java developer for a spring boot web application |
    When The manager creates the new job description
    Then there are 1 job descriptions in the system:
    And that job contains the information:
      | title          | description                                              |
      | Java developer | Backend java developer for a spring boot web application |