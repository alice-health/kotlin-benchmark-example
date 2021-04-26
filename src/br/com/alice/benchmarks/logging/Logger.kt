package br.com.alice.benchmarks.logging

import org.slf4j.LoggerFactory

object Logger {
    private val logger: org.slf4j.Logger = LoggerFactory.getLogger("application")

    fun info(message: String) {
        logger.info(message)
    }

}
