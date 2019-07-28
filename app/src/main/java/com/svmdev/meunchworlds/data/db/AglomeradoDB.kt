package com.svmdev.meunchworlds.data.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.data.model.AglomeradoM
import com.svmdev.meunchworlds.help.DBOpenHelper

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class AglomeradoDB{

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var aglomerados: ArrayList<AglomeradoM>
    private lateinit var aglomerado: AglomeradoM

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
    }

    //Listar Aglomerados
    fun listar(): ArrayList<AglomeradoM>{
        aglomerados = arrayListOf()
        cursor = db.query("aglomerado", arrayOf("id", "nome", "link"),
            null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()){
            aglomerado = AglomeradoM()
            aglomerado.id = cursor.getInt(0)
            aglomerado.nome = cursor.getString(1)
            aglomerado.link = cursor.getString(2)
            aglomerados.add(aglomerado)
            cursor.moveToNext()
        }
        cursor.close()
        return aglomerados
    }

    //Consulta por ID
    fun findById(id: Int):AglomeradoM{
        aglomerado = AglomeradoM()
        var selection = "id = $id"
        cursor = db.query("aglomerado", arrayOf("id", "nome","link"),
            selection,null, null, null, null)
        cursor.moveToFirst()
        if(cursor.count > 0){
            aglomerado.id = cursor.getInt(0)
            aglomerado.nome = cursor.getString(1)
            aglomerado.link = cursor.getString(2)
        }
        cursor.close()
        return aglomerado
    }

}