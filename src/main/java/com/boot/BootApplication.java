package com.boot;

import com.boot.config.MyDataSourceEnvConfig;
import com.boot.config.MyDataSourceValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(MyDataSourceValueConfig.class)
@SpringBootApplication(scanBasePackages = "com.boot.datasource")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
