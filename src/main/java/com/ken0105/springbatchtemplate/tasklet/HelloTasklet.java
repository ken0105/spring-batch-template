package com.ken0105.springbatchtemplate.tasklet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component("HelloTasklet")
@StepScope
@Slf4j
public class HelloTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        log.info("Hello World");
        ExecutionContext jobContext = stepContribution
                .getStepExecution()
                .getJobExecution()
                .getExecutionContext();
        jobContext.put("jobKey", "jobValue");

        ExecutionContext stepContext = stepContribution
                .getStepExecution()
                .getExecutionContext();
        stepContext.put("stepKey", "stepValue");

        return RepeatStatus.FINISHED;
    }
}
