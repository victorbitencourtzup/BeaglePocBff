package br.com.beagle.sample.vtbitencourt.bff.screen_builders.home

import br.com.beagle.sample.vtbitencourt.bff.dtos.VaccineDTO
import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.core.*
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.ComposeComponent
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.ListView
import br.com.zup.beagle.widget.ui.Text

@BeaglePreview
fun createVaccineList(vaccineList: List<VaccineDTO>) = VaccineListScreenBuilder(vaccineList).build()

class VaccineListScreenBuilder(private val vaccineList: List<VaccineDTO>) : ComposeComponent {

    private fun createVaccineCardView(
            vaccine: VaccineDTO
    ): Container = Container(
            children = listOf(
                    Image(path = ImagePath.Remote(remoteUrl = vaccine.urlImage)).applyStyle(
                            Style(
                                    size = Size(width = 70.unitReal(), height = 70.unitReal()),
                                    margin = EdgeValue(10.unitReal(), 10.unitReal(), 10.unitReal(), 10.unitReal(), 10.unitReal())
                            )
                    ),
                    Container(
                            children = listOf(
                                    Text(text = vaccine.title, styleId = "TitleCardView", textColor = "#324a61"),
                                    Text(text = vaccine.description, styleId = "TextCardView", textColor = "#324a61"),
                                    Container(
                                            children = listOf(
                                                    Touchable(
                                                            child = Text(text = "ver mais", styleId = "TextCardView", textColor = "#FFA500")
                                                                    .applyStyle(
                                                                            Style(
                                                                                    size = Size(minWidth = 48.unitReal()),
                                                                                    flex = Flex(
                                                                                            alignSelf = AlignSelf.FLEX_END,
                                                                                            alignContent = AlignContent.FLEX_END,
                                                                                            justifyContent = JustifyContent.CENTER,
                                                                                            alignItems = AlignItems.CENTER)
                                                                            )
                                                                    ),
                                                            onPress = listOf(
                                                                    Navigate.PushStack(Route.Remote("/vaccine/detail/${vaccine.id}"))
                                                            )
                                                    )
                                            )
                                    ).applyStyle(Style(
                                            positionType = PositionType.ABSOLUTE,
                                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                                            flex = Flex(
                                                    flexDirection = FlexDirection.COLUMN_REVERSE
                                            )
                                    ))
                            )
                    ).applyStyle(Style(
                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                            padding = EdgeValue(10.unitReal(), 10.unitReal(), 10.unitReal(), 10.unitReal()),
                            flex = Flex(
                                    flexDirection = FlexDirection.COLUMN
                            )
                    ))

            )
    ).applyStyle(
            Style(backgroundColor = "#E9E9E9",
                    size = Size(height = 120.unitReal()),
                    margin = EdgeValue(10.unitReal(), 10.unitReal(), 10.unitReal(), 0.unitReal()),
                    cornerRadius = CornerRadius(30.0),
                    flex = Flex(
                            grow = 1.0,
                            flexDirection = FlexDirection.ROW,
                            justifyContent = JustifyContent.FLEX_START,
                            alignItems = AlignItems.CENTER
                    ),
                    positionType = PositionType.RELATIVE,
                    display = Display.FLEX)
    )

    private fun createVaccineListView(): List<ServerDrivenComponent> {
        var list = mutableListOf<ServerDrivenComponent>();

        for (vaccine in vaccineList) {
            list.add(createVaccineCardView(vaccine))
        }

        return list
    }

    override fun build(): ListView = ListView(
            direction = ListDirection.VERTICAL,
            children = createVaccineListView()
    )

}