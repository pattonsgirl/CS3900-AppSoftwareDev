package com.wsu.workorderproservice.utils;

import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;


public class MockRequestBuilders {
    private static final Map<HttpMethod, MockRequestCommand> METHODS;

    abstract static class MockRequestCommand {
        abstract MockHttpServletRequestBuilder create(String uri);
    }

    static {
        METHODS = Map.of(HttpMethod.GET, new MockRequestCommand() {
            @Override
            public MockHttpServletRequestBuilder create(String uri) {
                return get(uri);
            }
        }, HttpMethod.POST, new MockRequestCommand() {
            @Override
            public MockHttpServletRequestBuilder create(String uri) {
                return post(uri);
            }
        },
                HttpMethod.PUT, new MockRequestCommand() {
            @Override
            public MockHttpServletRequestBuilder create(String uri) {
                return put(uri);
            }
        }, HttpMethod.PATCH, new MockRequestCommand() {
            @Override
            public MockHttpServletRequestBuilder create(String uri) {
                return patch(uri);
            }
        }, HttpMethod.DELETE, new MockRequestCommand() {
            @Override
            public MockHttpServletRequestBuilder create(String uri) {
                return delete(uri);
            }
        });
    }

    public static MockHttpServletRequestBuilder request(HttpMethod method, String uri) {
        return attachGatewayHeaders(METHODS.get(method).create(uri), null);
    }

    public static MockHttpServletRequestBuilder requestWithParams(HttpMethod method, String uri, MultiValueMap<String, String> params) {
        return attachGatewayHeaders(METHODS.get(method).create(uri), params);
    }

    private static MockHttpServletRequestBuilder attachGatewayHeaders(MockHttpServletRequestBuilder builder, MultiValueMap<String, String> params) {
        if (params != null) {
            builder.params(params);
        }
        return builder;
    }
}
