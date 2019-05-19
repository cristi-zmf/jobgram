package com.cristi.web.jobgram.infra.persistence;

import com.cristi.web.jobgram.infra.InfraLocalIT;
import com.cristi.web.jobgram.infra.persistence.jobdescription.JobDescriptionsSdj;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SdjLocalIT  extends InfraLocalIT{
    
    @Autowired
    JobDescriptionsSdj sdj;

    @Test
    public void sdj_is_autowired() {
        Assertions.assertThat(sdj).isNotNull();
    }
}
