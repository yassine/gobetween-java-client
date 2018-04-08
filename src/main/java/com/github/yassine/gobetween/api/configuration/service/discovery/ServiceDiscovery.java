package com.github.yassine.gobetween.api.configuration.service.discovery;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonSubTypes({
  @JsonSubTypes.Type(value = ConsulServiceDiscovery.class, name = "consul"),
  @JsonSubTypes.Type(value = DockerServiceDiscovery.class, name = "docker"),
  @JsonSubTypes.Type(value = ExecServiceDiscovery.class, name = "exec"),
  @JsonSubTypes.Type(value = JsonServiceDiscovery.class, name = "json"),
  @JsonSubTypes.Type(value = PlainTextServiceDiscovery.class, name = "plaintext"),
  @JsonSubTypes.Type(value = SrvServiceDiscovery.class, name = "srv"),
  @JsonSubTypes.Type(value = StaticServiceDiscovery.class, name = "static"),
  @JsonSubTypes.Type(value = LxdServiceDiscovery.class, name = "lxd")
})
@Getter @Setter @Accessors(chain = true) @ToString(of = {"failpolicy","interval","timeout"})
public class ServiceDiscovery {
  private String failpolicy = "keeplast";
  private String interval = "0s";
  private String timeout = "5s";
}
