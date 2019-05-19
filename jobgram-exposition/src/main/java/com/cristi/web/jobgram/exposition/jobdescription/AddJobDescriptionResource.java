package com.cristi.web.jobgram.exposition.jobdescription;

import com.cristi.web.jobgram.application.jobdescription.AddJobDescription;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.exposition.JobgramResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@JobgramResource
public class AddJobDescriptionResource {
    private final AddJobDescription addJobDescription;

    public AddJobDescriptionResource(AddJobDescription addJobDescription) {
        this.addJobDescription = addJobDescription;
    }

    @PostMapping("/job-descriptions")
    public UniqueId addJobDescription(@Valid @RequestBody AddJobDescriptionCommandRep commandRep) {
        return addJobDescription.addJobDescription(commandRep.toCommand());
    }

}
