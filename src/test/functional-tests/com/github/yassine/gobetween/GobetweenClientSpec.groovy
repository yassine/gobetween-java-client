package com.github.yassine.gobetween

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.api.model.ExposedPort
import com.github.dockerjava.api.model.PortBinding
import com.github.dockerjava.core.DockerClientBuilder
import com.github.yassine.gobetween.api.SystemInformation
import com.github.yassine.gobetween.api.configuration.service.TCPServiceConfiguration
import com.github.yassine.gobetween.api.configuration.service.discovery.StaticServiceDiscovery
import com.google.common.collect.ImmutableMap
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class GobetweenClientSpec extends Specification {

  @Shared
  GobetweenClient gobetweenClient
  @Shared
  DockerClient dockerClient
  @Shared
  String containerID

  def setupSpec (){
    gobetweenClient = Gobetween.builder().withURL(new URL("http://localhost:9000")).build()
    dockerClient = DockerClientBuilder.getInstance("unix:///var/run/docker.sock").build()
    containerID = dockerClient.createContainerCmd('yassine/alpine-gobetween')
      .withExposedPorts(ExposedPort.tcp(9000))
      .withPortBindings(PortBinding.parse("9000:9000"))
      .withName("gobetween")
      .withLabels(ImmutableMap.of("name","gobetween"))
      .exec().getId()
    dockerClient.startContainerCmd(containerID).exec()
  }

  def cleanupSpec (){
    gobetweenClient = Gobetween.builder().withURL(new URL("http://localhost:9000")).build()
    dockerClient = DockerClientBuilder.getInstance("unix:///var/run/docker.sock").build()
    dockerClient.killContainerCmd(containerID).exec()
    dockerClient.removeContainerCmd(containerID).exec()
  }

  def "GetSystemInformation: it should return system information"() {
    given:
    SystemInformation systemInformation = gobetweenClient.getSystemInformation()
    expect:
    systemInformation.getStartTime() != null
    systemInformation.getUptime()    != null
    systemInformation.getVersion()   != null
    systemInformation.getPid() > 0
    systemInformation.getConfiguration() != null
  }

  def "GetServers: "() {
    given:
    def systemInformation = gobetweenClient.getServers()
    def initialSize       = systemInformation.size()
    gobetweenClient.addService("testService", new TCPServiceConfiguration()
      .setBind(":8080")
      .setDiscovery(new StaticServiceDiscovery().setStaticList(Arrays.asList("tcp://localhost:9000")))
    )
    def createdSize    = gobetweenClient.getServers().size()
    def createdService = gobetweenClient.getServers().get("testService")
    expect:
    createdService.getBind() != null
    initialSize == 0
    createdSize == 1
  }

  def "RemoveService" () {
    given:
    gobetweenClient.removeService("testService")
    expect:
    gobetweenClient.getServers().size() == 0
  }
}
