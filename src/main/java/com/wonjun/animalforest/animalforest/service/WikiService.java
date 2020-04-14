package com.wonjun.animalforest.animalforest.service;

import static java.util.stream.Collectors.toList;

import com.wonjun.animalforest.animalforest.domain.wiki.Wiki;
import com.wonjun.animalforest.animalforest.repository.WikiRepository;
import com.wonjun.animalforest.animalforest.service.dto.WikiDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class WikiService {

  private WikiRepository wikiRepository;

  @Transactional
  public List<Wiki> saveAll(List<Wiki> wikis){
    return wikis.stream()
        .map(this::save)
        .collect(toList());
  }

  @Transactional
  public Wiki save(Wiki wiki){
    return wikiRepository.findByWikiId(wiki.getWikiId())
        .map(savedWiki -> savedWiki.update(wiki))
        .orElseGet(() -> wikiRepository.save(wiki));
  }

  private List<WikiDto.Response> toResponse(List<Wiki> wikis){
    return wikis.stream()
        .map(WikiDto.Response::of)
        .collect(toList());
  }
}
