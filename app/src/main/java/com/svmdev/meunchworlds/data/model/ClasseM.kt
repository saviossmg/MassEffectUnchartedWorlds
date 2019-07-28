package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class ClasseM {

    var id:Int
    var descricao: String

    constructor(){
        this.id = 0
        this.descricao = ""
    }

    override fun toString(): String {
        return this.descricao
    }

}