package com.wonjun.animalforest.animalforest.utils;

import com.wonjun.animalforest.animalforest.exception.PageNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParser {

  public static Document get(String url) {return parse(url, Method.GET, null); }
  public static Document post(String url, Map<String, String> params){ return parse(url, Method.POST, params); }

  private static Document parse(String url, Method method, Map<String, String> params) {
    try {
      Connection connection = Jsoup.connect(url).method(method);
      if(Objects.nonNull(params)){
        connection.data(params);
      }
      return connection.execute().parse();
    } catch (IOException e){
      throw new PageNotFoundException();
    }
  }


}
