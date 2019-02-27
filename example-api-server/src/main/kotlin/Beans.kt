package exampleapi

import exampleapi.hello.HelloHandler
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.server.router

val beans = beans {
    bean<HelloHandler>()
    bean {
        routes(ref<HelloHandler>())
    }
}

fun routes(helloHandler: HelloHandler) = router {
    "/".nest {
        GET("/", helloHandler::greet)
        "/hello".nest {
            GET("/", helloHandler::greet)
        }
    }
}
