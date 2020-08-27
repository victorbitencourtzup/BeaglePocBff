package br.com.beagle.sample.vtbitencourt.bff.controllers

import br.com.beagle.sample.vtbitencourt.bff.screen_builders.BeagleSampleScreenBuilder
import br.com.beagle.sample.vtbitencourt.bff.screen_builders.home.HomeScreenBuilder
import br.com.beagle.sample.vtbitencourt.bff.screen_builders.IntroScreenBuilder
import br.com.beagle.sample.vtbitencourt.bff.screen_builders.buildSampleBeagleContext
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AppController(
        private val introScreenBuilder: IntroScreenBuilder,
        private val homeScreenBuilder: HomeScreenBuilder,
        private val sampleScreenBuilder : BeagleSampleScreenBuilder
) {

    @GetMapping("app/start")
    fun getScreen() = introScreenBuilder.createIntro()

    @GetMapping("app/samples")
    fun getSamplesScreen() = buildSampleBeagleContext()

}