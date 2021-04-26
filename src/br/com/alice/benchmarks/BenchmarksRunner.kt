package br.com.alice.benchmarks

import br.com.alice.benchmarks.logging.LogReflectionBenchmark
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder


fun main() {

    val options = OptionsBuilder()
        .include(LogReflectionBenchmark::class.java.simpleName)
        .forks(2)
        .threads(2)
        .warmupBatchSize(2)
        .warmupIterations(2)
        .measurementIterations(2)
        .resultFormat(ResultFormatType.JSON)
        .output("build/benchmark_output.log")
        .result("build/benchmark_result.json")
        .build()

    Runner(options).run()
}
