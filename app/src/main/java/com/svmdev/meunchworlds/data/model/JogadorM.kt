package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class JogadorM {

    var id: Int
    var nome: String
    var genero: String
    var totalSistemas: Int
    var totalAglomerados: Int
    var totalRecursos: Int
    var classe: ClasseM

    constructor(){
        this.id = 0
        this.nome = ""
        this.genero = "U"
        this.totalSistemas = 0
        this.totalAglomerados = 0
        this.totalRecursos = 0
        this.classe = ClasseM()
    }

    override fun toString(): String {
        var str = "${this.nome}"
        if(this.id != 0)
            str += " - ${classe.descricao} ($genero)"
        return str
    }

}