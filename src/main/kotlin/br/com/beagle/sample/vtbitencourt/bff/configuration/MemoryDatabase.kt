package br.com.beagle.sample.vtbitencourt.bff.configuration

import br.com.beagle.sample.vtbitencourt.bff.dtos.UserDTO
import br.com.beagle.sample.vtbitencourt.bff.dtos.VaccineDTO
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.util.*

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
class MemoryDatabase {

    val users : MutableList<UserDTO> = mutableListOf(UserDTO(
            id = UUID.randomUUID(),
            name = "teste",
            email = "teste",
            password = "teste"
    ))

    val vaccines : MutableList<VaccineDTO> = mutableListOf(
            VaccineDTO(
                    id = UUID.randomUUID(),
                    title = "Covid 19",
                    urlImage = "http://10.0.2.2/images/virus.png",
                    urlBanner = "http://10.0.2.2/images/img_covid19_banner.jpg",
                    description = "O coronavírus que apareceu pela primeira vez na China em 2019 é responsável pelo surgimento de uma infecção respiratória,",
                    Symptoms = "",
                    fullDescription ="A COVID-19 se transmite através de secreções respiratórias e saliva, sendo indicado ter alguns cuidados para evitar pegar a infecção e passá-la para outras pessoas, como cobrir a boca ao tossir ou espirrar, lavar as mãos regularmente e evitar tocar no rosto, principalmente na região dos olhos, nariz e boca."
            ),
            VaccineDTO(
                    id = UUID.randomUUID(),
                    title = "Catapora",
                    description = "A melhor forma de prevenção contra a catapora se dá pela vacinação e evitando o contato com pessoas que estão infectadas.",
                    urlImage = "http://10.0.2.2/images/vacina_catapora.png",
                    urlBanner = "http://10.0.2.2/images/img_catapora_banner.jpg",
                    Symptoms = "",
                    fullDescription ="A doença se torna um risco maior em adultos justamente por apresentarem um sistema imunológico completo. Dessa forma, quando infectado pelo vírus, o organismo produz uma resposta inflamatória mais grave ou mais intensa, o que resulta no surgimento de sintomas mais intensos e persistentes.\n" +
                            "\n" +
                            "A melhor forma de prevenção contra a catapora se dá pela vacinação e evitando o contato com pessoas que estão infectadas.\n" +
                            "\n" +
                            "Sendo assim, as principais características da infecção são a manifestação de erupções cutâneas, coceira, febre e cansaço. "
            ),
            VaccineDTO(
                    id = UUID.randomUUID(),
                    title = "Influenza",
                    description = "Infecção viral aguda do sistema respiratório, de elevada transmissibilidade e distribuição global. Um indivíduo pode contraí-la várias vezes ao longo da vida. Em geral, tem evolução autolimitada, podendo, contudo, apresentar-se de forma grave.",
                    urlImage = "http://10.0.2.2/images/vacina_influenza.png",
                    urlBanner = "http://10.0.2.2/images/img_influenza_banner.jpg",
                    Symptoms = "",
                    fullDescription ="Infecção viral aguda do sistema respiratório, de elevada transmissibilidade e distribuição global. Um indivíduo pode contraí-la várias vezes ao longo da vida. Em geral, tem evolução autolimitada, podendo, contudo, apresentar-se de forma grave." +
                            "Os vírus influenza são transmitidos facilmente por aerossóis produzidos por pessoas infectadas ao tossir ou espirrar. Existem 3 tipos de vírus influenza: A, B e C."
            ),
            VaccineDTO(
                    id = UUID.randomUUID(),
                    title = "Hepatite",
                    description = "A hepatite é a inflamação do fígado, que geralmente é causada por vírus e/ ou uso de medicamentos.",
                    urlImage = "http://10.0.2.2/images/vacina_hepatite.png",
                    urlBanner = "http://10.0.2.2/images/img_hepatite_banner.jpg",
                    Symptoms = "",
                    fullDescription ="A hepatite é a inflamação do fígado, que geralmente é causada por vírus e/ ou uso de medicamentos. Os sintomas da hepatite normalmente surgem poucos dias após o contato com o vírus e se manifestam através da cor amarelada na pele e na parte branca dos olhos e o seu tratamento depende do que originou a doença.\n" +
                            "\n" +
                            "Existem diversos tipos de hepatite, mas os mais comuns no Brasil são as hepatites A, B e C."

            ),
            VaccineDTO(
                    id = UUID.randomUUID(),
                    title = "Tetano",
                    description = "Tétano é uma doença grave causada pela infecção da bactéria Clostridium tetani, que entra no corpo através de feridas e produz uma toxina que age no sistema nervoso central, provocando",
                    urlImage = "http://10.0.2.2/images/vacina_tetano.png",
                    urlBanner = "http://10.0.2.2/images/img_tetano_banner.jpg",
                    Symptoms = "",
                    fullDescription ="Tétano é uma doença grave causada pela infecção da bactéria Clostridium tetani, que entra no corpo através de feridas e produz uma toxina que age no sistema nervoso central, provocando fortes contrações musculares que podem matar. É possível prevenir o tétano através de vacina." +
                            "É possível se imunizar contra o tétano através da vacina antitetânica. Como a bactéria pode ser encontrada em quase qualquer lugar, a vacina é a melhor defesa. A falta dela permite que a bactéria encontre o caminho para o corpo do hospedeiro.\n" +
                            "\n" +
                            "Uma vez na corrente sanguínea, em um ambiente sem oxigênio, a bactéria libera duas toxinas: A tetanolisina, cujo efeito na doença é desconhecido e incerto, e a tetanospasmina, que é uma neurotoxina que alcança o sistema nervoso central e o ataca. Essa toxina é o agente causador do tétano."
            )
    )


}