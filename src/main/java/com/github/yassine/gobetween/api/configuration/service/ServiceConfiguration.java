package com.github.yassine.gobetween.api.configuration.service;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.yassine.gobetween.api.configuration.service.discovery.ServiceDiscovery;
import com.github.yassine.gobetween.api.configuration.service.healthcheck.HealthCheck;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "protocol")
@JsonSubTypes({
  @JsonSubTypes.Type(value = TCPServiceConfiguration.class, name = "tcp"),
  @JsonSubTypes.Type(value = UDPServiceConfiguration.class, name = "udp"),
  @JsonSubTypes.Type(value = TLSServiceConfiguration.class, name = "tls")})
@Getter @Setter @Accessors(chain = true)
@ToString(of = {"bind","maxConnections","discovery"})
public abstract class ServiceConfiguration {
  private String weight;
  private String bind;
  private String balance;
  //max_connections
  private Integer maxConnections;
  private String clientIdleTimeout;
  private String backendIdleTimeout;
  private String backendConnectionTimeout;
  private ServiceDiscovery discovery;
  private HealthCheck healthcheck;
  private AccessConfiguration access;
  private ProxyProtocol proxyProtocol;
}

