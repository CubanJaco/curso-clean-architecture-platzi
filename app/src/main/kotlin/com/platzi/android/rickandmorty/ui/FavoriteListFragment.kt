package com.platzi.android.rickandmorty.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.platzi.android.rickandmorty.R
import com.platzi.android.rickandmorty.adapters.FavoriteListAdapter
import com.platzi.android.rickandmorty.databinding.FragmentFavoriteListBinding
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.presentation.FavoriteListViewModel
import com.platzi.android.rickandmorty.presentation.FavoriteListViewModel.FavoriteListNavigation
import com.platzi.android.rickandmorty.presentation.FavoriteListViewModel.FavoriteListNavigation.ShowCharacterList
import com.platzi.android.rickandmorty.presentation.FavoriteListViewModel.FavoriteListNavigation.ShowEmptyListMessage
import com.platzi.android.rickandmorty.presentation.utils.Event
import com.platzi.android.rickandmorty.utils.setItemDecorationSpacing
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_favorite_list.*

@AndroidEntryPoint
class FavoriteListFragment : Fragment() {

    //region Fields

    private lateinit var favoriteListAdapter: FavoriteListAdapter
    private lateinit var listener: OnFavoriteListFragmentListener

    private val favoriteListViewModel: FavoriteListViewModel by viewModels()

    //endregion

    //region Override Methods & Callbacks

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            listener = context as OnFavoriteListFragmentListener
        }catch (e: ClassCastException){
            throw ClassCastException("$context must implement OnFavoriteListFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<FragmentFavoriteListBinding>(
            inflater,
            R.layout.fragment_favorite_list,
            container,
            false
        ).apply {
            lifecycleOwner = this@FavoriteListFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteListAdapter = FavoriteListAdapter { character ->
            listener.openCharacterDetail(character)
        }
        favoriteListAdapter.setHasStableIds(true)

        rvFavoriteList.run {
            setItemDecorationSpacing(resources.getDimension(R.dimen.list_item_padding))
            adapter = favoriteListAdapter
        }

        favoriteListViewModel.favoriteCharacterList.observe(viewLifecycleOwner, Observer(favoriteListViewModel::onFavoriteCharacterList))
        favoriteListViewModel.events.observe(viewLifecycleOwner, Observer(this::validateEvents))
    }

    //endregion

    //region Private Methods

    private fun validateEvents(event: Event<FavoriteListNavigation>?) {
        event?.getContentIfNotHandled()?.let { navigation ->
            when (navigation) {
                is ShowCharacterList -> navigation.run {
                    tvEmptyListMessage.isVisible = false
                    favoriteListAdapter.updateData(characterList)
                }
                ShowEmptyListMessage -> {
                    tvEmptyListMessage.isVisible = true
                    favoriteListAdapter.updateData(emptyList())
                }
            }
        }
    }

    //endregion

    //region Inner Classes & Interfaces

    interface OnFavoriteListFragmentListener {
        fun openCharacterDetail(character: Character)
    }

    //endregion

    //region Companion object

    companion object {

        fun newInstance(args: Bundle? = Bundle()) = FavoriteListFragment().apply {
            arguments = args
        }
    }

    //endregion

}
