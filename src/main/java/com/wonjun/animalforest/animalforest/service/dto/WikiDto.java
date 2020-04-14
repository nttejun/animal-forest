package com.wonjun.animalforest.animalforest.service.dto;

import com.wonjun.animalforest.animalforest.domain.wiki.Wiki;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WikiDto {

  @Getter
  @Setter
  public static class Response {

    private Long id;
    private String wikiId;
    private String name;
    private String imgUrl;
    private String category;
    private String appearance_period;
    private String appearance_time;
    private String appearance_place;
    private String sale_price;
    private String appearance_first;
    private boolean isExcept;
    private String size;

    @Builder
    public Response(Long id, String wikiId, String name, String imgUrl, String category, String appearance_period,
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

    public static Response of(Wiki entity){
      return Response.builder()
          .id(entity.getId())
          .wikiId(entity.getWikiId())
          .name(entity.getName())
          .imgUrl(entity.getImgUrl())
          .category(entity.getCategory())
          .appearance_period(entity.getAppearance_period())
          .appearance_time(entity.getAppearance_time())
          .appearance_place(entity.getAppearance_place())
          .sale_price(entity.getSale_price())
          .appearance_first(entity.getAppearance_first())
          .isExcept(entity.isExcept())
          .size(entity.getSize())
          .build();
    }
  }

}
