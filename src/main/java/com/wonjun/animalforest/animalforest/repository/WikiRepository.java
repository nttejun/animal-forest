package com.wonjun.animalforest.animalforest.repository;

import com.wonjun.animalforest.animalforest.domain.wiki.Wiki;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<Wiki, Long> {

  Optional<Wiki> findByWikiId(String wikiId);
}
