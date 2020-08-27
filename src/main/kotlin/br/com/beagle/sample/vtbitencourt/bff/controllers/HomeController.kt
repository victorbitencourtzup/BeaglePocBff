package br.com.beagle.sample.vtbitencourt.bff.controllers

import br.com.beagle.sample.vtbitencourt.bff.configuration.MemoryDatabase
import br.com.beagle.sample.vtbitencourt.bff.dtos.UserDTO
import br.com.beagle.sample.vtbitencourt.bff.screen_builders.home.HomeScreenBuilder
import br.com.beagle.sample.vtbitencourt.bff.screen_builders.home.createVaccineDetail
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HomeController(
        private val homeScreenBuilder: HomeScreenBuilder,
        private val storage: MemoryDatabase
) {

    @GetMapping("home/{id}")
    fun getHomeScreen(@PathVariable id : UUID) : br.com.zup.beagle.widget.layout.Screen {

        var user = storage.users[storage.users.indexOfFirst { l -> l.id.equals(id) }] // looking for the user bt id

        return homeScreenBuilder.createHomeScreen(user) // build the screen for the user found
    }

    @GetMapping("home")
    fun getHome2Screen() : br.com.zup.beagle.widget.layout.Screen {

        return homeScreenBuilder.createHomeScreen(UserDTO( name = "teste", id = UUID.randomUUID(), email = "teste", password = "teste" )) // build the screen for the user found
    }

    @GetMapping("vaccine/detail/{id}")
    fun getVaccineDetail(@PathVariable id : UUID) : br.com.zup.beagle.widget.layout.Screen {

        var vaccine = storage.vaccines[storage.vaccines.indexOfFirst { list -> list.id.equals(id) }]

        return createVaccineDetail(vaccine) // build the screen for the user found
    }

}
