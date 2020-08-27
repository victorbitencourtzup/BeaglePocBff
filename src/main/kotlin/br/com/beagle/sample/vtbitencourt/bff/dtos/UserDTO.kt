package br.com.beagle.sample.vtbitencourt.bff.dtos

import java.util.*

data class UserDTO(val id: UUID, var email: String, var password: String, var name: String)