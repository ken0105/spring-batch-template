package com.ken0105.springbatchtemplate.config;

import com.ken0105.springbatchtemplate.domain.model.Employee;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcImportBatchConfig extends BaseConfig {
    @Autowired
    private DataSource dataSource;

    private static final String INSERT_SQL = "insert into employee (id, name, age, gender) " +
            "values (:id, :name, :age, :gender)";

    @Bean
    @StepScope
    public JdbcBatchItemWriter<Employee> jdbcBatchItemWriter() {
        BeanPropertyItemSqlParameterSourceProvider<Employee> provider = new BeanPropertyItemSqlParameterSourceProvider<>();
        return new JdbcBatchItemWriterBuilder<Employee>()
                .itemSqlParameterSourceProvider(provider)
                .sql(INSERT_SQL)
                .dataSource(this.dataSource)
                .build();
    }

    @Bean
    public Step csvImportJdbcStep() {
        return this.stepBuilderFactory.get("CsvImportJdbcStep")
                .<Employee, Employee>chunk(10)
                .reader(csvReader()).listener(this.readListener)
                .processor(genderConvertProcessor).listener(this.processListener)
                .writer(jdbcBatchItemWriter()).listener(this.writeListener)
                .build();
    }

    @Bean("JdbcJob")
    public Job csvImportJdbcJob(){
        return this.jobBuilderFactory.get("CsvImportJdbcJob")
                .incrementer(new RunIdIncrementer())
                .start(csvImportJdbcStep())
                .build();
    }
}
