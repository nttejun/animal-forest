package com.wonjun.animalforest.animalforest.repository;

import com.wonjun.animalforest.animalforest.domain.wiki.Wiki;
import com.wonjun.animalforest.animalforest.domain.wiki.WikiTest;
import com.wonjun.animalforest.animalforest.service.dto.WikiDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class WikiRepositoryTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  WikiRepository wikiRepository;

  public List<Wiki> list = new ArrayList<>();

  @Before
  public void 물고기리스트_데이터생성(){
    for (int i = 0; i < 100; i++) {
      Long id = 0000111124001234L + i;
      Wiki wikiData = new Wiki(id
          , "fish202004202400112200" + i
          , "테스트 물고기" + i
          , "http://buxi-dev.buxikorea.com/static/media/notice_stopcarsharing3x.d74e3742.png"
          , "물고기" + i
          , "9월~6월" + i
          , "4시~19시" + i
          , "꽃 주변" + i
          , "240" + i
          , "동물의 숲" + i
          , false
          , null);
      list.add(wikiData);
    }

  }

  @Test
  public void 물고기저장_물고기조회() {
    Wiki wiki = WikiTest.newWiki;
    wikiRepository.save(wiki);
    Optional<Wiki> wikiData = wikiRepository.findByWikiId(wiki.getWikiId());
    WikiDto.Response wikiResponse = WikiDto.Response.of(wikiData.get());
    Assert.assertEquals("fish202004202400112200", wikiResponse.getWikiId());
  }

  @Test
  public void 물고기리스트_저장() {
    List<Wiki> res = list.stream()
        .map(wikiRepository::save)
        .collect(Collectors.toList());
    Assert.assertEquals("fish20200420240011220099",res.get(99).getWikiId());

  }
}