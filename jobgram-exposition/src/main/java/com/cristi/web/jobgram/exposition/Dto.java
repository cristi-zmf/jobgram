package com.cristi.web.jobgram.exposition;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class Dto {
    @JsonProperty
    public Optional<String> value;
    @JsonProperty
    public String object;
}
