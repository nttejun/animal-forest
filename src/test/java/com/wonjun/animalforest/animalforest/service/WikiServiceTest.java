package com.wonjun.animalforest.animalforest.service;

import com.wonjun.animalforest.animalforest.domain.wiki.Wiki;
import com.wonjun.animalforest.animalforest.domain.wiki.WikiTest;
import com.wonjun.animalforest.animalforest.repository.WikiRepository;
import com.wonjun.animalforest.animalforest.service.dto.WikiDto.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WikiServiceTest {

  @Mock
  private WikiRepository wikiRepository;

  @InjectMocks
  private WikiService wikiService;

  @Test
  public void 데이터삽입_가능하면_저장(){
    Wiki wiki = WikiTest.newWiki;
    wikiService.save(wiki);
  }

  @Test
  public void 데이터_물고기정보_조회(){
    Wiki wiki = WikiTest.newWiki;
    wikiService.save(wiki);

    Wiki wishWiki = WikiTest.newWiki;
    Response response = wikiService.findByWikiId(wishWiki.getWikiId());
    Assert.assertEquals("테스트 물고기", response.getName());
  }
}