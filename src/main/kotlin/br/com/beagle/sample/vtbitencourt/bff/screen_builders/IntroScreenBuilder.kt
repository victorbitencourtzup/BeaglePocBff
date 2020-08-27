package br.com.beagle.sample.vtbitencourt.bff.screen_builders

import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.Navigate
import br.com.zup.beagle.widget.action.Route
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.PageView
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.Button
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text
import org.springframework.stereotype.Service

@Service
class IntroScreenBuilder {

    fun createIntro(): Screen = Screen(
            child = PageView(
                    children = listOf(
                            Container(
                                    children = listOf(
                                            Image(path = ImagePath.Remote(remoteUrl = "http://10.0.2.2/images/virus.png")).applyStyle(
                                                    Style(size = Size(width = 190.unitReal(), height = 190.unitReal()))
                                            ),
                                            Text(text = "Opa, blz? Estamos passando por um momento muito difícil.",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Title.ViewPager"),
                                            Text(text = "Por isso separei algumas dicas importantes, para prevenção do coronavírus no dia a dia.",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Text.ViewPager"),

                                            Touchable(onPress = listOf(
                                                    Navigate.PushStack(Route.Remote("/login")),
                                                    Navigate.PopView()
                                            ),
                                                    child = Text(textColor = "white", text = "PULAR DICAS").applyStyle(
                                                            Style(margin = EdgeValue(top = 40.unitReal()))
                                                    )
                                            )
                                    )
                            ).applyStyle(
                                    Style(backgroundColor = "#FFA500",
                                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                                            flex = Flex(
                                                    grow = 1.0,
                                                    flexDirection = FlexDirection.COLUMN,
                                                    justifyContent = JustifyContent.CENTER,
                                                    alignItems = AlignItems.CENTER
                                            ),
                                            positionType = PositionType.RELATIVE,
                                            display = Display.FLEX)

                            ),
                            Container(
                                    children = listOf(
                                            Image(path = ImagePath.Remote(remoteUrl = "http://10.0.2.2/images/lavando_as_maos.png")).applyStyle(
                                                    Style(size = Size(width = 190.unitReal(), height = 190.unitReal()))
                                            ),
                                            Text(text = "Lave bem as mãos com água e sabão.",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Title.ViewPager"),
                                            Text(text = "por no mínimo 20 segundos, e tenha álcool gel acima de 70% sempre por perto.",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Text.ViewPager")


                                    )
                            ).applyStyle(
                                    Style(backgroundColor = "#2196F3",
                                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                                            flex = Flex(
                                                    grow = 1.0,
                                                    flexDirection = FlexDirection.COLUMN,
                                                    justifyContent = JustifyContent.CENTER,
                                                    alignItems = AlignItems.CENTER
                                            ),
                                            positionType = PositionType.RELATIVE,
                                            display = Display.FLEX)

                            ),
                            Container(
                                    children = listOf(
                                            Image(path = ImagePath.Remote(remoteUrl = "http://10.0.2.2/images/distancia.png")).applyStyle(
                                                    Style(size = Size(width = 190.unitReal(), height = 190.unitReal()))
                                            ),
                                            Text(text = "Mantenha sempre uma distância segura",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Title.ViewPager"),
                                            Text(text = "O Ministério da saúde recomenda manter uma distância de 2 metros de outras pessoas.",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Text.ViewPager")


                                    )
                            ).applyStyle(
                                    Style(backgroundColor = "#4CAF50",
                                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                                            flex = Flex(
                                                    grow = 1.0,
                                                    flexDirection = FlexDirection.COLUMN,
                                                    justifyContent = JustifyContent.CENTER,
                                                    alignItems = AlignItems.CENTER
                                            ),
                                            positionType = PositionType.RELATIVE,
                                            display = Display.FLEX)

                            ),
                            Container(
                                    children = listOf(
                                            Image(path = ImagePath.Remote(remoteUrl = "http://10.0.2.2/images/tapa_boca.png")).applyStyle(
                                                    Style(size = Size(width = 190.unitReal(), height = 190.unitReal()))
                                            ),
                                            Text(text = "Use máscara de proteção",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Title.ViewPager",
                                                    textColor = "#FFA500"),
                                            Text(text = "sempre que for sair de casa, para evitar o contágio.",
                                                    alignment = TextAlignment.CENTER, styleId = "Design.System.Text.ViewPager",
                                                    textColor = "#FFA500"),
                                            Button(styleId = "BaseFlatButton",
                                                    text = "Obrigado!",
                                                    onPress = listOf(
                                                            Navigate.PushStack(Route.Remote("/login")),
                                                            Navigate.PopView()
                                                    )

                                            ).applyStyle(
                                                    Style(
                                                            size = Size(width = 80.unitPercent(), height = 48.unitReal()),
                                                            margin = EdgeValue(top = 60.unitReal())
                                                    )
                                            )
                                    )
                            ).applyStyle(
                                    Style(backgroundColor = "#FFFFFF",
                                            size = Size(width = 100.unitPercent(), height = 100.unitPercent()),
                                            flex = Flex(
                                                    grow = 1.0,
                                                    flexDirection = FlexDirection.COLUMN,
                                                    justifyContent = JustifyContent.CENTER,
                                                    alignItems = AlignItems.CENTER
                                            ),
                                            positionType = PositionType.RELATIVE,
                                            display = Display.FLEX)

                            )

                    )
            ).apply {
                Style(
                        backgroundColor = "#00808080"
                )
            }
    )

}
