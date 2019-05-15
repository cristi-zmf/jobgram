package com.cristi.web.jobgram.exposition.subject;

import com.cristi.web.jobgram.domain.subject.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SubjectDto {
    @JsonProperty
    String id;
    @JsonProperty
    String title;
    @JsonProperty
    String description;

    public SubjectDto(Subject subject) {
        this.id = subject.getId().getValue();
        this.title = subject.getTitle().getValue();
        this.description = subject.getDescription().getValue();
    }

    private SubjectDto() {
    }
}
