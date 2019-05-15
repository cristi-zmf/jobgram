package com.cristi.web.incognito.infra.persistence.changelogs.common;

import com.cristi.web.incognito.domain.subject.Description;
import com.cristi.web.incognito.domain.subject.Subject;
import com.cristi.web.incognito.domain.subject.Title;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog(order = "001")
public class SubjectChangelog {
    @ChangeSet(order = "001", id = "subjectsTestDataSet", author = "cristi")
    public void initialDataSetForSubjectCollection( MongoTemplate mongoTemplate) {
        Subject subject = new Subject(new Title("iPhone xx"), new Description("so xx!!!!!"));
        mongoTemplate.save(subject);
    }

}
