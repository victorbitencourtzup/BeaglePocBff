package br.com.beagle.sample.vtbitencourt.bff.screen_builders.home

import br.com.beagle.sample.vtbitencourt.bff.dtos.VaccineDTO
import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

@BeaglePreview
fun createVaccineDetail(vaccine: VaccineDTO) = VaccineDetailScreenBuilder(vaccine).build()

class VaccineDetailScreenBuilder(private val vaccine: VaccineDTO) : ScreenBuilder {

    override fun build(): Screen = Screen(
            navigationBar = NavigationBar(
                    title = "Detalhes",
                    showBackButton = true
            ),
            child = Container(
                    children = listOf(
                            br.com.zup.beagle.widget.ui.Image(
                                    mode = ImageContentMode.CENTER_CROP,
                                    path = ImagePath.Remote(remoteUrl = vaccine.urlBanner)).applyStyle(
                                    Style(
                                            size = Size(width = 100.unitPercent(), height = 200.unitReal())
                                    )
                            ),
                           Image(path = ImagePath.Remote(remoteUrl = vaccine.urlImage)).applyStyle(
                                    Style(
                                            positionType = PositionType.ABSOLUTE,
                                            size = Size(width = 100.unitReal(), height = 100.unitReal()),
                                            margin = EdgeValue(10.unitReal(), 150.unitReal(), 10.unitReal(), 10.unitReal(), 10.unitReal())
                                    )
                            ),
                            ScrollView(
                                    children = listOf(
                                            Text(text = vaccine.fullDescription).applyStyle(
                                                    Style(
                                                            positionType = PositionType.RELATIVE,
                                                            margin = EdgeValue(10.unitReal(), 60.unitReal(), 10.unitReal(), 10.unitReal(), 10.unitReal())
                                                    )
                                            )
                                    )
                            )

                    )
            ).applyStyle(
                    style = Style(
                            flex = Flex(
                                    grow = 1.0
                            )
                    )
            )
    )

}