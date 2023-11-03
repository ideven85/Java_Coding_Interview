package com.cleo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
       // System.out.println(doc);
        Document bod = Jsoup.parseBodyFragment(html);
        System.out.println(bod.body());

        try {
            Document xhamster = Jsoup.connect("https://ita.xhamster.com/photos/gallery/16080175/515156724").get();
            System.out.println(Jsoup.parseBodyFragment(xhamster.body().html()));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Hello world!");
    }
}