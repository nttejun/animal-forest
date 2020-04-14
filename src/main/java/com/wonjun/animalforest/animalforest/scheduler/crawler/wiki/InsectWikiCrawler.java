package com.wonjun.animalforest.animalforest.scheduler.crawler.wiki;

import com.wonjun.animalforest.animalforest.utils.HtmlParser;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class InsectWikiCrawler {
  private static final String VIEW_URL_FORMAT_INSECT_WIKI = "https://namu.wiki/w/%EB%8F%99%EB%AC%BC%EC%9D%98%20%EC%88%B2%20%EC%8B%9C%EB%A6%AC%EC%A6%88/%EA%B3%A4%EC%B6%A9";

  private static final String WIKI_HEADING_CONTENT_TABLE_TR = "div.w > div.wiki-heading-content > div.wiki-table-wrap > table.wiki-table > tbody > tr";

  public void crawl() {
    Document document = HtmlParser.get(VIEW_URL_FORMAT_INSECT_WIKI);
    Elements tableTr = document.select(WIKI_HEADING_CONTENT_TABLE_TR);

    List<String> list = new ArrayList<>();

    for(Element tr : tableTr){
      String json = "";
      json += "{\n";
      json +=   "\t\t\"name\" : \""+tr.select("div.wiki-paragraph").get(0).select("a.wiki-link-internal").text()+"\",\n";
      json +=   "\t\t\"img_url\" : \"https:"+tr.select("div.wiki-paragraph > a.wiki-link-internal > span.wiki-image-align-normal > span.wiki-image-wrapper > img.wiki-image.wiki-image-loading").attr("data-src")+"\",\n";
      json +=   "\t\t\"category\" : \"곤충\",\n";
      json +=   "\t\t\"appearance_period\" : \""+tr.select("div.wiki-paragraph").get(2).text()+"\",\n";
      json +=   "\t\t\"appearance_time\" : \""+tr.select("div.wiki-paragraph").get(3).text()+"\",\n";
      json +=   "\t\t\"appearance_place\" : \""+tr.select("div.wiki-paragraph").get(4).text()+"\",\n";
      json +=   "\t\t\"sale_price\" : \""+tr.select("div.wiki-paragraph").get(5).text()+"\",\n";
      json +=   "\t\t\"appearance_first\" : \""+tr.select("div.wiki-paragraph").get(6).text()+"\",\n";
      json +=   "\t\t\"isExcept\" : \""+false+"\"\n";
      json += "}";
      list.add(json);
    }

    printList(list);

  }

  private void printList(List<String> list) {
    for(String l : list){
      System.out.println(l);
    }
  }

}
