package com.svmdev.meunchworlds.view.novo

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.RadioGroup
import com.svmdev.meunchworlds.R
import com.svmdev.meunchworlds.help.construirToolbar

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 17/01/2019.
 */
class NovoActivity : AppCompatActivity(), View.OnClickListener, NovoInter, RadioGroup.OnCheckedChangeListener {

    private lateinit var toolbarUi: Toolbar
    private lateinit var foto: AppCompatImageView
    private lateinit var campoNome: AppCompatEditText
    private lateinit var rGrupo: RadioGroup
    private lateinit var rUnkown: AppCompatRadioButton
    private lateinit var rMale: AppCompatRadioButton
    private lateinit var rFemale: AppCompatRadioButton
    private lateinit var selectClasse: AppCompatSpinner
    private lateinit var salvar: AppCompatButton

    private lateinit var progress: ProgressBar

    private lateinit var mPresenter: NovoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo)

        toolbarUi = this.findViewById(R.id.novo_toolbar)

        foto = findViewById(R.id.novo_img)
        campoNome = findViewById(R.id.novo_nome)
        rGrupo = findViewById(R.id.novo_genero_group_m)
        rUnkown = findViewById(R.id.novo_radio_u)
        rMale = findViewById(R.id.novo_radio_m)
        rFemale = findViewById(R.id.novo_radio_f)
        selectClasse = findViewById(R.id.novo_selectclasse)
        salvar = findViewById(R.id.novo_btn_salvar)
        progress = findViewById(R.id.novo_progresso)

        construirToolbar(this,toolbarUi,this.getString(R.string.novo_toolbar))

        rGrupo.setOnCheckedChangeListener(this)
        salvar.setOnClickListener(this)

        mPresenter = NovoPresenter(this)

        mPresenter.carregarClasse()

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.novo_btn_salvar -> { mPresenter.novoAction() }
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

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        when(p1){
            R.id.novo_radio_u -> { mPresenter.checkRadio(0) }
            R.id.novo_radio_m -> { mPresenter.checkRadio(1) }
            R.id.novo_radio_f -> { mPresenter.checkRadio(2) }
        }
    }

    override fun context(): Context { return this }

    override fun activity(): Activity { return this }

    override fun imagem(): AppCompatImageView { return this.foto}

    override fun nome(): AppCompatEditText { return this.campoNome }

    override fun radioGrupo(): RadioGroup { return radioGrupo() }

    override fun radioUnkown(): AppCompatRadioButton { return this.rUnkown }

    override fun radioMale(): AppCompatRadioButton { return this.rMale }

    override fun radioFemale(): AppCompatRadioButton { return this.rFemale }

    override fun selectClasse(): AppCompatSpinner { return  this.selectClasse }

    override fun buttonSalvar(): AppCompatButton { return this.salvar }

    override fun progresso(): ProgressBar { return this.progress}

}
