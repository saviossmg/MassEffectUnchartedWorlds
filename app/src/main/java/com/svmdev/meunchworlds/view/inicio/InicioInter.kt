package com.svmdev.meunchworlds.view.inicio

import android.app.Activity
import android.content.Context
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatSpinner
import android.widget.ProgressBar

/**
 * Mass Effect Uncharted Worldsw
 * Desenvolvido por Sávio Martins Valentim em 15/01/2019.
 */
interface InicioInter {

    fun context(): Context
    fun activity(): Activity
    fun imgPerso(): AppCompatImageView
    fun selectPersonagem(): AppCompatSpinner
    fun progresso(): ProgressBar
    fun btnEntrar(): AppCompatButton
    fun btnCriar(): AppCompatButton
    fun btnSobre(): AppCompatButton


}