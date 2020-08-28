package com.chong.widget.verticalviewpager.example.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.chong.widget.verticalviewpager.DummyViewPager
import com.chong.widget.verticalviewpager.VerticalVPOnTouchListener
import com.chong.widget.verticalviewpager.example.R

class ContentFragment : Fragment() {


    val title: String?
        get() = arguments!!.getString("title")

    val position: Int
        get() = arguments!!.getInt("position")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_content, container, false)
        initRecyclerView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "$this onResume $userVisibleHint")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onstart $userVisibleHint")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "$this onPause $userVisibleHint")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "$this ondestroy")
    }


    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<View>(R.id.content_list) as RecyclerView
        recyclerView.setOnTouchListener(VerticalVPOnTouchListener(arguments!!.getSerializable("viewpager") as DummyViewPager))//set the vertical scroll controller
        recyclerView.overScrollMode = View.OVER_SCROLL_NEVER
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ContentAdapter(position)
    }

    companion object {

        private val TAG = "ContentFragment"

        fun newInstance(title: String, position: Int, dummyViewPager: DummyViewPager): Fragment {
            val args = Bundle()
            args.putString("title", title)
            args.putInt("position", position)
            args.putSerializable("viewpager", dummyViewPager)
            val fragment = ContentFragment()
            fragment.arguments = args
            return fragment
        }
    }


}
