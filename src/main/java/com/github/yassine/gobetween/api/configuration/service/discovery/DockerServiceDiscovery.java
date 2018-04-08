package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class DockerServiceDiscovery extends ServiceDiscovery {
  private String dockerEndpoint;
  private String dockerContainerLabel;
  private String dockerContainerPrivatePort;
  private String dockerContainerHostEnvVar;
}
