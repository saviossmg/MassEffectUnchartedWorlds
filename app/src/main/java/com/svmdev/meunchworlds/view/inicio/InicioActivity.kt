package com.svmdev.meunchworlds.view.inicio

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatSpinner
import android.view.View
import android.widget.ProgressBar
import com.svmdev.meunchworlds.R

/**
 * Mass Effect Uncharted Worldsw
 * Desenvolvido por Sávio Martins Valentim em 15/01/2019.
 */
class InicioActivity : AppCompatActivity(), InicioInter, View.OnClickListener {

    private lateinit var imgPerson: AppCompatImageView
    private lateinit var selectPersonagem: AppCompatSpinner
    private lateinit var btnEntrar: AppCompatButton
    private lateinit var btnCriar: AppCompatButton
    private lateinit var btnSobre: AppCompatButton
    private lateinit var progresso: ProgressBar

    private lateinit var mPrsenter: InicioPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        imgPerson = findViewById(R.id.inicio_img_perfil)
        selectPersonagem = findViewById(R.id.inicio_selectperso)
        progresso = findViewById(R.id.inicio_progresso)
        btnEntrar = findViewById(R.id.inicio_btn_entrar)
        btnCriar = findViewById(R.id.inicio_btn_criar)
        btnSobre = findViewById(R.id.inicio_btn_sobre)

        mPrsenter = InicioPresenter(this)

        btnEntrar.setOnClickListener(this)
        btnCriar.setOnClickListener(this)
        btnSobre.setOnClickListener(this)

        mPrsenter.carregaJogadores()

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.inicio_btn_entrar -> { mPrsenter.iniciarActivity(1) }
            R.id.inicio_btn_criar -> { mPrsenter.iniciarActivity(2) }
            R.id.inicio_btn_sobre -> { mPrsenter.iniciarActivity(3)}
        }
    }

    override fun onResume() {
        super.onResume()
        mPrsenter.isLoading(true)
        //Recarrega o adapter dos players
        mPrsenter.carregaJogadores()
    }

    override fun context(): Context { return this }

    override fun activity(): Activity { return this }

    override fun imgPerso(): AppCompatImageView { return this.imgPerson }

    override fun selectPersonagem(): AppCompatSpinner { return this.selectPersonagem }

    override fun progresso(): ProgressBar { return this.progresso }

    override fun btnEntrar(): AppCompatButton { return this.btnEntrar }

    override fun btnCriar(): AppCompatButton { return this.btnCriar }

    override fun btnSobre(): AppCompatButton { return this.btnSobre }

}
