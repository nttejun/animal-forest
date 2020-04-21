package com.wonjun.animalforest.animalforest;

import com.wonjun.animalforest.animalforest.scheduler.crawler.wiki.FishWikiCrawler;
import com.wonjun.animalforest.animalforest.scheduler.crawler.wiki.InsectWikiCrawler;
import org.junit.Test;

class AnimalforestApplicationTest {

  @Test
  public void getWikiFishName(){
    FishWikiCrawler fishWikiCrawler = new FishWikiCrawler();
    fishWikiCrawler.crawl();
  }

  @Test
  public void getWikiInsectName(){
    InsectWikiCrawler fishWikiCrawler = new InsectWikiCrawler();
    fishWikiCrawler.crawl();
  }
}