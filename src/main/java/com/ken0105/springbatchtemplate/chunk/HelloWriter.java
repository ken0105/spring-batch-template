package com.ken0105.springbatchtemplate.chunk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@StepScope
@Slf4j
public class HelloWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> items) throws Exception {
        log.info("write: {}", items);
        log.info("##############");
    }
}
