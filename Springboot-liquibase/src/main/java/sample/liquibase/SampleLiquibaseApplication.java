package sample.liquibase;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SampleLiquibaseApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleLiquibaseApplication.class, args);
	}
	@Bean
	public SpringLiquibase springLiquibase(DataSource dataSource) {

		SpringLiquibase springLiquibase = new SpringLiquibase();

		springLiquibase.setDataSource(dataSource);
		springLiquibase.setChangeLog("classpath:/db/changelog/master.xml");

		return springLiquibase;
	}

}
