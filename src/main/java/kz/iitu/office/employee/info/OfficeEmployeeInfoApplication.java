package kz.iitu.office.employee.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OfficeEmployeeInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficeEmployeeInfoApplication.class, args);
	}

}
