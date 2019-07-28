package com.svmdev.meunchworlds.help

import android.app.Activity
import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*


/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 15/01/2019.
 */

/**
Troca de telas
 */
inline fun iniciarActivity(actvOrig: Activity, actvDest: Class<*>, extra: Bundle? = null){
    val troca = Intent(actvOrig, actvDest)
    if(extra != null){
        troca.putExtras(extra)
    }
    actvOrig.startActivity(troca)
}

fun iniciarActivityFinalizando(actvOrig: Activity, actvDest: Class<*>, extra: Bundle? = null){
    val troca = Intent(actvOrig, actvDest)
    if(extra != null){
        troca.putExtras(extra)
    }
    actvOrig.startActivity(troca)
    actvOrig.finish()
}

fun iniciarActivitySemHistorico(actvOrig: Activity, actvDest: Class<*>, extra: Bundle? = null) {
    val troca = Intent(actvOrig, actvDest)
    if (extra != null) {
        troca.putExtras(extra)
    }
    actvOrig.finishAffinity()
    actvOrig.startActivity(
        troca
    )
    actvOrig.finish()
}

fun iniciarNavegador(actvOrig: Activity, link: String){
    actvOrig.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
}

/**
Toolbar
*/
fun construirToolbar(context: AppCompatActivity,toolbar: Toolbar, title: String){
    context.setSupportActionBar(toolbar)
    context.supportActionBar?.setDisplayShowTitleEnabled(false)
    context.supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.navigationIcon?.setColorFilter(ContextCompat.getColor(context,android.R.color.white), PorterDuff.Mode.SRC_ATOP)
    toolbar.title = title
}
