package com.app.bootApp.spring_cofig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = "classpath:/context/dispatcher-servlet.xml")
public class OldConfig {

}
