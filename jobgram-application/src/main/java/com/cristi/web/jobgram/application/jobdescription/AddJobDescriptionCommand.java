package com.cristi.web.jobgram.application.jobdescription;

import com.cristi.web.jobgram.domain.Description;
import com.cristi.web.jobgram.domain.ShortLabel;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.ddd.BaseValueObject;
import com.cristi.web.jobgram.domain.ddd.DDD;
import com.cristi.web.jobgram.domain.jobdescription.JobDescription;

import java.util.List;

import static java.util.Arrays.asList;

@DDD.ApplicationCommand
public class AddJobDescriptionCommand extends BaseValueObject<AddJobDescriptionCommand> {
    private final ShortLabel title;
    private final Description description;

    public AddJobDescriptionCommand(ShortLabel title, Description description) {
        super(AddJobDescriptionCommand.class);
        this.title = title;
        this.description = description;
    }

    public JobDescription buildNewJobDescription() {
        return new JobDescription(new UniqueId(), title, description, 0L);
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(title, description);
    }
}
