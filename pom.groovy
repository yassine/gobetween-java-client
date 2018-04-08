project {
  modelVersion '4.0.0'
  groupId 'com.github.yassine'
  artifactId 'gobetween-java-client'
  version '0.1.0-SNAPSHOT'
  licenses {
    license {
      name 'The Apache License, Version 2.0'
      url 'http://www.apache.org/licenses/LICENSE-2.0.txt'
    }
  }
  properties{
    'project.build.sourceEncoding' 'UTF-8'
  }
  dependencies {
    dependency 'com.fasterxml.jackson.core:jackson-annotations:2.8.8'
    dependency 'com.fasterxml.jackson.core:jackson-core:2.8.8'
    dependency 'com.fasterxml.jackson.core:jackson-databind:2.8.8'
    dependency 'com.google.inject:guice:4.1.0'
    dependency 'io.github.openfeign:feign-core:9.5.0'
    dependency 'io.github.openfeign:feign-jackson:9.5.0'
    dependency 'io.github.openfeign:feign-okhttp:9.5.0'
    dependency 'org.projectlombok:lombok:1.16.10'
    //logging
    dependency 'org.apache.logging.log4j:log4j-api:2.10.0'
    dependency 'org.apache.logging.log4j:log4j-core:2.10.0'
    dependency 'org.apache.logging.log4j:log4j-slf4j-impl:2.10.0'
    dependency 'org.apache.logging.log4j:log4j-1.2-api:2.10.0'
    dependency 'org.slf4j:slf4j-api:1.7.21'
    //test
    dependency 'org.spockframework:spock-core:1.1-groovy-2.4:test'
    dependency 'org.spockframework:spock-guice:1.1-groovy-2.4:test'
    dependency 'org.codehaus.groovy:groovy-all:2.4.13:test'
    dependency 'junit:junit:4.12:test'
    dependency 'cglib:cglib-nodep:3.2.5:test'
    dependency 'com.github.docker-java:docker-java:3.0.6:test'
    dependency 'javax.ws.rs:javax.ws.rs-api:2.0:test'
  }
  build {
    pluginManagement {
      plugins {
        plugin {
          artifactId 'maven-compiler-plugin'
          version '3.7.0'
          configuration {
            source '8'
            target '8'
          }
        }
      }
    }
    plugins {

      plugin {
        artifactId 'maven-compiler-plugin'
      }

      plugin {
        groupId 'org.jacoco'
        artifactId 'jacoco-maven-plugin'
        version '0.8.0'
        executions {
          execution {
            id 'prepare-agent'
            phase 'test-compile'
            goals {
              goal 'prepare-agent'
            }
            configuration {
              propertyName 'surefireArgLine'
              destFile '${project.build.directory}/coverage-reports/jacoco-ut.exec'
            }
          }
          execution {
            id 'post-test-reports'
            phase 'post-integration-test'
            goals {
              goal 'report'
            }
            configuration {
              dataFile '${project.build.directory}/coverage-reports/jacoco-ut.exec'
              outputDirectory '${project.reporting.outputDirectory}/code-coverage'
              excludes {
                exclude '**/api/*.class'
                exclude '**/api/**/*.class'
              }
            }
          }
        }
      }

      plugin {
        groupId 'org.codehaus.gmavenplus'
        artifactId 'gmavenplus-plugin'
        version '1.6'
        executions {
          execution {
            id 'generate-unit-tests'
            goals {
              goal 'compileTests'
              goal 'addTestSources'
            }
            configuration {
              testSources {
                testSource {
                  directory '${project.basedir}/src/test/unit-tests'
                  includes {
                    include '**/*.groovy'
                  }
                }
              }
              outputDirectory '${project.build.directory}/unit-tests'
            }
          }
          execution {
            id 'generate-functional-tests'
            goals {
              goal 'compileTests'
              goal 'addTestSources'
            }
            configuration {
              testSources {
                testSource {
                  directory '${project.basedir}/src/test/functional-tests'
                  includes {
                    include '**/*.groovy'
                  }
                }
              }
              outputDirectory '${project.build.directory}/functional-tests'
            }
          }
        }
      }

      plugin {
        artifactId 'maven-surefire-plugin'
        version '2.20.1'
        executions {
          execution {
            id 'functional-tests'
            goals {
              goal 'test'
            }
            configuration {
              testClassesDirectory '${project.build.directory}/functional-tests'
            }
          }
        }
        configuration{
          useFile 'false'
          testClassesDirectory '${project.build.directory}/unit-tests'
          includes {
            include '**/*Spec'
          }
          additionalClasspathElements {
            additionalClasspathElement '${project.basedir}/src/test/resources'
            additionalClasspathElement '${project.build.testOutputDirectory}'
          }
          argLine '${surefireArgLine}'
        }
      }

      plugin {
        groupId 'org.eluder.coveralls'
        artifactId 'coveralls-maven-plugin'
        version '4.3.0'
        configuration {
          repoToken '${env.COVERALLS_REPO_KEY}'
          jacocoReports '${project.reporting.outputDirectory}/code-coverage/jacoco.xml'
        }
      }
    }
  }
}
