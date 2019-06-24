package com.example.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {
    override fun getBindingVariable(): Int = BR.model

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewMolel(): MainViewModel {
        val mainViewModel = MainViewModel.getInstance(application)
        return ViewModelProviders.of(this, ViewModelProviderFactory(mainViewModel)).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getViewMolel().set()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replceFragment(FragmentMap())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    fun replceFragment(fragment: Fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.message, fragment).commit();
    }
}
