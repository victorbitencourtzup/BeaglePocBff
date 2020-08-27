package br.com.beagle.sample.vtbitencourt.bff.controllers

import br.com.beagle.sample.vtbitencourt.bff.configuration.MemoryDatabase
import br.com.beagle.sample.vtbitencourt.bff.dtos.LoginDTO
import br.com.beagle.sample.vtbitencourt.bff.dtos.ResponseDTO
import br.com.beagle.sample.vtbitencourt.bff.dtos.RegisterDTO
import br.com.beagle.sample.vtbitencourt.bff.dtos.UserDTO
import br.com.beagle.sample.vtbitencourt.bff.screen_builders.LoginScreenBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.Exception
import java.util.*

@RestController
class LoginController(val loginScreenBuilder: LoginScreenBuilder,
                      val storage: MemoryDatabase) {

    @GetMapping("login")
    fun getScreen() = loginScreenBuilder.createLoginScreen()

    @PostMapping("login")
    fun login(@RequestBody loginDTO: LoginDTO): ResponseEntity<ResponseDTO<UUID>> {
        try {

            if (storage.users.isNotEmpty()) {
                var user = storage.users[storage.users.indexOfFirst { l -> l.email.equals(loginDTO.email) }]
                user?.let {
                    if (it.password.equals(loginDTO.password)) {

                        return ResponseEntity
                                .status(HttpStatus.OK)
                                .body(ResponseDTO(
                                        isSuccess = true,
                                        data = it.id
                                ))
                    } else {

                        return ResponseEntity
                                .status(HttpStatus.BAD_REQUEST)
                                .body(ResponseDTO(
                                        isSuccess = false,
                                        error = "Usuário e/ou senha inválidos"
                                ))
                    }

                }

            }

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDTO(
                            isSuccess = false,
                            error = "Não encontramos o usuário informado."
                    ))

        } catch (e: Exception) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDTO(
                            isSuccess = false,
                            error = "Houve um problema inesperado, por favor tente novamente mais tarde."
                    ))
        }

    }

    @GetMapping("login/register")
    fun getRegisterScreen() = loginScreenBuilder.createRegisterScreen()

    @PostMapping("login/register")
    fun registerUser(@RequestBody registerDTO: RegisterDTO): ResponseEntity<ResponseDTO<String>> {

        try {

            if (registerDTO.password.isNullOrBlank() && registerDTO.name.isNullOrBlank() && registerDTO.email.isNullOrBlank()) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ResponseDTO(
                                isSuccess = false,
                                error = "Por favor, verifique os seus dados antes de enviar."
                        ))
            }

            if (storage.users.isEmpty() || storage.users[storage.users.indexOfFirst { l -> l.email.equals(registerDTO.email) }] == null) {

                storage.users.add(UserDTO(
                        id = UUID.randomUUID(),
                        name = registerDTO.name,
                        password = registerDTO.password,
                        email = registerDTO.email
                ))

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(ResponseDTO(
                                isSuccess = true,
                                data = "Usuário foi criado com sucesso"
                        ))

            } else {

                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ResponseDTO(
                                isSuccess = false,
                                error = "Usuário já existe, por favor utilize outro."
                        ))

            }

        } catch (e: Exception) {

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ResponseDTO(
                            isSuccess = false,
                            error = "Houve um problema inesperado, por favor tente novamente mais tarde."
                    ))
        }
    }
}