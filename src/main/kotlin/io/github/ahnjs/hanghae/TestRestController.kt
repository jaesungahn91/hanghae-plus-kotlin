package io.github.ahnjs.hanghae

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController {

    @GetMapping("/test")
    fun test() {}

}