package com.wonjun.animalforest.animalforest.scheduler.crawler.wiki;

import static java.util.Objects.isNull;

import com.wonjun.animalforest.animalforest.exception.PageNotFoundException;
import com.wonjun.animalforest.animalforest.utils.HtmlParser;
import java.util.Iterator;
import java.util.Optional;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FishWikiCrawler {

  private static final String DETAIL_VIEW_URL_FORMAT = "https://namu.wiki/w/%EB%8F%99%EB%AC%BC%EC%9D%98%20%EC%88%B2%20%EC%8B%9C%EB%A6%AC%EC%A6%88/%EB%AC%BC%EA%B3%A0%EA%B8%B0";

  private static final String WIKI_HEADING = "div.w > h3.wiki-heading";
  private static final String WIKI_HEADING_CONTENT_TABLE_TR = "div.w > div.wiki-heading-content > div.wiki-table-wrap > table.wiki-table > tbody > tr";
  private static final String WIKI_HEADING_CONTENT_TABLE_TR_TD = "div.w > div.wiki-heading-content > div.wiki-table-wrap > table.wiki-table > tbody > tr > td";

  public void crawl() {
    Document document = HtmlParser.get(DETAIL_VIEW_URL_FORMAT);
    Elements heading = document.select(WIKI_HEADING);
    Elements tableTr = document.select(WIKI_HEADING_CONTENT_TABLE_TR);
    Elements tableTd = document.select(WIKI_HEADING_CONTENT_TABLE_TR_TD);

    for(Element h : heading){
      System.out.println(h);
    }

    for(Element tr : tableTr){
      System.out.println("==============================================");
      System.out.println("이름 : " + tr.select("div.wiki-paragraph").get(0).text());
      System.out.println("이미지 URL :https://"+ tr.select("div.wiki-paragraph > a.wiki-link-internal > span.wiki-image-align-normal > span.wiki-image-wrapper > img.wiki-image.wiki-image-loading").attr("data-src"));
      System.out.println("출현기간 : " + tr.select("div.wiki-paragraph").get(2).text());
      System.out.println("출현시간 : " + tr.select("div.wiki-paragraph").get(3).text());
      System.out.println("출현장소 : " + tr.select("div.wiki-paragraph").get(4).text());
      System.out.println("크기 : " + tr.select("div.wiki-paragraph").get(5).text());
      System.out.println("판매가격(벨) : " + tr.select("div.wiki-paragraph").get(6).text());
      System.out.println("최초 등장 : " + tr.select("div.wiki-paragraph").get(7).text());

      /*
        for(Element td : tableTd){
          System.out.println("name : " + td.select("div.wiki-paragraph"));
        }
      */
    }
  }

  public void crawl_ver_1() {
    Document documents = HtmlParser.get(DETAIL_VIEW_URL_FORMAT);
    if (isNull(documents)) {
      throw new PageNotFoundException();
    }

    Elements listDetail = documents.select(WIKI_HEADING);
    Iterator<Element> fishName = listDetail.select("td > div.wiki-paragraph > a.wiki-link-internal")
        .iterator();
    Iterator<Element> fishPicture = listDetail.select(
        "td > div.wiki-paragraph > a.wiki-link-internal > span.wiki-image-align-normal > span.wiki-image-wrapper > img.wiki-image.wiki-image-loading")
        .iterator();

    String fnStr = "";
    while (fishName.hasNext()) {
      fnStr = fishName.next().text();
      fnStr = fnStr.replaceAll("동물의 숲", "");
      System.out.println("name : " + fnStr);
    }

    String fpStr = "";
    while (fishPicture.hasNext()) {
      fpStr = fishPicture.next().text();

      System.out.println("img : " + fishPicture.next().getElementsByAttribute("data-src"));
    }

  }
}