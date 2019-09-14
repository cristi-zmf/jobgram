package com.cristi.web.jobgram.infra.persistence.jobdescription;

import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.ddd.DDD;
import com.cristi.web.jobgram.domain.jobdescription.JobDescription;
import com.cristi.web.jobgram.domain.jobdescription.JobDescriptions;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

///DDD repository impl
@Repository
@DDD.DomainRepositoryImpl
public class SdjJobDescriptions implements JobDescriptions {

    private final JobDescriptionsSdj sdj;

    public SdjJobDescriptions(JobDescriptionsSdj sdj) {
        this.sdj = sdj;
    }


    @Override
    public JobDescription get(UniqueId id) {
        return sdj.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Set<JobDescription> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public JobDescription add(JobDescription jobDescription) {
        return sdj.saveAndFlush(jobDescription);
    }
}
