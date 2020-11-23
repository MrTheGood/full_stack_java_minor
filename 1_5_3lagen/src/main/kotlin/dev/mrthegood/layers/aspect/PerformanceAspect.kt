package dev.mrthegood.layers.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component


@Aspect
@Component
class PerformanceAspect {

    @Around("@annotation(PerformanceLogging)")
    @Throws(Throwable::class)
    fun testPerformance(joinPoint: ProceedingJoinPoint): Any {
        val startTime = System.currentTimeMillis()
        return joinPoint.proceed().also {
            print("${joinPoint.signature} executed in ${System.currentTimeMillis() - startTime}ms")
        }
    }
}

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class PerformanceLogging