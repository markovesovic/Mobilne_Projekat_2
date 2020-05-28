package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import rs.raf.projekat2.marko_vesovic_rn2417.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.init()
    }

    private fun init() {
        initViewPager()
        initBottomNavigation()
    }

    private fun initViewPager() {

    }

    private fun initBottomNavigation() {

    }

}