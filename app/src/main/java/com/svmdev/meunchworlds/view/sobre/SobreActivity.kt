package com.svmdev.meunchworlds.view.sobre

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.*
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.svmdev.meunchworlds.R
import com.svmdev.meunchworlds.help.construirToolbar
import com.svmdev.meunchworlds.help.iniciarNavegador

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 05/02/2019.
 */
class SobreActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var toolbarUi: Toolbar

    private lateinit var btnWikia: Button
    private lateinit var btnGsp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        toolbarUi = findViewById(R.id.sobre_toolbar)
        btnWikia = findViewById(R.id.sobre_btn_linkwikia)
        btnGsp = findViewById(R.id.sobre_btn_linkgamepress)

        construirToolbar(this,toolbarUi,this.getString(R.string.sobre_toolbar))

        btnWikia.setOnClickListener(this)
        btnGsp.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.sobre_btn_linkgamepress -> { iniciarNavegador(this,"https://guides.gamepressure.com/masseffect/") }
            R.id.sobre_btn_linkwikia-> { iniciarNavegador(this,"https://masseffect.fandom.com/wiki/Mass_Effect_Guide") }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
