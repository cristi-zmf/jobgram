package com.cristi.web.jobgram.domain.jobdescription;

import com.cristi.web.jobgram.domain.ddd.DDD;

@DDD.ValueObject
public enum Experience {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED,
    EXPERT
}
