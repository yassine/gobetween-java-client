package com.github.yassine.gobetween.api.configuration.service;

import com.github.yassine.gobetween.api.configuration.service.protocol.BackendTLS;
import com.github.yassine.gobetween.api.configuration.service.protocol.TLSConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class TLSServiceConfiguration {
  private TLSConfiguration tls;
  private BackendTLS backendsTls;
  private ServiceNameIndication sni;
}
