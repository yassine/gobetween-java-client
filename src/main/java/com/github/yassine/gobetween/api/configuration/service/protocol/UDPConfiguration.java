package com.github.yassine.gobetween.api.configuration.service.protocol;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class UDPConfiguration {
  private int maxResponses;
}
