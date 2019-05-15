package com.cristi.web.incognito.incognito.application.subject;


import com.cristi.web.incognito.domain.subject.Subject;
import com.cristi.web.incognito.domain.subject.Subjects;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class ListSubjects {
    private final Subjects subjects;

    public ListSubjects(Subjects subjects) {
        this.subjects = subjects;
    }

    public Set<Subject> listSubjects() {
        return subjects.findAll();
    }
}
