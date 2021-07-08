package com.poc.vertex;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class MaintainCacheVerticle extends AbstractVerticle {

  @Override
  public void start() {

    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.post("/updateCache").handler(this::handleUpdateCache);
    router.post("/deleteCache").handler(this::handleDeleteCache);

    vertx.createHttpServer().requestHandler(router).listen(8081);
  }

  private void handleUpdateCache(RoutingContext routingContext) {
    JsonObject requestBody = routingContext.getBodyAsJson();
    System.out.println("Update requestBody -->" + requestBody);
    HttpServerResponse response = routingContext.response();

    JsonObject responseBody = new JsonObject();


    responseBody.put("status", "Success");

    response.putHeader("content-type", "application/json").end(responseBody.encodePrettily());
  }

  private void handleDeleteCache(RoutingContext routingContext) {
    JsonObject requestBody = routingContext.getBodyAsJson();
    System.out.println("Delete requestBody -->" + requestBody);
    HttpServerResponse response = routingContext.response();

    JsonObject responseBody = new JsonObject();

    responseBody.put("status", "Success");

    response.putHeader("content-type", "application/json").end(responseBody.encodePrettily());
  }

}
