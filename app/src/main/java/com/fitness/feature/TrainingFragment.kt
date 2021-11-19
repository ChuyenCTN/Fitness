package com.fitness.feature

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fitness.R
import com.fitness.adapter.TraingListAdapter
import com.fitness.adapter.TrainingSlideAdapter
import com.fitness.model.ItemSlideTraining
import com.fitness.model.ItemTraining
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter
import com.yarolegovich.discretescrollview.transform.Pivot
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.fragment_training.*

class TrainingFragment : Fragment() {

    var adapter: TraingListAdapter = TraingListAdapter()
    var adapterSlide: TrainingSlideAdapter = TrainingSlideAdapter()
    private var infiniteAdapter: InfiniteScrollAdapter<*>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_training, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRCV()
        fakeData()
    }

    fun setUpRCV() {
        if (rcvTraining != null) {
            if (adapter == null)
                adapter = TraingListAdapter()
            val layoutManager = LinearLayoutManager(context)
            rcvTraining.layoutManager = layoutManager
            rcvTraining.adapter = adapter
        }
    }

    fun fakeData() {
        var responseList: ArrayList<ItemTraining> = ArrayList()
        for (i in 1..10) {
            responseList.add(ItemTraining("Day ${i}", "${i + 2} min . ${i} workout", i))
        }
        adapter.setData(responseList)

        var slideData: ArrayList<ItemSlideTraining> = ArrayList()
        slideData.add(ItemSlideTraining(title1 = "Fitness Workout",title2 = "Fitness Workout",time = "30 days left",image = R.drawable.image_slide_1,1))
        slideData.add(ItemSlideTraining(title1 = "Beginer",title2 = "Beginer",time = "30 days left",image = R.drawable.image_slide_2,3))
        slideData.add(ItemSlideTraining(title1 = "Fitness Workout",title2 = "Fitness Workout",time = "30 days left",image = R.drawable.image_slide_3,2))

        if (adapterSlide == null)
            adapterSlide = TrainingSlideAdapter()
        adapterSlide.setData(slideData)
        infiniteAdapter = InfiniteScrollAdapter.wrap(adapterSlide)
        slideTraining.setOrientation(DSVOrientation.HORIZONTAL)
        slideTraining.adapter = adapterSlide

        slideTraining.setItemTransformer(
            ScaleTransformer.Builder()
                .setMinScale(0.5f)
                .setMaxScale(1f)
                .setPivotX(Pivot.X.LEFT)
                .build()
        )

        adapterSlide.setItemClick(object : TrainingSlideAdapter.itemClickListener {
            override fun onClick(item: ItemSlideTraining) {
                startActivity(Intent(requireContext(), BeginActivity::class.java))
            }

        })

    }
}