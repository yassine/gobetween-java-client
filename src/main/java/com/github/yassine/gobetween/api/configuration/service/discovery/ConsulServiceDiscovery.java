package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class ConsulServiceDiscovery extends ServiceDiscovery {
  private String consulHost;
  private String consulServiceName;
  private String consulServiceTag;
  private boolean consulServicePassingOnly;
  private boolean consulTlsEnabled = false;
  private String consulTlsCertPath;
  private String consulTlsKeyPath;
  private String consulTlsCacertPath;
}
