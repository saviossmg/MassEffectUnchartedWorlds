package com.svmdev.meunchworlds.data.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.data.model.SistemaM
import com.svmdev.meunchworlds.help.DBAcess
import com.svmdev.meunchworlds.help.DBOpenHelper

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class SistemaDB {

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var sistemas: ArrayList<SistemaM>
    private lateinit var sistema: SistemaM

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
    }

    //Listar Sistemas
    fun listar(): ArrayList<SistemaM>{
        sistemas = arrayListOf()
        cursor = db.query("sistema", arrayOf("id", "nome", "aglomerado","link"),
            null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()){
            sistema = SistemaM()
            sistema.id = cursor.getInt(0)
            sistema.nome= cursor.getString(1)
            sistema.aglomerado = cursor.getInt(2)
            sistema.link = cursor.getString(3)
            sistemas.add(sistema)
            cursor.moveToNext()
        }
        cursor.close()
        return sistemas
    }

    //Consulta por ID
    fun findById(id: Int):SistemaM{
        sistema = SistemaM()
        var selection = "id = $id"
        cursor = db.query("sistema", arrayOf("id", "nome","aglomerado","link"),
            selection,null, null, null, null)
        cursor.moveToFirst()
        if(cursor.count > 0){
            sistema.id = cursor.getInt(0)
            sistema.nome = cursor.getString(1)
            sistema.aglomerado = cursor.getInt(2)
            sistema.link = cursor.getString(3)
        }
        cursor.close()
        return sistema
    }

}