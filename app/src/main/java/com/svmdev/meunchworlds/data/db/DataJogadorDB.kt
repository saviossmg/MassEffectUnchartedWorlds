package com.svmdev.meunchworlds.data.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.data.model.*
import com.svmdev.meunchworlds.help.DBOpenHelper

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class DataJogadorDB {

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var aglos: ArrayList<JogadorAglomeradoM>
    private lateinit var sists: ArrayList<JogadorSistemaM>
    private lateinit var plans: ArrayList<JogadorPlanetaM>
    private lateinit var recs: ArrayList<JogadorRecursoM>
    private lateinit var aglo: JogadorAglomeradoM
    private lateinit var sist: JogadorSistemaM
    private lateinit var plan: JogadorPlanetaM
    private lateinit var rec: JogadorRecursoM

    private val classe: ClasseDB

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
        this.classe = ClasseDB(context)
    }

    fun inserirAglo(idJog:Int,idAglo:Int){
        val cv = ContentValues()
        cv.put("jogador", idJog)
        cv.put("aglomerado", idAglo)
        cv.put("visitado", false)
        db.insert("jogadoraglomerado", null, cv)
    }

    fun inserirSist(idJog:Int,idSis:Int){
        val cv = ContentValues()
        cv.put("jogador", idJog)
        cv.put("sistema", idSis)
        cv.put("visitado", false)
        db.insert("jogadorsistema", null, cv)
    }

    fun inserirPlan(idJog:Int,idPlan:Int){
        val cv = ContentValues()
        cv.put("jogador", idJog)
        cv.put("planeta", idPlan)
        cv.put("visitado", false)
        db.insert("jogadorplaneta", null, cv)
    }

    fun inserirRec(idJog: Int,idRec: Int){
        val cv = ContentValues()
        cv.put("jogador", idJog)
        cv.put("recursos", idRec)
        cv.put("visitado", false)
        db.insert("jogadorrecurso", null, cv)
    }

}