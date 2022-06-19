package com.ken0105.springbatchtemplate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:property/sample.properties")
public class SampleProperty {
    @Value("${csv.path}")
    public String csvPath;
}
