package net.son.chapter14.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import net.son.chapter14.R
import net.son.chapter14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // thiết lập bottom navigation
        val bottomNavigationView = binding.includeMainLayout.bottomNav
        bottomNavigationView.setupWithNavController(navController)

        // thiết lập nút Up và 3 màn hình chính của 3 tab và navigation drawer
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_fragment, R.id.register_fragment, R.id.setting_fragment),
            drawerLayout = binding.drawerLayout
        )
        // gắn navigation view vào navController:
        binding.navView.setupWithNavController(navController)

        // thiết lập toolbar làm action bar
        setSupportActionBar(binding.includeMainLayout.toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.includeMainLayout
            .toolbar
            .setupWithNavController(navController, appBarConfiguration)

        onDestinationChanged()
        setUpDrawerListener()
        setUpNavigationDrawerItemSelected()
    }

    private fun onDestinationChanged() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home_fragment -> {
                    // do something if destination is home fragment
                }

                R.id.register_fragment -> {
                    // do something if destination is register fragment
                }

                R.id.setting_fragment -> {
                    // do something if destination is setting fragment
                }

                else -> {
                    // do something
                }
            }
        }
    }

    // bắt sự kiện navigation drawer mở, đóng, trượt, thay đổi trạng thái
    private fun setUpDrawerListener() {
        binding.drawerLayout.addDrawerListener(object : DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                // todo
            }

            override fun onDrawerOpened(drawerView: View) {
                // todo
            }

            override fun onDrawerClosed(drawerView: View) {
                // todo
            }

            override fun onDrawerStateChanged(newState: Int) {
                // todo
            }
        })
    }

    // lắng nghe sự kiện một phần tử trong menu navigation drawer được click
    private fun setUpNavigationDrawerItemSelected() {
        binding.navView.setNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_item_drawer_search -> {
                    // todo
                }

                R.id.menu_item_drawer_about -> {
                    // todo
                }

                R.id.menu_item_drawer_import -> {
                    // todo
                }

                // ...
            }
            false
        }
    }

    // cho phép bắt sự kiến nhấn Back
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}