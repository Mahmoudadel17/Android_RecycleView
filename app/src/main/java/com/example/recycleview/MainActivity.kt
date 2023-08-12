package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import bottomNavigationFragments.FavoriteFragment
import bottomNavigationFragments.HomeFragment
import bottomNavigationFragments.SearchFragment
import bottomNavigationFragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import veiwPager.ViewPagerAdapter
import androidx.navigation.ui.setupWithNavController



class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var fragment: FragmentContainerView



    private val homeFragment = HomeFragment(this)
    private val searchFragment = SearchFragment()
    private val favoriteFragment = FavoriteFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        callBack()
    }

    private fun init(){
        bottomNav = findViewById(R.id.bottomNav)
        fragment = findViewById(R.id.fragmentHome)

        addFragments(homeFragment)
    }
    private fun addFragments(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragmentHome,fragment)
        transaction.commit()
    }
    private fun showFragments(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentHome,fragment)
        transaction.commit()
    }

    private fun callBack(){
        // when user click on item on buttomNavigation
        bottomNav.setOnItemSelectedListener{ item->
            when(item.itemId){
                R.id.home ->{
                    showFragments(homeFragment)
                    true
                }
                R.id.search->{
                    showFragments(searchFragment)
                    true
                }
                R.id.favorite->{
                    showFragments(favoriteFragment)
                    true
                }
                R.id.settings ->{
                    showFragments(settingsFragment)
                    true
                }else -> false
            }
        }
    }
}

