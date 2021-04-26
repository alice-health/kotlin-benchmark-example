package br.com.alice.benchmarks.logging

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.slf4j.LoggerFactory
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
open class LogReflectionBenchmark {

    @Benchmark
    fun logWithoutReflection() {
        Logger.info("benchmark logging message | className: LogReflectionBenchmark | functionName: log without reflection")
    }

    @Benchmark
    fun logWithReflectionThrowableGetStackTrace() {
        val stackTrace = Throwable().stackTrace[0]
        val functionName = stackTrace.methodName
        val className = stackTrace.className

        Logger.info("benchmark logging message | className: $className | functionName: $functionName")
    }

    @Benchmark
    fun logWithReflectionThreadGetStackTrace() {
        val stackTrace = Thread.currentThread().stackTrace[1]
        val functionName = stackTrace.methodName
        val className = stackTrace.className

        Logger.info("benchmark logging message | className: $className | functionName: $functionName")
    }

}
