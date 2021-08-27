package com.example.app_1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_1.databinding.FragmentLeftoversBinding

/**
 * A simple [Fragment] subclass.
 * Use the [Leftovers.newInstance] factory method to
 * create an instance of this fragment.
 */
class Leftovers : Fragment() {
    private lateinit var productsAdapter : AdapterGoodsAmount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productsAdapter = AdapterGoodsAmount(this.requireActivity().applicationContext)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leftovers, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvProducts)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        productsAdapter.fillList()
        recyclerView.adapter = productsAdapter
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         *
         * @return A new instance of fragment Leftovers.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = Leftovers()
    }
}
