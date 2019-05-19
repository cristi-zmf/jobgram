package com.cristi.web.jobgram.exposition.jobdescription;

import com.cristi.web.jobgram.application.jobdescription.AddJobDescription;
import com.cristi.web.jobgram.domain.UniqueId;
import com.cristi.web.jobgram.exposition.BaseResourceTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AddJobDescriptionResourceLocalIT extends BaseResourceTest {
    private static final UniqueId SOME_ID = new UniqueId();
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Mock
    private AddJobDescription mockAddJobDescription;

    @Autowired
    @InjectMocks
    private AddJobDescriptionResource sut;

    @Override
    protected void mockApplicationService() {
        setField(sut, "addJobDescription", mockAddJobDescription);
        when(mockAddJobDescription.addJobDescription(any())).thenReturn(SOME_ID);
    }

    @Test
    public void addJobDescription() throws Exception {
        AddJobDescriptionCommandRep commandRep = new AddJobDescriptionCommandRep("test", "test description");
        ResultActions results = mockMvc.perform(
                post("/api/job-descriptions")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(OBJECT_MAPPER.writeValueAsString(commandRep))
        );

        String responseAsString = results.andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        UniqueId returnedId = OBJECT_MAPPER.readValue(responseAsString, UniqueId.class);
        Assertions.assertThat(returnedId).isEqualTo(SOME_ID);
    }
}