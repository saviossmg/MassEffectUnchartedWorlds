package com.svmdev.meunchworlds.view.jogo.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.svmdev.meunchworlds.R

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 07/02/2019.
 */
class HomeFragment: Fragment(), HomeInter, View.OnClickListener {

    private lateinit var nomePerso: AppCompatTextView
    private lateinit var classePerso: AppCompatTextView
    private lateinit var sexoPerso: AppCompatTextView
    private lateinit var progresPerso: AppCompatTextView

    private lateinit var totalClusters: AppCompatTextView
    private lateinit var totalSistemas: AppCompatTextView
    private lateinit var totalPlanetas: AppCompatTextView
    private lateinit var totalRecursos: AppCompatTextView
    private lateinit var totalMineral: AppCompatTextView

    private lateinit var btnDeletar: AppCompatButton
    private lateinit var btnSair: AppCompatButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        nomePerso = view.findViewById(R.id.home_txt_nome)
        classePerso = view.findViewById(R.id.home_txt_classe)
        sexoPerso = view.findViewById(R.id.home_txt_genero)
        progresPerso = view.findViewById(R.id.home_txt_progresso)

        totalClusters = view.findViewById(R.id.home_txt_totalclusters)
        totalSistemas = view.findViewById(R.id.home_txt_totalsistemas)
        totalPlanetas = view.findViewById(R.id.home_txt_totalplanets)
        totalRecursos = view.findViewById(R.id.home_txt_totalrecursos)
        totalMineral = view.findViewById(R.id.home_txt_totalmineral)

        btnDeletar = view.findViewById(R.id.home_btn_deletar)
        btnSair = view.findViewById(R.id.home_btn_sair)

        btnDeletar.setOnClickListener { this }
        btnSair.setOnClickListener { this }

        return view
    }

    override fun onPause() {
        super.onPause()
        println("PAUSOU")
    }

    override fun onResume() {
        super.onResume()
        println("RESUMIU")
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.home_btn_deletar -> {  }
            R.id.home_btn_sair -> {  }
        }

    }


    override fun context(): Context { return this.context() }

    override fun fragment(): Fragment { return this }

    override fun nomeperso(): AppCompatTextView { return this.nomePerso }

    override fun classeperso(): AppCompatTextView { return this.classePerso }

    override fun sexoperso(): AppCompatTextView { return this.sexoPerso }

    override fun progressperso(): AppCompatTextView { return this.progresPerso }

    override fun totalclusters(): AppCompatTextView { return this.totalClusters }

    override fun totalsistemas(): AppCompatTextView { return this.totalSistemas }

    override fun totalplanetas(): AppCompatTextView { return this.totalPlanetas }

    override fun totalrecursos(): AppCompatTextView { return this.totalRecursos }

    override fun totalmineral(): AppCompatTextView { return this.totalMineral }

    override fun btnsair(): AppCompatButton { return this.btnSair }

    override fun btndeletar(): AppCompatButton { return this.btnDeletar }

 }