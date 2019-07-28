package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class JogadorPlanetaM{

    var id:Int
    var jogador:Int
    var planeta:PlanetaM
    var visitado:Boolean

    constructor() {
        this.id = 0
        this.jogador = 0
        this.planeta = PlanetaM()
        this.visitado = false
    }

}