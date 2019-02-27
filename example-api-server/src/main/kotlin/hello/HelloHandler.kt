package exampleapi.hello

import mu.KotlinLogging
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono


data class GreetResponse(val message: String)

class HelloHandler() {
    private val logger = KotlinLogging.logger {}

    fun greet(request: ServerRequest): Mono<ServerResponse> {

        val name = request.queryParam("name").orElse("guest")
        logger.info { "greeting ${name}." }
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(
                        Mono.just(GreetResponse("Hello ${name} !!"))
                        , GreetResponse::class.java)

    }
}