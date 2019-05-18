package com.cristi.web.jobgram.infra.persistence.jobdescription;

import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.domain.jobdescription.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobDescriptionsSdj extends JpaRepository<JobDescription, UniqueId> {

}
