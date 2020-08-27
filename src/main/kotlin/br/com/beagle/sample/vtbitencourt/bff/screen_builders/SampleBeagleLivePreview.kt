package br.com.beagle.sample.vtbitencourt.bff.screen_builders

import br.com.beagle.sample.vtbitencourt.bff.custom.actions.CustomNavigateRemoteAction
import br.com.beagle.sample.vtbitencourt.bff.dtos.LoginDTO
import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.core.Display
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.action.*
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.form.Form
import br.com.zup.beagle.widget.form.FormInput
import br.com.zup.beagle.widget.form.FormSubmit
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.navigation.Touchable
import br.com.zup.beagle.widget.ui.*


@BeaglePreview
fun buildPreview() = SampleBeagleLivePreview()


class SampleBeagleLivePreview : ScreenBuilder {

    override fun build(): Screen {

        return Screen(
                child = Form(
                        onSubmit = listOf(
                                SendRequest(
                                        url = "http://10.0.2.2:8080/login/",
                                        method = RequestActionMethod.POST,
                                        data = LoginDTO(
                                                email = "@{credentials.email}",
                                                password = "@{credentials.password}"
                                        ),
                                        onSuccess = listOf(
                                                CustomNavigateRemoteAction(url = expressionOf( "/home/@{onSuccess.data.data}")), // custom action implemented in android native app
                                                Navigate.PopView()

                                        ),
                                        onError = listOf(
                                                Alert(
                                                        title = "Atenção!",
                                                        message = "@{onError.data.error}",
                                                        labelOk = "OK"
                                                )
                                        )
                                )
                        ),
                        child = Container(
                                context = ContextData(
                                        id = "credentials",
                                        value = LoginDTO(email = "", password = "")
                                ),
                                children = listOf(
                                        Image(path = ImagePath.Remote(remoteUrl = "http://10.0.2.2/images/health360.png")).applyStyle(
                                                Style(size = Size(width = 190.unitReal(), height = 190.unitReal()))
                                        ),
                                        FormInput(
                                                name = "email",
                                                validator = "TextNotEmptyValidator", // custom validator created in native android app to check if the values from input is null or empty
                                                required = true,
                                                errorMessage = "Campo email é obrigatório",
                                                child = TextInput(styleId = "InputRounded", // custom style registered in android native app
                                                        placeholder = "Email",
                                                        value = "@{credentials.email}",
                                                        type = TextInputType.EMAIL,
                                                        onChange = listOf(
                                                                SetContext(
                                                                        contextId = "credentials",
                                                                        path = "email",
                                                                        value = "@{onChange.value}"
                                                                )
                                                        )
                                                ).applyStyle(
                                                        Style(
                                                                size = Size(width = 80.unitPercent(), height = 48.unitReal()),
                                                                margin = EdgeValue(top = 20.unitReal())
                                                        )
                                                )
                                        ),
                                        FormInput(
                                                name = "password",
                                                validator = "TextNotEmptyValidator", // custom validator created in native android app to check if the values from input is null or empty
                                                required = true,
                                                errorMessage = "Campo senha é obrigatório",
                                                child = TextInput(styleId = "InputRounded", // custom style registered in android native app
                                                        placeholder = "Senha",
                                                        type = TextInputType.PASSWORD,
                                                        value = "@{credentials.password}",
                                                        onChange = listOf(
                                                                SetContext(
                                                                        contextId = "credentials",
                                                                        path = "password",
                                                                        value = "@{onChange.value}"
                                                                )
                                                        )
                                                ).applyStyle(
                                                        Style(
                                                                size = Size(width = 80.unitPercent(), height = 48.unitReal()),
                                                                margin = EdgeValue(top = 10.unitReal())
                                                        )
                                                )
                                        ),
                                        FormSubmit(
                                                child = Button(styleId = "BaseFlatButton", // custom style registered in android native app
                                                        text = "ENTRAR"
                                                ).applyStyle(
                                                        Style(
                                                                size = Size(width = 80.unitPercent(), height = 48.unitReal()),
                                                                margin = EdgeValue(top = 20.unitReal())
                                                        )
                                                )
                                        ),
                                        Touchable(onPress = listOf(Navigate.PushStack(Route.Remote("/login/register"))),
                                                child = Text(text = "Ainda não é cadastrado? Clique aqui.").applyStyle(
                                                        Style(margin = EdgeValue(top = 5.unitReal()))
                                                )
                                        )

                                )).applyStyle(
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
        )


    }

}