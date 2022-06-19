package com.ken0105.springbatchtemplate.listener;

import com.ken0105.springbatchtemplate.domain.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WriterListener implements ItemWriteListener<Employee> {
    @Override
    public void beforeWrite(List<? extends Employee> list) {
        // do nothing
    }

    @Override
    public void afterWrite(List<? extends Employee> list) {
        log.debug("AfterWrite: count={}", list.size());
    }

    @Override
    public void onWriteError(Exception e, List<? extends Employee> list) {
        log.error("WriteError: errorMessage={}", e.getMessage(), e);
    }
}
