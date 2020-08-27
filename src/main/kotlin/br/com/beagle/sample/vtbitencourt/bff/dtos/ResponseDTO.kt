package br.com.beagle.sample.vtbitencourt.bff.dtos

data class ResponseDTO<D>(val isSuccess: Boolean, val data: D? = null, val error: String? = null)