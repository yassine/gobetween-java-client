# gobetween-java-client
![Build Status](https://www.travis-ci.org/yassine/gobetween-java-client.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/yassine/gobetween-java-client/badge.svg?branch=master)](https://coveralls.io/github/yassine/gobetween-java-client?branch=master)

A java gobetween api client for [gobetween](https://github.com/yyyar/gobetween).

#### Usage

Create a client using the builder:

`GobetweenClient client = Gobetween.builder().withURL(URI.create("http://localhost:1080").toURL()).build();`

`//And you're ready to go ! See the GobetweenClient interface for more available calls. `

`SystemInformation systemInformation = client.getSystemInformation();`
