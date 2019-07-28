package com.svmdev.meunchworlds.help

import android.content.Context
import com.svmdev.meunchworlds.data.db.*

class DBAcess {

    companion object {
        lateinit var jogadorAcess: JogadorDB
        lateinit var classeAcess: ClasseDB
        lateinit var aglomeradoAcess: AglomeradoDB
        lateinit var sistemaAcess: SistemaDB
        lateinit var planetaAcess: PlanetaDB
        lateinit var recursoAcess: RecursoDB
        lateinit var dataJogAcess: DataJogadorDB

        fun initAcess(context: Context){
            this.jogadorAcess = JogadorDB(context)
            this.classeAcess = ClasseDB(context)
            this.aglomeradoAcess = AglomeradoDB(context)
            this.sistemaAcess = SistemaDB(context)
            this.planetaAcess = PlanetaDB(context)
            this.recursoAcess = RecursoDB(context)
            this.dataJogAcess = DataJogadorDB(context)
        }

    }

}