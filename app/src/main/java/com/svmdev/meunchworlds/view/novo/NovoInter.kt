package com.svmdev.meunchworlds.view.novo

import android.app.Activity
import android.content.Context
import android.support.v7.widget.*
import android.widget.ProgressBar
import android.widget.RadioGroup
import com.svmdev.meunchworlds.data.model.ClasseM

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 17/01/2019.
 */
interface NovoInter {

    fun context(): Context
    fun activity(): Activity
    fun imagem(): AppCompatImageView
    fun nome(): AppCompatEditText
    fun radioGrupo(): RadioGroup
    fun radioUnkown(): AppCompatRadioButton
    fun radioMale(): AppCompatRadioButton
    fun radioFemale(): AppCompatRadioButton
    fun selectClasse(): AppCompatSpinner
    fun buttonSalvar(): AppCompatButton
    fun progresso(): ProgressBar

}