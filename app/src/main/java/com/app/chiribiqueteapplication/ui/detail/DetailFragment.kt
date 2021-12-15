package com.app.chiribiqueteapplication.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.chiribiqueteapplication.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        detailBinding= FragmentDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poi= args.poi

        with(detailBinding){
            Picasso.get().load(poi.urlPictureDetail).into(detpoiImageView)
            detpoiCaptionimageTextView.text=poi.captionDetail
            detpoiTitleTextView.text = poi.name
            detpoiBodyRatingTextView.text = poi.rating.toString()
            detpoiBodyDescriptionTextView.text = poi.descriptionDetail
            detailMapsImageButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToMapsFragment(poi.latitude, poi.longitude))
            }


        }

    }

}