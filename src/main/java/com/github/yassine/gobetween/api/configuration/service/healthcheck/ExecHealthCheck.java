package com.github.yassine.gobetween.api.configuration.service.healthcheck;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class ExecHealthCheck extends HealthCheck {
  private String execCommand;
  private String execExpectedPositiveOutput;
  private String execExpectedNegativeOutput;
  private String execTimeoutDuration;
}
