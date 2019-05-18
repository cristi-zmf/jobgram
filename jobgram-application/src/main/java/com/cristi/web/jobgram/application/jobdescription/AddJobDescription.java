package com.cristi.web.jobgram.application.jobdescription;

import com.cristi.web.jobgram.application.ApplicationService;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.jobdescription.JobDescription;
import com.cristi.web.jobgram.domain.jobdescription.JobDescriptions;
import org.springframework.context.annotation.Lazy;

@ApplicationService
@Lazy
public class AddJobDescription {
    private final JobDescriptions jobDescriptions;

    public AddJobDescription(JobDescriptions jobDescriptions) {
        this.jobDescriptions = jobDescriptions;
    }

    public UniqueId addJobDescription(AddJobDescriptionCommand command) {
        JobDescription newJobDescription = command.buildNewJobDescription();
        return jobDescriptions.add(newJobDescription).getId();
    }
}
