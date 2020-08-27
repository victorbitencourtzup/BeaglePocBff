package br.com.beagle.sample.vtbitencourt.bff.services

import br.com.beagle.sample.vtbitencourt.bff.dtos.LoginDTO
import br.com.beagle.sample.vtbitencourt.bff.dtos.RegisterDTO
import br.com.zup.beagle.widget.action.*
import org.springframework.stereotype.Service

@Service
class LoginService {

    fun validadeLoginForm(loginDTO: LoginDTO): Boolean {


        return false
    }

    fun validadeUserRegisterForm(registerDTO: RegisterDTO): Boolean {


        return false
    }

    fun createAction(): Action = Alert(
            title = "My Dialog",
            message = "This is a native popup!",
            labelOk = "Close"
    )


}