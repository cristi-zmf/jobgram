package com.cristi.web.jobgram.infra.persistence.jobdescription;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestEntity {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
