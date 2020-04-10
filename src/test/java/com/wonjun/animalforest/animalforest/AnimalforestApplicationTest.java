package com.wonjun.animalforest.animalforest;

import com.wonjun.animalforest.animalforest.scheduler.crawler.wiki.FishWikiCrawler;
import org.junit.jupiter.api.Test;

class AnimalforestApplicationTest {

  @Test
  public void getWikiFishName(){
    FishWikiCrawler fishWikiCrawler = new FishWikiCrawler();
    fishWikiCrawler.crawl();
  }
}