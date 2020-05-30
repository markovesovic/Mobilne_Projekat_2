package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_vesovic_rn2417.R
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.contract.UserContract.ViewModel
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.viewpager.PagerAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.viewmodels.UserViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: ViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.init()
    }

    private fun init() {
        initViewPager()
        initBottomNavigation()
    }

    private fun initViewPager() {
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    private fun initBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_item_1 -> {
                    viewPager.currentItem = PagerAdapter.TIMETABLE_FRAGMENT
                }
                R.id.navigation_item_2 -> {
                    viewPager.currentItem = PagerAdapter.NOTES_FRAGMENT
                }
                R.id.navigation_item_3 -> {
                    viewPager.currentItem = PagerAdapter.STATS_FRAGMENT
                }
            }
            true
        }
    }

}