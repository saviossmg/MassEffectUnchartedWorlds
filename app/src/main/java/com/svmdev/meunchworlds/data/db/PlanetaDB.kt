package com.svmdev.meunchworlds.data.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.data.model.PlanetaM
import com.svmdev.meunchworlds.help.DBOpenHelper

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class PlanetaDB {

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var planetas: ArrayList<PlanetaM>
    private lateinit var planeta: PlanetaM

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
    }

    //Listar Planetas
    fun listar(): ArrayList<PlanetaM>{
        planetas = arrayListOf()
        cursor = db.query("planeta", arrayOf("id","nome","exploravel","pos","sistema","link"),
            null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()){
            planeta = PlanetaM()
            planeta.id = cursor.getInt(0)
            planeta.nome= cursor.getString(1)
            planeta.exploravel= Boolean.equals(cursor.getInt(2))
            planeta.pos = cursor.getInt(3)
            planeta.sistema = cursor.getInt(4)
            planetas.add(planeta)
            cursor.moveToNext()
        }
        cursor.close()
        return planetas
    }

}