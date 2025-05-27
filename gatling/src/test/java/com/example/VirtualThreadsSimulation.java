package com.example;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

public class VirtualThreadsSimulation extends Simulation {

  HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://localhost:8080") 
    .acceptHeader("application/json");

  ScenarioBuilder scn = scenario("Localhost GET Request")
    .exec(
      http("GET /id")
        .get("/id")
        .check(status().is(200))
    );

  {
    setUp(
      scn.injectOpen(
      		constantUsersPerSec(1000).during(60)
  		) 
    ).protocols(httpProtocol);
  }
}
