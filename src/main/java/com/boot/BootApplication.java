package com.boot;

import com.boot.metric.order.v4.OrderConfigV4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceEnvConfig.class)
//@Import(MyDataSourceValueConfig.class)
//@Import(MyDataSourceConfigV1.class)
//@Import(MyDataSourceConfigV2.class)
//@Import(MyDataSourceConfigV3.class)
//@ConfigurationPropertiesScan({"com.boot"})
@Import(OrderConfigV4.class)
@SpringBootApplication(scanBasePackages = "com.boot.metric.controller")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Bean
    public InMemoryHttpExchangeRepository httpExchangeRepository() {
        return new InMemoryHttpExchangeRepository();
    }
}
