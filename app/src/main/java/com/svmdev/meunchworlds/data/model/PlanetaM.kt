package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class PlanetaM{

    var id:Int
    var nome:String
    var exploravel:Boolean
    var pos:Int
    var sistema:Int
    var link:String

    constructor(){
        this.id = 0
        this.nome = ""
        this.exploravel = false
        this.pos = 0
        this.sistema = 0
        this.link = ""
    }

}