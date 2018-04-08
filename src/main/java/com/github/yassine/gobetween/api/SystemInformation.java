package com.github.yassine.gobetween.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Getter @Setter @Accessors(chain = true)
public class SystemInformation {
  private int pid;
  @JsonProperty("startTime")
  private String startTime;
  private String time;
  private String uptime;
  private String version;
  private Map<String,String> configuration;
}
