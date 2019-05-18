package com.cristi.web.jobgram.application.jobdescription;

import com.cristi.web.jobgram.domain.Description;
import com.cristi.web.jobgram.domain.ShortLabel;

class JobDescriptionInfoCucumberDto {
    private final String title;
    private final String description;


    public JobDescriptionInfoCucumberDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    AddJobDescriptionCommand generateComand() {
        return new AddJobDescriptionCommand(new ShortLabel(title), new Description(description));
    }
}
