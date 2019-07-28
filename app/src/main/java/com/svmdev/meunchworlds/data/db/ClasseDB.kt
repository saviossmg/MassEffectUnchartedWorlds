package com.svmdev.meunchworlds.data.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.data.model.ClasseM
import com.svmdev.meunchworlds.help.DBOpenHelper

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class ClasseDB {

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var classes: ArrayList<ClasseM>
    private lateinit var classe: ClasseM

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
    }

    //Listar
    fun listar(novo: Boolean): ArrayList<ClasseM>{
        classes = arrayListOf()
        cursor = db.query("classe", arrayOf("id", "descricao"),
            null, null, null, null, null)
        cursor.moveToFirst()
        if(novo){
            classe = ClasseM()
            classe.id = 0
            classe.descricao = "Select the class"
            classes.add(classe)
        }
        while (!cursor.isAfterLast()){
            classe = ClasseM()
            classe.id = cursor.getInt(0)
            classe.descricao = cursor.getString(1)
            classes.add(classe)
            cursor.moveToNext()
        }
        cursor.close()
        return classes
    }

    //Consulta por ID
    fun findById(id: Int): ClasseM{
        classe = ClasseM()
        var selection = "id = $id"
        cursor = db.query("classe", arrayOf("id", "descricao"), selection,
            null, null, null, null)
        cursor.moveToFirst()
        classe.id = cursor.getInt(0)
        classe.descricao = cursor.getString(1)
        cursor.close()
        return classe
    }


}