package com.github.yassine.gobetween.api.configuration.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class AccessConfiguration {
  @JsonProperty("default")
  private String defaults;
  private List<String> rules;
}
