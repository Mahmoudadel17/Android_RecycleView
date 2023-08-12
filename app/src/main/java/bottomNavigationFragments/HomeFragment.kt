package bottomNavigationFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.recycleview.ContactListFragment
import com.example.recycleview.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import veiwPager.ViewPagerAdapter

class HomeFragment(private val fragmentActivity: FragmentActivity) :Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home_contact_list, container, false)

        tabLayout= root.findViewById(R.id.tabLayout)
        viewPager= root.findViewById(R.id.viewPager)

        init()

        return root

    }


    private fun init(){
        val adapter = ViewPagerAdapter(fragmentActivity)
        val numberOfContactsOnRecycle = 20
        var start = 1
        for (i in 1..5){
            adapter.addFragment(ContactListFragment(start,numberOfContactsOnRecycle))
            start+=numberOfContactsOnRecycle
        }

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            // Customize tab labels if needed
            tab.text = "Tab ${position+1}"
        }.attach()
    }
}