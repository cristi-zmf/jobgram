package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.ShortLabel;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.ddd.BaseEntity;
import com.cristi.web.jobgram.domain.ddd.DDD;

@DDD.DomainEntity
public class Qualification extends BaseEntity<Qualification, UniqueId> {
    private ShortLabel name;
    private Experience experience;

    public Qualification(UniqueId id, ShortLabel name, Experience experience) {
        super(Qualification.class, id);
        this.name = name;
        this.experience = experience;
    }
}
