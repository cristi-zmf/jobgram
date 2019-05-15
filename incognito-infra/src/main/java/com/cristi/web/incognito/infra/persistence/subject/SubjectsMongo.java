package com.cristi.web.incognito.infra.persistence.subject;

import com.cristi.web.incognito.domain.subject.Subject;
import com.cristi.web.incognito.domain.subject.SubjectId;
import com.cristi.web.incognito.domain.subject.Subjects;
import com.cristi.web.incognito.domain.subject.Title;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SubjectsMongo implements Subjects {
    private final MongoSubjects repo;

    public SubjectsMongo(MongoSubjects repo) {
        this.repo = repo;
    }


    @Override
    public Set<Subject> findAll() {
        return new HashSet<>(repo.findAll());
    }

    @Override
    public Subject getOrThrow(SubjectId id) {
        return repo.findById(id).orElseThrow(() -> new NoSuchElementException(id.getValue()));
    }

    @Override
    public Optional<Subject> get(SubjectId id) {
        return repo.findById(id);
    }

    @Override
    public Subject add(Subject subject) {
        return repo.insert(subject);
    }

    @Override
    public Set<Subject> findByTitleContaining(String key) {
        return repo.findByTitleValueContaining(key);
    }
}
