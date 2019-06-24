package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.databinding.FragmentMapBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLng
import android.R
import com.google.android.gms.maps.SupportMapFragment


class FragmentMap : BaseFragment<FragmentMapBinding, MainViewModel>(), OnMapReadyCallback {

    private var googleMap: GoogleMap? = null

    override fun onMapReady(p0: GoogleMap?) {
        this.googleMap = p0;
        setMarker()
    }

    override fun getBindingVariable(): Int = BR.model

    override fun getLayoutId(): Int = com.example.myapplication.R.layout.fragment_map

    override fun getViewModel(): MainViewModel {
        val mainViewModel = MainViewModel.getInstance(getBaseActivity()!!.application)
        return ViewModelProviders.of(activity!!, ViewModelProviderFactory(mainViewModel)).get(MainViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewDataBinding()?.map?.onCreate(savedInstanceState)
        try {
            MapsInitializer.initialize(getActivity()?.getApplicationContext());
        } catch (e: Exception) {
            e.printStackTrace();
        }
        getViewDataBinding()?.map?.getMapAsync(this);
    }

    public fun setMarker() {
        val sydney = LatLng(-34.0, 151.0)
        googleMap?.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap?.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onResume() {
        getViewDataBinding()?.map?.onResume()
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        getViewDataBinding()?.map?.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        getViewDataBinding()?.map?.onLowMemory()
    }
}