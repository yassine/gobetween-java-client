package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class JsonServiceDiscovery extends ServiceDiscovery {
  private String jsonEndpoint;
  private String jsonHostPattern;
  private String jsonPortPattern;
  private String jsonWeightPattern;
  private String jsonPriorityPattern;
}
