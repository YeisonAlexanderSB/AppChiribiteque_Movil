package com.app.chiribiqueteapplication.maps

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.app.chiribiqueteapplication.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {
    private val args:MapsFragmentArgs by navArgs()
    private val callback = OnMapReadyCallback { googleMap ->

       val sierra = LatLng(args.latitude.toDouble(), args.longitude.toDouble())
         //val sierra = LatLng(1.72, -74.3)
        googleMap.addMarker(MarkerOptions().position(sierra).title("Sierra de Chiribiquete"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sierra, 10F))
    }

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MapsFragment", "onCreateView: " +args.latitude)
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}