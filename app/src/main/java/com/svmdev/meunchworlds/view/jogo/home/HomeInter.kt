package com.svmdev.meunchworlds.view.jogo.home

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatTextView

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 07/02/2019.
 */
interface HomeInter {

    fun context(): Context
    fun fragment(): Fragment
    fun nomeperso(): AppCompatTextView
    fun classeperso(): AppCompatTextView
    fun sexoperso(): AppCompatTextView
    fun progressperso(): AppCompatTextView
    fun totalclusters(): AppCompatTextView
    fun totalsistemas(): AppCompatTextView
    fun totalplanetas(): AppCompatTextView
    fun totalrecursos(): AppCompatTextView
    fun totalmineral(): AppCompatTextView
    fun btnsair(): AppCompatButton
    fun btndeletar(): AppCompatButton

}