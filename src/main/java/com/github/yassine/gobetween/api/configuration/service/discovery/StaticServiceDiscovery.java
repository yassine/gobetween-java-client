package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Getter @Setter @Accessors(chain = true)
@ToString(of = {"staticList"})
public class StaticServiceDiscovery extends ServiceDiscovery {
  private List<String> staticList;
}
