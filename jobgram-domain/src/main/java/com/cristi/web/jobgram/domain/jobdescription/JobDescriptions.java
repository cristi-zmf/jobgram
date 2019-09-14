package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.ddd.DDD;

import java.util.Set;

@DDD.DomainRepository
public interface JobDescriptions {
    JobDescription get(UniqueId id);
    Set<JobDescription> findAll();
    JobDescription add(JobDescription jobDescription);
}
