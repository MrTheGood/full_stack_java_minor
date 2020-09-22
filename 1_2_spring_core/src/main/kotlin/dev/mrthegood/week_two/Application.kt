package dev.mrthegood.week_two

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AnnotationConfigApplicationContext

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)

    val appContext = AnnotationConfigApplicationContext()
    appContext.environment.setActiveProfiles("caps")
    appContext.refresh()
}