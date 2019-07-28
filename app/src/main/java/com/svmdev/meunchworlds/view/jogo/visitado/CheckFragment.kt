package com.svmdev.meunchworlds.view.jogo.visitado

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.svmdev.meunchworlds.R

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 07/02/2019.
 */
class CheckFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //
        return inflater.inflate(R.layout.fragment_check, container, false)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

}

