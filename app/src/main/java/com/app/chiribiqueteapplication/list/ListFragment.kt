package com.app.chiribiqueteapplication.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.chiribiqueteapplication.databinding.FragmentListBinding
import com.app.chiribiqueteapplication.model.Poi
import com.app.chiribiqueteapplication.model.PoiItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private  lateinit var  listBinding: FragmentListBinding
    private  lateinit var listPois: ArrayList<PoiItem>
    private  lateinit var  poisAdapter: POIListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding= FragmentListBinding.inflate(inflater, container, false)
        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listPois =loadMockPoisfromJson()
        poisAdapter= POIListAdapter(listPois, onItemClicked ={onPoisCliked(it)})
        listBinding.poisRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=poisAdapter
            setHasFixedSize(false)
        }

    }
    private fun onPoisCliked(poi: PoiItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))


    }

    private fun loadMockPoisfromJson(): ArrayList<PoiItem> {
        val poisString: String = context?.assets?.open("pois.json")?.bufferedReader().use { it?.readText()!! }//TODO arreglar
        val gson = Gson()
        return gson.fromJson(poisString, Poi::class.java)

    }



}
