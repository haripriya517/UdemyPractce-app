package com.hcl.test.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.hcl.test.dao.ActivityData;
import com.hcl.test.dao.ActivityDataDto;
import com.hcl.test.dao.ProductData;
import com.hcl.test.dao.ProductDataDto;
import com.hcl.test.repository.ActivityDataItemProcessor;
import com.hcl.test.repository.ProductDataItemProcessor;
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	StepBuilderFactory stepBuilderFactory;

	@Autowired
	DataSource dataSource;

//	@Bean
//	public DataSource datasource() {
//		final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		driverManagerDataSource.setUrl("jdbs:mysql://localhost:3306/customer");
//		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("root");
//		return driverManagerDataSource;
//
//	}

	@Bean
	public FlatFileItemReader<ActivityData> reader() {
		FlatFileItemReader<ActivityData> reader = new FlatFileItemReader<ActivityData>();
		reader.setResource(new ClassPathResource("activitydata.csv"));
		reader.setLineMapper(new DefaultLineMapper<ActivityData>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "partyId", "date", "productCode", "activityCode", "status" });
						//setNames(new String[] { "id", "productCode", "activityCode","startDate", "endDate","subject","amountTobePaid"});
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<ActivityData>() {
					{
						setTargetType(ActivityData.class);
						
					}
				});
				
				//setFieldSetMapper(new MyCustomFieldSetMapper<ProductData>());
				

			}
		});

		return reader;
	}

//	@Bean
//	public ProductDataItemProcessor processor() {
//		return new ProductDataItemProcessor();
//	}
	@Bean
	public ActivityDataItemProcessor processor() {
		return new ActivityDataItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<ActivityDataDto> writer() {
		JdbcBatchItemWriter<ActivityDataDto> writer = new JdbcBatchItemWriter<ActivityDataDto>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<ActivityDataDto>());
//		writer.setSql(
//				"INSERT INTO product(id,productCode,activityCode,startDate,endDate,subject,amountTobePaid) VALUES (:id,:productCode,:activityCode,:startDate,:endDate,:subject,:amountTobePaid)");
		
		writer.setSql(
				"INSERT INTO activitydata(partyId,date,productCode,activityCode,status) VALUES (:partyId,:date,:productCode,:activityCode,:status)");
		writer.setDataSource(dataSource);

		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1").<ActivityData, ActivityDataDto>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public Job importUserJob() {
		return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
	}
	
	
	

}
