package br.com.beagle.sample.vtbitencourt.bff.dtos

import java.util.*

data class VaccineDTO(var id: UUID, val urlBanner: String, val urlImage: String, var title: String, var description: String, var fullDescription: String, var Symptoms: String) {
}