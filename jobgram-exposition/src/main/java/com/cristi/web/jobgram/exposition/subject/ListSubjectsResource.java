package com.cristi.web.jobgram.exposition.subject;

import com.cristi.web.jobgram.exposition.IncognitoMapping;
import com.cristi.web.jobgram.application.subject.ListSubjects;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static java.util.stream.Collectors.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@IncognitoMapping
public class ListSubjectsResource {
    private final ListSubjects listSubjects;

    public ListSubjectsResource(ListSubjects listSubjects) {
        this.listSubjects = listSubjects;
    }

    @GetMapping(path = "/subjects", produces = APPLICATION_JSON_UTF8_VALUE)
    public Set<SubjectDto> viewSubject() {
        return listSubjects.listSubjects().stream()
                .map(SubjectDto::new)
                .collect(toSet());
    }
}
