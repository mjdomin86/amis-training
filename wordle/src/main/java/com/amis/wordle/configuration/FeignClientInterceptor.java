package com.amis.wordle.configuration;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class FeignClientInterceptor implements RequestInterceptor {
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE = "application/json";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(CONTENT_TYPE_HEADER, CONTENT_TYPE);
    }
}
