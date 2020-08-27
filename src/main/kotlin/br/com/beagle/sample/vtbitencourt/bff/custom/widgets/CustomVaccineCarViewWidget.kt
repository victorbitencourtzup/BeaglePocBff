package br.com.beagle.sample.vtbitencourt.bff.custom.widgets

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget

@RegisterWidget
data class CustomVaccineCarViewWidget(val urlImage: String, val name: String, val description: String ): Widget()



