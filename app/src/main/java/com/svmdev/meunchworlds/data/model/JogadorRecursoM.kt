package com.svmdev.meunchworlds.data.model

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class JogadorRecursoM{

    var id:Int
    var jogador:Int
    var recurso:RecursoM
    var visitado:Boolean

    constructor() {
        this.id = 0
        this.jogador = 0
        this.recurso = RecursoM()
        this.visitado = false
    }
}