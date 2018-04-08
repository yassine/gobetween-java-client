package com.github.yassine.gobetween.api.configuration.service.protocol;

import lombok.Getter;

import java.util.List;

@Getter
public abstract class CommonTLS {
  private List<String> ciphers;
  private boolean preferServerCiphers;
  private String minVersion;
  private String maxVersion;
  private boolean sessionTickets;
  private String certPath;
  private String keyPath;
}
