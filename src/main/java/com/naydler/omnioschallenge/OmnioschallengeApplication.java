package com.naydler.omnioschallenge;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.naydler.omnioschallenge.core.WebScrapper;
import com.naydler.omnioschallenge.mappers.BookMapper;

@SpringBootApplication
public class OmnioschallengeApplication {

	public static void main(String[] args) throws IOException {
		var context = SpringApplication.run(OmnioschallengeApplication.class, args);
		var webScrapper = context.getBean(WebScrapper.class);
		var scrappedBooks = webScrapper.execute();
		var bookMapper = context.getBean(BookMapper.class);
		var bookDtos = bookMapper.map(scrappedBooks);
	}

}
