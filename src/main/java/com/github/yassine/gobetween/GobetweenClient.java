package com.github.yassine.gobetween;

import com.github.yassine.gobetween.api.ServiceStatistics;
import com.github.yassine.gobetween.api.SystemInformation;
import com.github.yassine.gobetween.api.configuration.ServersConfiguration;
import com.github.yassine.gobetween.api.configuration.service.ServiceConfiguration;
import feign.Param;
import feign.RequestLine;

public interface GobetweenClient {

  @RequestLine("GET /")
  SystemInformation getSystemInformation();

  @RequestLine("GET /servers")
  ServersConfiguration getServers();

  @RequestLine("DELETE /servers/{serviceName}")
  void removeService(@Param("serviceName") String serviceName);

  @RequestLine("POST /servers/{serviceName}")
  String addService(@Param("serviceName") String serviceName, ServiceConfiguration service);

  @RequestLine("GET /servers/{serviceName}/stats")
  ServiceStatistics getServiceStats(@Param("serviceName") String serviceName);

}
