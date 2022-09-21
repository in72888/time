package com.example.demo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  // Timestamped: 우리 JPA쓸건데 뭔가 데이터변동이 있으면 그거 꼭 JPA가 알아서 반영하게해줘
@SpringBootApplication
public class  Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo3Application.class, args);
    }

}
