package com.guigu.drug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"com.guigu.drug.*.dao"})
@EnableTransactionManagement
public class DrugApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugApplication.class, args);
	}

}
