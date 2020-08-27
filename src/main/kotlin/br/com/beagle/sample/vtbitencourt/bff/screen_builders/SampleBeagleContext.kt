package br.com.beagle.sample.vtbitencourt.bff.screen_builders

import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.*


data class UserDTO(var username: String, var password: String, var name: String)

fun buildSampleBeagleContext() = SampleBeagleContext()

class SampleBeagleContext : ScreenBuilder {

    override fun build(): Screen = Screen(
            child = Container(
                    context = ContextData(
                            id = "user",
                            value = UserDTO(username = "victor.bitencourt", password = "", name = "testeteste")
                    ),
                    children = listOf(
                            Text(text = "@{user.username}").applyStyle(
                                    Style(
                                            size = Size(width = 80.unitPercent(), height = 48.unitReal()),
                                            margin = EdgeValue(top = 10.unitReal())
                                    )
                            )

                    )).applyStyle(
                    Style(backgroundColor = "#FFFFFF",
                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                            flex = Flex(
                                    grow = 1.0,
                                    flexDirection = FlexDirection.ROW,
                                    justifyContent = JustifyContent.CENTER,
                                    alignItems = AlignItems.CENTER
                            ),
                            positionType = PositionType.RELATIVE,
                            display = Display.FLEX)

            )
    )

}


