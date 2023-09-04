package com.example.gymapplicationfinalproject


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.gymapplicationfinalproject.databinding.ActivityAbsScissorsTabsBinding
import com.google.android.material.tabs.TabLayout

class AbsScissorsTabs : AppCompatActivity() {

    private lateinit var binding: ActivityAbsScissorsTabsBinding

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abs_scissors_tabs)

        binding = ActivityAbsScissorsTabsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupClickListener()

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager = findViewById<ViewPager>(R.id.viewPager)

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Description"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Tips"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Extra"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = TabAdapter(this, supportFragmentManager, tabLayout!!.tabCount)
        viewPager!!.adapter = adapter

        viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager!!.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {

            }
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }

    private fun setupClickListener() {
        binding.backButtonAbsScissors.setOnClickListener {
            val intent = Intent(this@AbsScissorsTabs, AbsScreen::class.java)
            startActivity(intent)
        }
    }
}