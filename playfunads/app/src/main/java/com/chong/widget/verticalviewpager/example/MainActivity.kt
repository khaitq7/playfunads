package com.chong.widget.verticalviewpager.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.chong.widget.verticalviewpager.DummyViewPager
import com.chong.widget.verticalviewpager.example.adapter.ContentFragment
import com.chong.widget.verticalviewpager.example.adapter.ContentFragmentAdapter


class MainActivity : AppCompatActivity() {
    internal lateinit var viewPager: DummyViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = ""
        initViewPager()
    }

    private fun initViewPager() {
        viewPager = findViewById<View>(R.id.vertical_viewpager) as DummyViewPager
        //        viewPager.setPageTransformer(false, new ZoomOutTransformer());
        //        viewPager.setPageTransformer(true, new StackTransformer());
        val title = "ContentFragment"
        viewPager.adapter = ContentFragmentAdapter.Holder(supportFragmentManager)
                .add(ContentFragment.newInstance(title, 1, viewPager))
                .add(ContentFragment.newInstance(title, 2, viewPager))
                .add(ContentFragment.newInstance(title, 3, viewPager))
                .add(ContentFragment.newInstance(title, 4, viewPager))
                .add(ContentFragment.newInstance(title, 5, viewPager))
                .set()
        //If you setting other scroll mode, the scrolled fade is shown from either side of display.
        viewPager.overScrollMode = View.OVER_SCROLL_ALWAYS
    }

    override fun onBackPressed() {
        viewPager.setCurrentItem(0, false)
    }
}
