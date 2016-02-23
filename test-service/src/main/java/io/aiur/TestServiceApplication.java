package io.aiur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
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
public class TestServiceApplication {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test service";
    }

    @FeignClient("test-service")
    public interface TestServiceClient{

        @RequestMapping(value="/test", method = RequestMethod.GET)
        String test();
    }

    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }
}
