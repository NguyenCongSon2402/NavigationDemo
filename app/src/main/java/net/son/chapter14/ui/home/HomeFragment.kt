package net.son.chapter14.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import net.son.chapter14.MyApplication
import net.son.chapter14.R
import net.son.chapter14.databinding.FragmentHomeBinding
import net.son.chapter14.ui.viewmodel.ProfileViewModel
import net.son.chapter14.ui.viewmodel.ProfileViewModelFactory

class HomeFragment : Fragment(), MenuProvider {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: ProfileViewModel by activityViewModels {
        val repository =
            (requireActivity().application as MyApplication).repository
        ProfileViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.main_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.main_menu_item_profile -> {
                val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                findNavController().navigate(action)
                true
            }

            else -> false
        }
    }
}