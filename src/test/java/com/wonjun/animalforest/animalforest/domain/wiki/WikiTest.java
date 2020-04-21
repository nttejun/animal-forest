package com.wonjun.animalforest.animalforest.domain.wiki;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class WikiTest {

  public static final Wiki newWiki = Wiki.builder()
      .id(000011112400123400L)
      .wikiId("fish202004202400112200")
      .name("테스트 물고기")
      .imgUrl("http://buxi-dev.buxikorea.com/static/media/notice_stopcarsharing3x.d74e3742.png")
      .category("물고기")
      .appearance_period("9월~6월")
      .appearance_time("4시~19시")
      .appearance_place("꽃 주변")
      .sale_price("240")
      .appearance_first("동물의 숲")
      .isExcept(false)
      .size(null)
      .build();

}
