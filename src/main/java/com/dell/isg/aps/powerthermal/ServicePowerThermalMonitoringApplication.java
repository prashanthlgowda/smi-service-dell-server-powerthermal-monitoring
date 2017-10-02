/**
 * Copyright © 2017 DELL Inc. or its subsidiaries.  All Rights Reserved.
 */
package com.dell.isg.aps.powerthermal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
@EnableSwagger2
@ComponentScan("com.dell.isg.aps.powerthermal")
public class ServicePowerThermalMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicePowerThermalMonitoringApplication.class, args);
    }

	@Autowired
	private BuildInfo buildInfo;
	
    @Bean
    public Docket anewsApipi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("powerthermal").apiInfo(new ApiInfoBuilder().title("SMI Microservice :  Power and Thermal ").version(buildInfo.toString()).build()).select().paths(regex("/api.*")).build();
    }

}
