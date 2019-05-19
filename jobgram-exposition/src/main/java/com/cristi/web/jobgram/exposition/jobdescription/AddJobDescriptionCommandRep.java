package com.cristi.web.jobgram.exposition.jobdescription;

import com.cristi.web.jobgram.application.jobdescription.AddJobDescriptionCommand;
import com.cristi.web.jobgram.domain.Description;
import com.cristi.web.jobgram.domain.ShortLabel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddJobDescriptionCommandRep {
    @JsonProperty @ShortLabel.Constraint public String title;
    @JsonProperty public String description;

    public AddJobDescriptionCommandRep(String title, String description) {
        this.title = title;
        this.description = description;
    }

    private AddJobDescriptionCommandRep() {
        /*Used by JACKSON*/
    }

    public AddJobDescriptionCommand toCommand() {
        return new AddJobDescriptionCommand(new ShortLabel(title), new Description(description));
    }
}
