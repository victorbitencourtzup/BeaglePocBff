package br.com.beagle.sample.vtbitencourt.bff.screen_builders.home

import br.com.beagle.sample.vtbitencourt.bff.configuration.MemoryDatabase
import br.com.beagle.sample.vtbitencourt.bff.dtos.UserDTO
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
import br.com.zup.beagle.widget.ui.*
import org.springframework.stereotype.Service

@Service
class HomeScreenBuilder(private val storage: MemoryDatabase) {

    fun createHomeScreen(user: UserDTO): Screen = Screen(
            context = ContextData(
                    id = "user",
                    value = user
            ),
            child = Container(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            Text(text = "Olá, ${user.name}", styleId = "Design.System.Title.ViewPager", alignment = TextAlignment.CENTER)
                                    )
                            ).applyStyle(
                                    Style(backgroundColor = "#324a61",
                                            size = Size(width = 100.unitPercent(), height = 120.unitReal()),
                                            flex = Flex(
                                                    flexDirection = FlexDirection.COLUMN,
                                                    justifyContent = JustifyContent.CENTER,
                                                    alignItems = AlignItems.CENTER
                                            ),
                                            positionType = PositionType.RELATIVE,
                                            display = Display.FLEX)
                            ),
                            TabView(
                                    children =
                                    listOf(
                                            TabItem("Caderneta",
                                                    Image(ImagePath.Remote("https://i.ibb.co/k9tYwtX/selo-do-exemplo-28420393.jpg")
                                                    )
                                            ),
                                            TabItem("Vacinas",
                                                    child = createVaccineList(storage.vaccines)
                                            )
                                    )
                            )
                    )
            )

    )

}