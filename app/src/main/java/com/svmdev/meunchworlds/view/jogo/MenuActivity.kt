package com.svmdev.meunchworlds.view.jogo

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.svmdev.meunchworlds.R
import com.svmdev.meunchworlds.view.jogo.home.HomeFragment
import com.svmdev.meunchworlds.view.jogo.inexplorado.UncheckFragment
import com.svmdev.meunchworlds.view.jogo.visitado.CheckFragment

/**
 * Mass Effect Uncharted Worlds
 * Desenvolvido por Sávio Martins Valentim em 07/02/2019.
 */
class MenuActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener  {


    private lateinit var navigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        navigationView = findViewById(R.id.menu_navigation)

        navigationView.setOnNavigationItemSelectedListener(this)
        trocarFragmento(HomeFragment())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragmento: Fragment
        when (item.itemId) {
            R.id.navigation_home -> { fragmento = HomeFragment() }
            R.id.navigation_dashboard_explored -> { fragmento = CheckFragment() }
            R.id.navigation_dashboard_unexplored -> { fragmento = UncheckFragment() }
            else -> { fragmento = HomeFragment()   }
        }
        trocarFragmento(fragmento)
        return true
    }

    private fun trocarFragmento(fragment: Fragment){
        val transacttion = supportFragmentManager.beginTransaction()
        transacttion.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
        transacttion.replace(R.id.menu_container, fragment)
        transacttion.addToBackStack(null)
        transacttion.commit()

    }

}
