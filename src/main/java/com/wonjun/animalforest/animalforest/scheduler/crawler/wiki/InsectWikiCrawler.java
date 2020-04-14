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
      String json = crawlElement(tr);
      list.add(json);
    }

    printList(list);

  }

  private String crawlElement(Element tr) {
    String json = "";
    json += "{\n";
    json +=   "\t\t\"name\" : \""+getKorName(tr)+"\",\n";
    json +=   "\t\t\"img_url\" : \"https:"+ crawlImgUrl(tr) +"\",\n";
    json +=   "\t\t\"category\" : \"" + crawlCategory() + "\",\n";
    json +=   "\t\t\"appearance_period\" : \""+ crawlAppearancePeriod(tr) +"\",\n";
    json +=   "\t\t\"appearance_time\" : \""+ crawlAppearanceTime(tr) +"\",\n";
    json +=   "\t\t\"appearance_place\" : \""+ crawlAppearancePrice(tr) +"\",\n";
    json +=   "\t\t\"sale_price\" : \""+ crawlSalePrice(tr) +"\",\n";
    json +=   "\t\t\"appearance_first\" : \""+ crawlAppearanceFirst(tr) +"\",\n";
    json +=   "\t\t\"isExcept\" : "+ crawlIsExcept() +"\n";
    json += "}";
    return json;
  }

  private boolean crawlIsExcept() {
    return false;
  }

  private String crawlAppearanceFirst(Element tr) {
    return tr.select("div.wiki-paragraph").get(6).text();
  }

  private String crawlSalePrice(Element tr) {
    return tr.select("div.wiki-paragraph").get(5).text();
  }

  private String crawlAppearancePrice(Element tr) {
    return tr.select("div.wiki-paragraph").get(4).text();
  }

  private String crawlAppearanceTime(Element tr) {
    return tr.select("div.wiki-paragraph").get(3).text();
  }

  private String crawlAppearancePeriod(Element tr) {
    return tr.select("div.wiki-paragraph").get(2).text();
  }

  private String crawlCategory() {
    return "곤충";
  }

  private String crawlImgUrl(Element tr) {
    return tr.select("div.wiki-paragraph > a.wiki-link-internal > span.wiki-image-align-normal > span.wiki-image-wrapper > img.wiki-image.wiki-image-loading").attr("data-src");
  }

  private String getKorName(Element tr) {
    String[] fullName = tr.select("div.wiki-paragraph").get(0).text().split(" ");
    return fullName[0];
  }

  private void printList(List<String> list) {
    for(String l : list){
      System.out.println(l);
    }
  }

}
