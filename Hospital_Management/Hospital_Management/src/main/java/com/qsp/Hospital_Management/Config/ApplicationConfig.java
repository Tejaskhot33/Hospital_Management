package com.qsp.Hospital_Management.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Url Of Swagger:  http://localhost:8080/swagger-ui.html#
@Configuration
@EnableSwagger2
public class ApplicationConfig {   

	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Qspider", "https://qspider.com", "qspider.gmail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hospital Management Service",
				"this app is used to maintain a manage the details of the patient in an hospital", "version.1",
				"1 year of Free Service", contact, "QSP001", "http://qsp001.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.Hospital_Management")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
