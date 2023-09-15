package io.github.ahnjs.hanghae

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController {

    @GetMapping("/")
    fun test() {
        println("테스트를 위한")
    }
}
