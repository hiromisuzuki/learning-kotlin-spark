package learning.controller

import learning.service.EchoService
import spark.Route
import javax.inject.Inject

class EchoController @Inject constructor(private val echoService: EchoService) {

    data class EchoMessage(val body: String)

    val echo = Route { req, res ->
        EchoMessage(body = echoService.echo(req.queryParams("name")))
    }
}