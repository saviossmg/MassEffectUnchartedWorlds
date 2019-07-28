package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class RecursoM{

    var id:Int
    var numident:Int
    var descricao:String
    var mineral:Boolean
    var aparicao:String
    var valor:String
    var planeta:PlanetaM

    constructor() {
        this.id = 0
        this.numident = 0
        this.descricao = ""
        this.mineral = false
        this.aparicao = ""
        this.valor = ""
        this.planeta = PlanetaM()
    }

}