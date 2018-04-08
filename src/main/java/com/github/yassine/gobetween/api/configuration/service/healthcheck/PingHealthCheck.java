package com.github.yassine.gobetween.api.configuration.service.healthcheck;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class PingHealthCheck extends HealthCheck {
  private String pingTimeoutDuration = "2s";
}
