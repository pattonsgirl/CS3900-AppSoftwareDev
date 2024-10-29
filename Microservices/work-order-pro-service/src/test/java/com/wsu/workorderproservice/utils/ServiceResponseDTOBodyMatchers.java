package com.wsu.workorderproservice.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.springframework.test.web.servlet.ResultMatcher;

public class ServiceResponseDTOBodyMatchers {

    private final ObjectMapper mapper = new ObjectMapper();

    public ServiceResponseDTOBodyMatchers() {
    }

    public static ServiceResponseDTOBodyMatchers winResponseBody() {
        return new ServiceResponseDTOBodyMatchers();
    }

    public <T> ResultMatcher toContain(T expectedObject, Class<T> targetClass) {
        return (mvcResult) -> {
            JSONObject response = new JSONObject(mvcResult.getResponse().getContentAsString());
            T actualObject = this.mapper.readValue(response.get("data").toString(), targetClass);
            Assertions.assertThat(actualObject).usingRecursiveComparison().isEqualTo(expectedObject);
        };
    }

    public <T> ResultMatcher toContain(List<T> expectedList, Class<T> targetClass) {
        JavaType type = this.mapper.getTypeFactory().constructCollectionType(List.class, targetClass);
        return (mvcResult) -> {
            JSONObject response = new JSONObject(mvcResult.getResponse().getContentAsString());
            List<T> actualList = this.mapper.readValue(response.get("data").toString(), type);
            Assertions.assertThat(actualList).usingRecursiveComparison().isEqualTo(expectedList);
        };
    }
}
