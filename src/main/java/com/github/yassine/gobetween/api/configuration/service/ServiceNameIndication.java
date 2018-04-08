package com.github.yassine.gobetween.api.configuration.service;

import lombok.Getter;

@Getter
public class ServiceNameIndication {
  protected String readTimeout;
  protected String hostnameMatchingStrategy;
  protected String unexpectedHostnameStrategy;
}
