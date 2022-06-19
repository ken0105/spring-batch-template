package com.ken0105.springbatchtemplate.listener;

import com.ken0105.springbatchtemplate.domain.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ReadListener implements ItemReadListener<Employee> {
    @Override
    public void beforeRead() {
        // do nothing
    }

    @Override
    public void afterRead(Employee employee) {
        log.debug("AfterRead: {}", employee);
    }

    @Override
    public void onReadError(Exception e) {
        log.error("ReadError: errorMessage={}", e.getMessage(), e);
    }
}
