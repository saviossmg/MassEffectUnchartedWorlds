package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class JogadorSistemaM{

    var id:Int
    var jogador:Int
    var sistema:SistemaM
    var visitado:Boolean

    constructor() {
        this.id = 0
        this.jogador = 0
        this.sistema = SistemaM()
        this.visitado = false
    }
}