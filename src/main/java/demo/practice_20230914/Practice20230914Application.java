package demo.practice_20230914;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("demo.practice_20230914.dao")
public class Practice20230914Application {
	public static void main(String[] args) {
		SpringApplication.run(Practice20230914Application.class, args);
	}

}
