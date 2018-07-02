package com.slk.guidance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.slk.guidance.mapper")
public class GuidanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuidanceApplication.class, args);
	}


}