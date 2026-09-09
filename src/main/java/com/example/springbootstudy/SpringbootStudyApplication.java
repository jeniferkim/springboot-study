// main.ts
package com.example.springbootstudy;

import com.example.springbootstudy.savedroute.SavedRoute;
import com.example.springbootstudy.savedroute.SavedRouteRepository;
import com.example.springbootstudy.user.User;
import com.example.springbootstudy.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication // 앱의 시작점
public class SpringbootStudyApplication {

    // .run은 스프링 서버 실행
    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudyApplication.class, args);
    }

    @Bean
    CommandLineRunner init( // CommandLineRunner 스프링부트가 실행 직후 한번 실행되는 코드
                            UserRepository userRepository,
                            SavedRouteRepository savedRouteRepository
    ) {
        return args -> {
            User user = userRepository.save(
                    new User("test@example.com")
            );

            savedRouteRepository.save(
                    new SavedRoute("Busan Route", 10000, user)
            );

            savedRouteRepository.save(
                    new SavedRoute("Seoul Route", 15000, user)
            );
        };
    }
}
