package com.vsi.custombeanpostprocessor;

import com.vsi.custombeanpostprocessor.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class CustomBeanPostProcessorApplication {
	private final AppService appService;

	public static void main(String[] args) {
		SpringApplication.run(CustomBeanPostProcessorApplication.class, args);
	}

	@PostConstruct
	void init() {
		System.out.println(appService.getTrimmedValue().equals(appService.getTrimmedValue().trim()));
		appService.printTrimmedValue("    Not trimmed value will be trimmed     ");
	}
}
