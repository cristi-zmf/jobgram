package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.Description;
import com.cristi.web.jobgram.domain.ShortLabel;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.ddd.BaseAggregateRoot;
import com.cristi.web.jobgram.domain.ddd.DDD;

import javax.validation.constraints.NotNull;

@DDD.AggregateRoot
public class JobDescription extends BaseAggregateRoot<JobDescription, UniqueId> {
    @NotNull
    private Description description;
    @NotNull
    private ShortLabel title;

    public JobDescription(UniqueId uniqueId, ShortLabel title, Description description, long version) {
        super(JobDescription.class, uniqueId);
        this.description = description;
        this.title = title;
        this.version = version;
        validate(this);
    }

    public Description getDescription() {
        return description;
    }

    public ShortLabel getTitle() {
        return title;
    }

    private JobDescription() {
        /*USED BY JPA, DONT USE IN PRODUCTION CODE*/
        super(JobDescription.class);
    }
}
