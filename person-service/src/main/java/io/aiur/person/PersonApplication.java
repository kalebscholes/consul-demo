package io.aiur.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients
@RestController
@ComponentScan
@Slf4j
public class PersonApplication {

    @RequestMapping(value="/person", method = RequestMethod.GET)
    public String getPerson(){
        return "person service";
    }

    @FeignClient("person-service")
    public interface PersonServiceClient{

        String getPerson();
    }

    public static void main(String[] args) {
        SpringApplication.run(PersonApplication.class, args);
    }
}
