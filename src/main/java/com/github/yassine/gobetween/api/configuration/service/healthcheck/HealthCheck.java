package com.github.yassine.gobetween.api.configuration.service.healthcheck;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonSubTypes({
  @JsonSubTypes.Type(value = ExecHealthCheck.class, name = "exec"),
  @JsonSubTypes.Type(value = NoneHealthCheck.class, name = "none"),
  @JsonSubTypes.Type(value = PingHealthCheck.class, name = "ping")})
@Getter @Setter @Accessors(chain = true)
public abstract class HealthCheck {
  private String interval = "2s";
  private Integer passes;
  private Integer fails;
  private String timeout;
}
