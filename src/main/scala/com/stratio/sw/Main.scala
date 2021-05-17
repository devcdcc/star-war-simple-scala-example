package com.stratio.sw

import zhttp.service.EventLoopGroup
import zhttp.service.server.ServerChannelFactory
import zio.{ExitCode, URIO, ZIO, console}

import scala.util.Try

object Main extends zio.App {

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    // Configure thread count using CLI
    val nThreads: Int = args.headOption.flatMap(x => Try(x.toInt).toOption).getOrElse(0)

    // Create a new server
    StratioWarServer.server.make
      .use(_ =>
        // Waiting for the server to start
        console.putStrLn(s"Server started on port ${StratioWarServer.PORT}")
          // Ensures the server doesn't die after printing
          *> ZIO.never,
      )
      .provideCustomLayer(ServerChannelFactory.auto ++ EventLoopGroup.auto(nThreads))
      .exitCode
  }
}
