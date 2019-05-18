package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.UniqueId;

import java.util.Set;

/**DDD domain repository*/
public interface JobDescriptions {
    JobDescription get(UniqueId id);
    Set<JobDescription> findAll();
    JobDescription add(JobDescription jobDescription);
}
