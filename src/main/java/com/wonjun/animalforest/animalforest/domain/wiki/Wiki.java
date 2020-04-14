package com.wonjun.animalforest.animalforest.domain.wiki;

import static com.wonjun.animalforest.animalforest.utils.ValidationUtils.isNotBlank;

import com.wonjun.animalforest.animalforest.exception.CannotChangeException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@NoArgsConstructor
@Getter
@Table
@DynamicUpdate
@ToString
public class Wiki {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, updatable = false, unique = true)
  private String wikiId;

  @Column
  private String name;

  @Column
  private String imgUrl;

  @Column
  private String category;

  @Column
  private String appearance_period;

  @Column
  private String appearance_time;

  @Column
  private String appearance_place;

  @Column
  private String sale_price;

  @Column
  private String appearance_first;

  @Column
  private boolean isExcept;

  @Column
  private String size;

  @Builder
  public Wiki(Long id, String wikiId, String name, String imgUrl, String category, String appearance_period,
      String appearance_time, String appearance_place, String sale_price, String appearance_first,
      boolean isExcept, String size) {
    this.id = id;
    this.wikiId = wikiId;
    this.name = name;
    this.imgUrl = imgUrl;
    this.category = category;
    this.appearance_period = appearance_period;
    this.appearance_time = appearance_time;
    this.appearance_place = appearance_place;
    this.sale_price = sale_price;
    this.appearance_first = appearance_first;
    this.isExcept = isExcept;
    this.size = size;
  }

  public Wiki update(Wiki updateWiki) {
    if(!equals(updateWiki)) {
      throw new CannotChangeException("업데이트를 진행 할 수 없습니다.");
    }

    if(isNotBlank(updateWiki.name)) name = updateWiki.name;
    if(isNotBlank(updateWiki.imgUrl)) imgUrl = updateWiki.imgUrl;
    if(isNotBlank(updateWiki.category)) category = updateWiki.category;
    if(isNotBlank(updateWiki.appearance_period)) appearance_period = updateWiki.appearance_period;
    if(isNotBlank(updateWiki.appearance_time)) appearance_time = updateWiki.appearance_time;
    if(isNotBlank(updateWiki.appearance_place)) appearance_place = updateWiki.appearance_place;
    if(isNotBlank(updateWiki.sale_price)) sale_price = updateWiki.sale_price;
    if(isNotBlank(updateWiki.appearance_first)) appearance_first = updateWiki.appearance_first;
    if(isNotBlank(updateWiki.isExcept)) isExcept = updateWiki.isExcept;
    if(isNotBlank(updateWiki.size)) size = updateWiki.size;

    return this;
  }

}

