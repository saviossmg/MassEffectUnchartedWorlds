package com.svmdev.meunchworlds.help

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteException
import java.io.FileOutputStream
import java.io.IOException


class DBOpenHelper : SQLiteOpenHelper {

    /**
     * Este é o endereço onde o android salva os bancos de dados criado pela aplicação,
     * /data/data/<namespace da aplicacao>/databases/</namespace>
     * */
    private val DBPATH = "/data/data/com.svmdev.meunchworlds/databases/"

    // Este é o nome do banco de dados que iremos utilizar
    private val DBNAME = "MEUncharted.db"

    private var context: Context

    /**
     * O construtor necessita do contexto da aplicação
     */
    constructor(context: Context) : super(context,"MEUncharted.db",null,1) {
        /*
            1º argumento é o contexto da aplicacao.
            2º argumento é o nome do banco de dados.
            3º argumento é um pondeiro para manipulação de dados, não precisaremos dele.
            4º argumento é a versão do banco de dados.
        */
        this.context = context
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // Estamos utilizando o banco do assets, por isso o código antigo deste método não é mais necessário.
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Estamos criando a primeira versão do nosso banco de dados, então não precisamos fazer nenhuma alteração neste método.
    }

    /**
     * Método auxiliar que verifica a existencia do banco
     * da aplicação.
     */
    private fun checkDataBase(): Boolean {
        var db: SQLiteDatabase? = null
        try {
            val path = DBPATH + DBNAME
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY)
            db!!.close()
        } catch (e: SQLiteException) {
            // O banco não existe
        }

        // Retorna verdadeiro se o banco existir, pois o ponteiro ira existir, se não houver referencia é porque o banco não existe
        return db != null
    }

    private fun createDataBase() {
        // Primeiro temos que verificar se o banco da aplicação
        // já foi criado
        val exists = checkDataBase()

        if (!exists) {
            // Chamaremos esse método para que o android crie um banco vazio e o diretório onde iremos copiar no banco que está no assets.
            this.readableDatabase

            // Se o banco de dados não existir iremos copiar o nosso arquivo em /assets para o local onde o android os salva
            try {
                copyDatabase()
            } catch (e: IOException) {
                throw Error("Não foi possível copiar o arquivo")
            }
        }
    }

    /**
     * Esse método é responsavel por copiar o banco do diretório
     * assets para o diretório padrão do android.
     */
    private fun copyDatabase() {

        val dbPath = DBPATH + DBNAME

        // Abre o arquivo o destino para copiar o banco de dados
        val dbStream = FileOutputStream(dbPath)

        // Abre Stream do nosso arquivo que esta no assets
        val dbInputStream = context.assets.open(DBNAME)

        val buffer = ByteArray(1024)
        var length: Int
        var continua = true
        while (continua) {
            length = dbInputStream.read(buffer)
            if(length > 0)
                dbStream.write(buffer, 0, length)
            else
                continua = false
        }
        dbInputStream.close()
        dbStream.flush()
        dbStream.close()
    }

    fun getDatabase(): SQLiteDatabase {
        try {
            // Verificando se o banco já foi criado e se não foi o
            // mesmo é criado.
            createDataBase()
            // Abrindo database
            val path = DBPATH + DBNAME
            return SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE)
        } catch (e: Exception) {
            // Se não conseguir copiar o banco um novo será retornado
            return writableDatabase
        }
    }

}