package com.github.yassine.gobetween.api.configuration;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Getter @Setter @Accessors(chain = true)
public class Configuration {
  private ServersConfiguration servers;
  private LoggingConfiguration logging;
}
