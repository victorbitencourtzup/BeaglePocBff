package br.com.beagle.sample.vtbitencourt.bff.screen_builders

import br.com.zup.beagle.core.ServerDrivenComponent
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.*

import org.springframework.stereotype.Service


@Service
class BeagleSampleScreenBuilder {

    fun createScreen(): ServerDrivenComponent = createImplicitContext();

    fun createSimpleContext(): Container = Container(
            children = listOf(
                    Text("@{myText}")
            ),
            context = ContextData(
                    id = "myText",
                    value = "Hello Beagle"
            )
    ).applyStyle(
            Style(
                    flex = Flex(
                            grow = 1.0,
                            flexDirection = FlexDirection.COLUMN,
                            justifyContent = JustifyContent.CENTER,
                            alignItems = AlignItems.CENTER
                    )
            )
    )

    fun createMultiValueContext(): Container = Container(
            context = ContextData(
                    id = "userSampleDTO",
                    value = UserSampleDTO(username = "victor.bitencourt", name = "Victor", password = "teste")
            ),
            children = listOf(
                    Text("@{userSampleDTO.name}  @{userSampleDTO.username}"),
                    Text("@{userSampleDTO.username}")
            )
    ).applyStyle(
            Style(
                    flex = Flex(
                            grow = 1.0,
                            flexDirection = FlexDirection.COLUMN,
                            justifyContent = JustifyContent.CENTER,
                            alignItems = AlignItems.CENTER
                    )
            )
    )

    fun createCustomComponent(): Container = Container(
            context = ContextData(
                    id = "userSampleDTO",
                    value = UserSampleDTO(username = "victor.bitencourt", name = "Victor", password = "teste")
            ),
            children = listOf(

            )
    ).applyStyle(
            Style(
                    flex = Flex(
                            grow = 1.0,
                            flexDirection = FlexDirection.COLUMN,
                            justifyContent = JustifyContent.CENTER,
                            alignItems = AlignItems.CENTER
                    )
            )
    )

    fun createImplicitContext(): Container = Container(
            context = ContextData(
                    id = "userSampleDTO",
                    value = UserSampleDTO(username = "victor.bitencourt", name = "Victor", password = "teste")
            ),
            children = listOf(
                    TextInput(
                            styleId = "InputRoudedWhite",
                            placeholder = "qualquer texto",
                            value = "@{userSampleDTO.username}",
                            onChange = listOf(
                                    SetContext(
                                            contextId = "userSampleDTO",
                                            path = "username",
                                            value = "@{onChange.value}"
                                    )
                            )
                    ).applyStyle(
                            Style(
                                    size = Size(width = 80.unitPercent(), height = 48.unitReal()),
                                    margin = EdgeValue(top = 20.unitReal())
                            )
                    ),
                    Text("@{userSampleDTO.name}"),
                    Text("@{userSampleDTO.username}")
            )
    ).applyStyle(
            Style(
                    flex = Flex(
                            grow = 1.0,
                            flexDirection = FlexDirection.COLUMN,
                            justifyContent = JustifyContent.CENTER,
                            alignItems = AlignItems.CENTER
                    )
            )
    )

    fun createFormSubmit(): Container = Container(
            children = listOf(
            ScrollView(
                    scrollDirection = ScrollAxis.VERTICAL,
                    children = listOf(
                            TextInput(value = "", placeholder = "@{myContext.value}", type = TextInputType.PASSWORD),
                            Button(text = "submit form",
                                    onPress = listOf(

                                    ))
                    )
            ))
    )

}

data class UserSampleDTO(var username: String, var password: String, var name: String)