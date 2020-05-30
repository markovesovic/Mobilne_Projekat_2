package rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments.NotesFragment
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments.StatsFragment
import rs.raf.projekat2.marko_vesovic_rn2417.presentation.view.fragments.TimetableFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object  {
        private const val ITEM_COUNT = 3
        const val TIMETABLE_FRAGMENT = 0
        const val NOTES_FRAGMENT = 1
        const val STATS_FRAGMENT = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            TIMETABLE_FRAGMENT -> TimetableFragment()
            NOTES_FRAGMENT -> NotesFragment()
            else -> StatsFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            TIMETABLE_FRAGMENT -> "Raspored"
            NOTES_FRAGMENT -> "Beleske"
            else -> " Statistika"
        }
    }
}