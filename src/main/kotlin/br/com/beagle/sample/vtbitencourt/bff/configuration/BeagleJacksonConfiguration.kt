package br.com.beagle.sample.vtbitencourt.bff.configuration

import br.com.zup.beagle.serialization.jackson.BeagleModule
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.module.SimpleModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


class BeagleJacksonConfiguration {

    @Bean
    fun ObjectMapper(): ObjectMapper? {
        val module = SimpleModule().apply {
           // addSerializer(BeagleModule())

        }

        return null

    }

}