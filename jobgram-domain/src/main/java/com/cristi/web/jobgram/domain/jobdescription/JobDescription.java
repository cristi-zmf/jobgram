package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.Description;
import com.cristi.web.jobgram.domain.ShortLabel;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.ddd.BaseAggregateRoot;
import com.cristi.web.jobgram.domain.ddd.DDD;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.unmodifiableSet;

@DDD.AggregateRoot
public class JobDescription extends BaseAggregateRoot<JobDescription, UniqueId> {
    @NotNull private Description description;
    @NotNull private ShortLabel title;
    @NotEmpty private Set<Qualification> qualifications;

    public JobDescription(
            UniqueId uniqueId, ShortLabel title,
            Description description, Set<Qualification> qualifications, long version
    ) {
        super(JobDescription.class, uniqueId);
        this.description = description;
        this.title = title;
        this.qualifications = qualifications;
        this.version = version;
        validate(this);
    }

    public Description getDescription() {
        return description;
    }
    public ShortLabel getTitle() {
        return title;
    }
    public Set<Qualification> getQualifications() {
        return unmodifiableSet(qualifications);
    }

    private JobDescription() {
        /*USED BY JPA, DONT USE IN PRODUCTION CODE*/
        super(JobDescription.class);
        this.qualifications = new HashSet<>();
    }
}
