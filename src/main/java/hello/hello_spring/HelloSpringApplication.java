package hello.hello_spring; // hello_spring 패키지를 포함한 패키지 파일만 component 가능

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
