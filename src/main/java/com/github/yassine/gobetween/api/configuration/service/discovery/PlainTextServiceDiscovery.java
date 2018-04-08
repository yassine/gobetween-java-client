package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class PlainTextServiceDiscovery extends ServiceDiscovery {
  private String kind;
  private String plaintextEndpoint;
  private String plaintextRegexPattern;
}
