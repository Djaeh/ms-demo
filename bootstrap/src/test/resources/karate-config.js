function fn() {

  var serverPort = karate.properties['server.port'];
  return {
    urlBase: karate.properties['server.url'],
  };
}
