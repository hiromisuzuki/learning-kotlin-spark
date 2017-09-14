package learning

import com.google.inject.Guice
import learning.controller.EchoController
import learning.transformer.JsonTransformer
import spark.Spark.get

object Server {
    @JvmStatic
    fun main(args: Array<String>) {
        val injector = Guice.createInjector()
        val echo = injector.getInstance(EchoController::class.java)
        get("/echo", echo.echo, JsonTransformer())
    }
}