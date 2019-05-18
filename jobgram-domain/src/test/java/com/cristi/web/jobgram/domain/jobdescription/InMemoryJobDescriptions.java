package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.UniqueId;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Repository
public class InMemoryJobDescriptions implements JobDescriptions{
    private final Set<JobDescription> db = new HashSet<>();

    @Override
    public JobDescription get(UniqueId id) {
        return db.stream().filter(e -> e.equals(id))
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Set<JobDescription> findAll() {
        return new HashSet<>(db);
    }

    @Override
    public JobDescription add(JobDescription jobDescription) {
        db.remove(jobDescription);
        db.add(jobDescription);
        return jobDescription;
    }
}
