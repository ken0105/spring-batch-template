package com.ken0105.springbatchtemplate.chunk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@StepScope
@Slf4j
public class HelloProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String item) throws Exception {
        String itemProcessed = item + "!";
        log.info("Processor:{}", itemProcessed);
        return itemProcessed;
    }
}
