package com.svmdev.meunchworlds.view.novo

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.svmdev.meunchworlds.R
import com.svmdev.meunchworlds.data.model.ClasseM
import com.svmdev.meunchworlds.data.model.JogadorM
import com.svmdev.meunchworlds.help.DBAcess
import java.lang.Exception

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 17/01/2019.
 */
class NovoPresenter(view: Any){

    private val mInter: NovoInter = view as NovoInter
    private val jogador = JogadorM()
    private lateinit var classes: ArrayList<ClasseM>
    private lateinit var arrayAdapter: ArrayAdapter<ClasseM>
    private var selected = 0

    fun novoAction(){
        if(validationForm()){
            //
            isLoading(false)
            try {
                //adiciona no objeto
                jogador.nome = mInter.nome().text.toString()
                jogador.classe = classes.get(selected)
                DBAcess.jogadorAcess.inserir(jogador)
                //inicia os dados do jogador, pega o ultimo id registrado
                val jog = DBAcess.jogadorAcess.findById(0,true)
                DBAcess.jogadorAcess.inserirDadosJogador(jog.id)
                Toast.makeText(mInter.context(),mInter.context().getText(R.string.novo_sucess),Toast.LENGTH_SHORT).show()
                mInter.activity().finish()
            } catch (e: Exception) {
                isLoading(true)
                Toast.makeText(mInter.context(),"Error: ${e.message}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun checkRadio(id: Int){
        when(id){
            0 -> {
                mInter.imagem().setImageResource(R.drawable.n7logo)
                jogador.genero = "U"
            }
            1 -> {
                mInter.imagem().setImageResource(R.drawable.msheppard)
                jogador.genero = "M"
            }
            2 -> {
                mInter.imagem().setImageResource(R.drawable.fsheppard)
                jogador.genero = "F"
            }
        }
    }

    fun carregarClasse(){
        this.classes = DBAcess.classeAcess.listar(true)
        this.arrayAdapter = ArrayAdapter(mInter.context(),
            R.layout.spinner_item_text,
            classes)
        arrayAdapter.setDropDownViewResource(R.layout.spinner_select_text)
        mInter.selectClasse().adapter = this.arrayAdapter
        arrayAdapter.notifyDataSetChanged()
        mInter.selectClasse()?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(selecaoJogador: AdapterView<*>, v: View?, posicao: Int, id: Long) {
                selected = posicao
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun isLoading(habilitar: Boolean){
        mInter.nome().isEnabled = habilitar
        mInter.nome().isEnabled = habilitar
        mInter.radioUnkown().isEnabled = habilitar
        mInter.radioMale().isEnabled = habilitar
        mInter.radioFemale().isEnabled = habilitar
        mInter.selectClasse().isEnabled = habilitar
        mInter.buttonSalvar().isEnabled = habilitar
        mInter.progresso().isIndeterminate = !habilitar
        if(habilitar){
            mInter.nome().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.radioUnkown().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.radioMale().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.radioFemale().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.buttonSalvar().setTextColor(mInter.context().resources.getColor(R.color.corBranca))
            mInter.progresso().visibility = View.GONE
        } else {
            mInter.nome().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.radioUnkown().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.radioMale().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.radioFemale().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.buttonSalvar().setTextColor(mInter.context().resources.getColor(R.color.corPrata))
            mInter.progresso().visibility = View.VISIBLE
        }
    }

    private fun validationForm():Boolean{
        var check = true
        if(mInter.nome().text?.length == 0){
            check = false
            Toast.makeText(mInter.context(),mInter.context().getString(R.string.erro_nome_personagem_vazio),Toast.LENGTH_SHORT).show()
        }
        if(mInter.nome().text?.length!! > 25 ){
            check = false
            Toast.makeText(mInter.context(),mInter.context().getString(R.string.erro_nome_personagem_max),Toast.LENGTH_SHORT).show()
        }
        if(selected == 0){
            check = false
            Toast.makeText(mInter.context(),mInter.context().getString(R.string.erro_classe),Toast.LENGTH_SHORT).show()
        }
        return check
    }

}