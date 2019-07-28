package com.svmdev.meunchworlds.view.inicio

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.svmdev.meunchworlds.R
import com.svmdev.meunchworlds.data.model.JogadorM
import com.svmdev.meunchworlds.help.DBAcess
import com.svmdev.meunchworlds.help.iniciarActivity
import com.svmdev.meunchworlds.view.jogo.MenuActivity
import com.svmdev.meunchworlds.view.novo.NovoActivity
import com.svmdev.meunchworlds.view.sobre.SobreActivity

/**
 * Mass Effect Uncharted Worldsw
 * Desenvolvido por Sávio Martins Valentim em 15/01/2019.
 */
class InicioPresenter(view: Any){

    private val mInter: InicioInter = view as InicioInter
    private lateinit var jogadores: ArrayList<JogadorM>
    private lateinit var arrayAdapter: ArrayAdapter<JogadorM>
    var selected = 0

    fun iniciarActivity(opt: Int){
        isLoading(false)
        when(opt){
            1 -> { iniciaJogo() }
            2 -> { iniciarActivity(mInter.activity(), NovoActivity::class.java,null) }
            3 -> { iniciarActivity(mInter.activity(), SobreActivity::class.java,null) }
        }
    }

    fun carregaJogadores(){
        this.jogadores = DBAcess.jogadorAcess.listar(true)

        this.arrayAdapter = ArrayAdapter(mInter.context(),
            R.layout.spinner_item_text,
            jogadores)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_select_text)
        mInter.selectPersonagem().adapter = this.arrayAdapter
        arrayAdapter.notifyDataSetChanged()
        mInter.selectPersonagem()?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(selecaoJogador: AdapterView<*>, v: View?, posicao: Int, id: Long) {
                selected = posicao
                val gen = jogadores.get(selected).genero
                if(gen.equals("M"))
                    mInter.imgPerso().setImageResource(R.drawable.msheppard)
                else if(gen.equals("F"))
                    mInter.imgPerso().setImageResource(R.drawable.fsheppard)
                else
                    mInter.imgPerso().setImageResource(R.drawable.n7logo)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}

        }
    }

    fun iniciaJogo(){
        if(validationForm()){
            //cria a intent, passa pela bundle o id do player
            var param = Bundle()
            param.putInt("idperso",jogadores.get(selected).id)
            iniciarActivity(mInter.activity(), MenuActivity::class.java, param)
            isLoading(true)
        } else {
            isLoading(true)
        }
    }

    fun isLoading(habilitar: Boolean){
        mInter.selectPersonagem().isEnabled = habilitar
        mInter.btnEntrar().isEnabled = habilitar
        mInter.btnCriar().isEnabled = habilitar
        mInter.btnSobre().isEnabled = habilitar
        mInter.progresso().isIndeterminate = !habilitar
        if(habilitar){
            mInter.btnEntrar().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.btnCriar().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.btnSobre().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.progresso().visibility = View.GONE
        } else {
            mInter.btnEntrar().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.btnCriar().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.btnSobre().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.progresso().visibility = View.VISIBLE
        }
    }

    private fun validationForm(): Boolean{
        var check = true
        if(jogadores.size <= 1){
            check = false
            Toast.makeText(mInter.context(),mInter.context().getString(R.string.erro_personagem_a),Toast.LENGTH_SHORT).show()
        } else
        if(jogadores.size > 1 && jogadores.get(selected).id == 0){
            check = false
            Toast.makeText(mInter.context(),mInter.context().getString(R.string.erro_personagem_b),Toast.LENGTH_SHORT).show()
        }
        return check;
    }

}