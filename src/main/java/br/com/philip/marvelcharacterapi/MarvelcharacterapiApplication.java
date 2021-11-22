package br.com.philip.marvelcharacterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MarvelcharacterapiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MarvelcharacterapiApplication.class, args);
    }

}
