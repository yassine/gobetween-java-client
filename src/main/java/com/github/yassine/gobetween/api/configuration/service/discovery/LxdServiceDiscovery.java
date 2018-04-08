package com.github.yassine.gobetween.api.configuration.service.discovery;

import lombok.Getter;

@Getter
public class LxdServiceDiscovery extends ServiceDiscovery {
  private String lxdServerAddress;
  private String lxdServerRemoteName;
  private String lxdServerRemotePassword;
  private String lxdConfigDirectory;
  private boolean lxdGenerateClientCerts;
  private boolean lxdAcceptServerCert;
  private String lxdContainerLabelKey;
  private String lxdContainerLabelValue;
  private int lxdContainerPort;
  private String lxdContainerPortKey;
  private String lxdContainerInterface;
  private String lxdContainerInterfaceKey;
  private String lxdContainerSNIKey;
  private String lxdContainerAddressType;
}
