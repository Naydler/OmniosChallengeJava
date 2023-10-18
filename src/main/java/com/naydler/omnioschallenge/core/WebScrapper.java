package com.naydler.omnioschallenge.core;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.naydler.omnioschallenge.entities.BookEntity;

@Component
public class WebScrapper {
    public ArrayList<BookEntity> execute() {
        String baseUrl = "http://books.toscrape.com";
        var currentPage = 1;
        var notFinish = true;
        ArrayList<BookEntity> books = new ArrayList<BookEntity>();
        while (notFinish) {
            try {
                Document doc = Jsoup.connect(baseUrl + "/catalogue/page-" + currentPage++ + ".html").get();
                Elements elements = doc.select("article.product_pod");
                elements.forEach(element -> {
                    String title = element.select("h3 > a").attr("title");
                    String price = element.select("div.product_price > p.price_color").text();
                    String rating = element.select("p.star-rating").attr("class").split(" ")[1];
                    String imageUrl = element.select("div.image_container > a > img").attr("src");
                    var bookEntity = new BookEntity(title, price, rating, imageUrl);
                    books.add(bookEntity);
                });
            } catch (Exception e) {
                notFinish = false;
            }
        }
        return books;
    }
}
