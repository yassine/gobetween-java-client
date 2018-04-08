package com.github.yassine.gobetween.api.configuration.service;

import com.github.yassine.gobetween.api.configuration.service.protocol.UDPConfiguration;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class UDPServiceConfiguration extends ServiceConfiguration{
  private UDPConfiguration udp;
}
