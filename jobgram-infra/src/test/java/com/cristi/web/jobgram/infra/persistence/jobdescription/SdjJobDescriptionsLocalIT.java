package com.cristi.web.jobgram.infra.persistence.jobdescription;

import com.cristi.web.jobgram.domain.Description;
import com.cristi.web.jobgram.domain.ShortLabel;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.jobdescription.JobDescription;
import com.cristi.web.jobgram.infra.InfraLocalIT;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class SdjJobDescriptionsLocalIT extends InfraLocalIT {

    @Autowired
    private JobDescriptionsSdj sdj;
    @Autowired
    private SdjJobDescriptions sut;
    private JobDescription aJobDescription;

    @Before
    public void setUp() {
        sdj.deleteAll();
        aJobDescription = new JobDescription(
                new UniqueId(), new ShortLabel("Java developer"), new Description("Java developer for spring boot application"), qualifications, 0L
        );
    }

    @Test
    public void get() {
        sdj.saveAndFlush(aJobDescription);
        JobDescription jobDescFromDatabase = sut.get(aJobDescription.getId());
        assertThat(jobDescFromDatabase).isEqualToIgnoringGivenFields(aJobDescription);
    }

    @Test
    public void findAll() {
        sdj.saveAndFlush(aJobDescription);
        assertThat(sut.findAll()).hasSize(1);
        JobDescription jobDescFromDb = sut.findAll().stream()
                .findFirst().orElseThrow(NoSuchElementException::new);
        assertThat(jobDescFromDb).isEqualToComparingFieldByField(aJobDescription);
    }

    @Test
    public void add() {
        sut.add(aJobDescription);
        JobDescription jobDescAdded = sdj.findById(aJobDescription.getId())
                .orElseThrow(NoSuchElementException::new);
        assertThat(jobDescAdded).isEqualToComparingFieldByField(aJobDescription);
    }
}
