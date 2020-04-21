package com.wonjun.animalforest.animalforest.service;

import com.wonjun.animalforest.animalforest.domain.wiki.Wiki;
import com.wonjun.animalforest.animalforest.domain.wiki.WikiTest;
import com.wonjun.animalforest.animalforest.repository.WikiRepository;
import com.wonjun.animalforest.animalforest.service.dto.WikiDto;
import com.wonjun.animalforest.animalforest.service.dto.WikiDto.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WikiServiceTest {

  @Mock
  private WikiRepository wikiRepository;

  @InjectMocks
  private WikiService wikiService;

}