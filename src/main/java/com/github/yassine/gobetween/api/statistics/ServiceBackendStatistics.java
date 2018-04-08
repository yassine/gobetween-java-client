package com.github.yassine.gobetween.api.statistics;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true)
public class ServiceBackendStatistics {

  private String host;
  private String port;
  private int priority;
  private int weight;
  private Statistics stats;


  @Getter @Setter @Accessors(chain = true)
  public static class Statistics {
    private String live;
    private String totalConnections;
    private String activeConnections;
    private String refusedConnections;
    private int rx;
    private int tx;
    private String rxSecond;
    private String txSecond;
  }

}
