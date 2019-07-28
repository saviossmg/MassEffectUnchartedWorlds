package com.svmdev.meunchworlds.data.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.svmdev.meunchworlds.help.DBOpenHelper
import android.content.ContentValues
import com.svmdev.meunchworlds.data.model.*
import com.svmdev.meunchworlds.help.DBAcess

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class JogadorDB{

    //SQLite
    private var db: SQLiteDatabase
    private var helper: DBOpenHelper
    private lateinit var cursor: Cursor

    //Variaveis
    private lateinit var jogadores: ArrayList<JogadorM>
    private lateinit var jogador: JogadorM
    private val classe: ClasseDB

    constructor(context: Context){
        this.helper = DBOpenHelper(context)
        this.db = helper.getDatabase()
        this.classe = ClasseDB(context)
    }

    //Listar Jogadores
    fun listar(show: Boolean = false): ArrayList<JogadorM>{
        jogadores = arrayListOf()
        cursor = db.query("jogador", arrayOf("id", "nome","totalAglomerados","totalSistemas","totalRecursos","classe","genero"),
            null, null, null, null, null)
        cursor.moveToFirst()
        if(show){
            jogador = JogadorM()
            jogador.nome = "Select your player"
            jogador.classe.descricao = "(Do you understand ?)"
            jogadores.add(jogador)
        }
        while (!cursor.isAfterLast()){
            jogador = JogadorM()
            jogador.id = cursor.getInt(0)
            jogador.nome = cursor.getString(1)
            jogador.totalAglomerados = cursor.getInt(2)
            jogador.totalSistemas = cursor.getInt(3)
            jogador.totalRecursos = cursor.getInt(4)
            jogador.classe = classe.findById(cursor.getInt(5))
            jogador.genero = cursor.getString(6)
            jogadores.add(jogador)
            cursor.moveToNext()
        }
        cursor.close()
        return jogadores
    }

    //Cadastar Jogador
    fun inserir(dados: JogadorM) {
        val cv = ContentValues()
        cv.put("nome", dados.nome)
        cv.put("genero", dados.genero)
        cv.put("totalAglomerados", dados.totalAglomerados)
        cv.put("totalSistemas", dados.totalSistemas)
        cv.put("totalRecursos", dados.totalRecursos)
        cv.put("classe", dados.classe.id)
        db.insert("jogador", null, cv)
    }

    //Consulta por ID
    fun findById(id: Int = 0,ultimo: Boolean = false):JogadorM{
        jogador = JogadorM()

        var selection = ""
        var orderBy = ""

        if(id != 0)
            selection = "id = $id"

        if(ultimo)
            orderBy = "id DESC LIMIT 1"

        cursor = db.query("jogador", arrayOf("id","nome","genero","totalAglomerados","totalSistemas","totalRecursos","classe"),
            selection,null, null, null, orderBy)
        cursor.moveToFirst()
        if(cursor.count > 0){
            jogador.id = cursor.getInt(0)
            jogador.nome = cursor.getString(1)
            jogador.genero = cursor.getString(2)
            jogador.totalAglomerados = cursor.getInt(3)
            jogador.totalSistemas = cursor.getInt(4)
            jogador.totalRecursos = cursor.getInt(5)
            jogador.classe = classe.findById(cursor.getInt(6))
        }

        cursor.close()
        return jogador
    }

    fun inserirDadosJogador(id: Int){
        //1 - aglomerado
        val aglos = DBAcess.aglomeradoAcess.listar()
        for (it: AglomeradoM in aglos)
            DBAcess.dataJogAcess.inserirAglo(id,it.id)
        //2 - sistema
        val sists = DBAcess.sistemaAcess.listar()
        for (it: SistemaM in sists)
            DBAcess.dataJogAcess.inserirSist(id,it.id)
        //3 - planeta
        val plans = DBAcess.planetaAcess.listar()
        for (it: PlanetaM in plans)
            DBAcess.dataJogAcess.inserirPlan(id,it.id)
        //4 - recursos
        val recs = DBAcess.recursoAcess.listar()
        for (it: RecursoM in recs)
            DBAcess.dataJogAcess.inserirRec(id,it.id)
    }

}