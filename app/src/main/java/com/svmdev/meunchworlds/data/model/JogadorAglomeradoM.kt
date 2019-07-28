package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class JogadorAglomeradoM{

    var id:Int
    var jogador:Int
    var aglomerado:AglomeradoM
    var visitado:Boolean

    constructor() {
        this.id = 0
        this.jogador = 0
        this.aglomerado = AglomeradoM()
        this.visitado = false
    }

}