package com.github.yassine.gobetween.api.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class LoggingConfiguration {
  private String level = "info";
  private String stdout = "stdout";
}
