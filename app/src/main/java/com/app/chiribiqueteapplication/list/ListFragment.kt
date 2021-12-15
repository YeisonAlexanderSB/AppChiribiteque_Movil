package com.app.chiribiqueteapplication.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.chiribiqueteapplication.databinding.FragmentListBinding
import com.app.chiribiqueteapplication.model.PoiItem


class ListFragment : Fragment() {

    private  lateinit var  listBinding: FragmentListBinding
    private  val  listViewModel: ListViewModel by  viewModels()
    private  lateinit var  poisAdapter: POIListAdapter
    private  var listPois: ArrayList<PoiItem> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding= FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listViewModel.loadMockPoisfromJson(context?.assets?.open("pois.json"))
        listViewModel.onpoisLoaded.observe(viewLifecycleOwner,{result ->
            onPoisLoadedSubscribe(result)

        })
        poisAdapter= POIListAdapter(listPois, onItemClicked ={onPoisCliked(it)})

        listBinding.poisRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }



    }

    private fun onPoisLoadedSubscribe(result: ArrayList<PoiItem>?) {
        result?.let {listPois ->

            poisAdapter.appendItems(listPois)
        }

    }

    private fun onPoisCliked(poi: PoiItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))


    }





}
