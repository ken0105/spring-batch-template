package com.ken0105.springbatchtemplate.listener;

import com.ken0105.springbatchtemplate.domain.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProcessListener implements ItemProcessListener<Employee, Employee> {
    @Override
    public void beforeProcess(Employee employee) {
        // do nothing
    }

    @Override
    public void afterProcess(Employee employee, Employee result) {
        // do nothing
    }

    @Override
    public void onProcessError(Employee employee, Exception e) {
        log.error("ProcessError: item={}, errorMessage={}", employee, e.getMessage(), e);
    }
}
