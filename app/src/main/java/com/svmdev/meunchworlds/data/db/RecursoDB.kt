package com.svmdev.meunchworlds.data.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.data.model.JogadorM
import com.svmdev.meunchworlds.data.model.RecursoM
import com.svmdev.meunchworlds.help.DBOpenHelper

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class RecursoDB {

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var recursos: ArrayList<RecursoM>
    private lateinit var recurso: RecursoM

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
    }

    //Listar Recursos
    fun listar(): ArrayList<RecursoM>{
        recursos = arrayListOf()
        cursor = db.query("recurso", arrayOf("id", "numident", "descricao","mineral","aparicao","valor","planeta"),
            null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()){
            recurso = RecursoM()
            recurso.id
            recurso.numident
            recurso.descricao
            recurso.mineral
            recurso.aparicao
            recurso.valor
            recurso.planeta

            /*

            jogador.id = cursor.getInt(0)
            jogador.nome = cursor.getString(1)
            jogador.totalAglomerados = cursor.getInt(2)
            jogador.totalSistemas = cursor.getInt(3)
            jogador.totalRecursos = cursor.getInt(4)
            jogador.classe = classe.findById(cursor.getInt(5))
            jogadores.add(jogador)
            */
            cursor.moveToNext()
        }
        cursor.close()
        return recursos
    }

}