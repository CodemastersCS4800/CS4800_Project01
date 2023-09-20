package com.javaguides.springboot;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringbootFirstAppApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringbootFirstAppApplication.class, args);
		Document doc = Jsoup.connect("http://www.javatpoint.com").get();
		Elements links = doc.select("a[href]");
		for (Element link : links) {
			System.out.println("\nlink : " + link.attr("href"));
			System.out.println("text : " + link.text());
		}

	}
}