package com.github.yassine.gobetween.api;

import com.github.yassine.gobetween.api.statistics.ServiceBackendStatistics;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter @Setter @Accessors(chain = true)
public class ServiceStatistics {
  private int activeConnections;
  private int rxTotal;
  private int txTotal;
  private int rxSecond;
  private int txSecond;
  private List<ServiceBackendStatistics> backends;
}
