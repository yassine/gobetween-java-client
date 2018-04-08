package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class SrvServiceDiscovery extends ServiceDiscovery {
  private String SrvLookupServer;
  private String SrvLookupPattern;
  private String SrvDnsProtocol;
}
