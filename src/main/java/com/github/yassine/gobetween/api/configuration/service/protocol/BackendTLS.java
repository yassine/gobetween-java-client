package com.github.yassine.gobetween.api.configuration.service.protocol;

import lombok.Getter;

@Getter
public class BackendTLS extends CommonTLS {
  private boolean ignoreVerify;
  private String rootCaCertPath;
}
