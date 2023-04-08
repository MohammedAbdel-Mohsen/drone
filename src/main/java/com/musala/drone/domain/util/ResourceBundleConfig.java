package com.musala.drone.domain.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@PropertySource("classpath:message.properties")
@Data
public class ResourceBundleConfig {

    private String operationDroneSuccessfullyCode;

    private String droneCapacityRetrievedSuccessfullyMessage;

    private String droneRegistrationFailedCode;

    private String droneRegistrationFailedMessage;

    private String droneDoesNotPresentCode;

    private String droneDoesNotPresentMessage;

}
