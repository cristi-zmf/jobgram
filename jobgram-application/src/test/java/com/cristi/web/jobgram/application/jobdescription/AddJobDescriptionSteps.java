package com.cristi.web.jobgram.application.jobdescription;

import com.cristi.web.jobgram.application.ApplicationConfig;
import com.cristi.web.jobgram.domain.jobdescription.InMemoryJobDescriptions;
import com.cristi.web.jobgram.domain.jobdescription.JobDescription;
import com.cristi.web.jobgram.domain.jobdescription.JobDescriptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = ApplicationConfig.class)
public class AddJobDescriptionSteps {
    private final JobDescriptions inMemoryJobDescriptions;
    private final AddJobDescription sut;
    private AddJobDescriptionCommand jobDescriptionCreationCommand;

    public AddJobDescriptionSteps() {
        this.inMemoryJobDescriptions = new InMemoryJobDescriptions();
        this.sut = new AddJobDescription(inMemoryJobDescriptions);
    }

    @Given("^there are (\\d+) job descriptions in the system:$")
    public void thereAreJobDescriptionsInTheSystem(int numberOfJobDescriptionsInTheSystem) {
        assertThat(inMemoryJobDescriptions.findAll()).hasSize(numberOfJobDescriptionsInTheSystem);
    }

    @Given("^A manager fills a job description with the following information:$")
    public void aManagerFillsAJobDescriptionWithTheFollowingInformation(List<JobDescriptionInfoCucumberDto> jobDescriptionInfo) {
        jobDescriptionCreationCommand = jobDescriptionInfo.get(0).generateComand();
    }

    @When("^The manager creates the new job description$")
    public void theManagerCreatesTheNewJobDescription() {
        sut.addJobDescription(jobDescriptionCreationCommand);
    }


    @And("^that job contains the information:$")
    public void thatJobContainsTheInformation(List<JobDescriptionInfoCucumberDto> expectedJobDescriptionInfo) {
        JobDescription expectedJobDescription = expectedJobDescriptionInfo.get(0).generateComand().buildNewJobDescription();
        JobDescription actualJobDescriptionCreatedBySut = inMemoryJobDescriptions.findAll().stream()
                .findFirst().orElseThrow(NoSuchElementException::new);
        assertThat(actualJobDescriptionCreatedBySut).isEqualToIgnoringGivenFields(expectedJobDescription, "id");
    }

}
