package com.svmdev.meunchworlds

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.svmdev.meunchworlds.help.DBAcess
import com.svmdev.meunchworlds.help.iniciarActivityFinalizando
import com.svmdev.meunchworlds.view.inicio.InicioActivity

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 15/01/2019.
 */
class LaunchScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)
        DBAcess.initAcess(this)
        iniciarActivityFinalizando(this,InicioActivity::class.java)
    }
}
