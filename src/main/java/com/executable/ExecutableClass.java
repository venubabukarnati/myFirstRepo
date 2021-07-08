package com.executable;

import com.poc.vertex.MaintainCacheVerticle;
import io.vertx.core.Vertx;

public class ExecutableClass {

  public static void main(String[] args) {

    System.out.println("Inside the ExecutableClass -->");

    MaintainCacheVerticle maintainCacheVerticle = new MaintainCacheVerticle();

    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(maintainCacheVerticle,
        stringAsyncResult -> System.out.println("MaintainCacheVerticle deployment complete"));
  }
}

