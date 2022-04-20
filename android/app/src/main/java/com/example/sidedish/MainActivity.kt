package com.example.sidedish

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sidedish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mainAdapter = MainHomeAdapter()
        val soupAdapter = MainHomeAdapter()
        val sideAdapter = MainHomeAdapter()

        binding.rvMainlist.adapter = mainAdapter
        binding.rvSidelist.adapter = soupAdapter
        binding.rvSouplist.adapter = sideAdapter

        mainAdapter.submitList(mainPut())
        soupAdapter.submitList(soupPut())
        sideAdapter.submitList(sidePut())

        val count1 = mainAdapter.itemCount.toString()
        binding.tvHeaderSub1.text = "${count1}개 상품이 등록되어 있습니다."

        val count2 = soupAdapter.itemCount.toString()
        binding.tvHeaderSub2.text = "${count2}개 상품이 등록되어 있습니다."

        val count3 = sideAdapter.itemCount.toString()
        binding.tvHeaderSub3.text = "${count3}개 상품이 등록되어 있습니다."

        binding.tvHeaderTitle1.setOnClickListener {
            if (binding.tvHeaderSub1.visibility == View.GONE) {
                binding.tvHeaderSub1.visibility = View.VISIBLE
            } else
                binding.tvHeaderSub1.visibility = View.GONE
        }

        binding.tvHeaderTitle2.setOnClickListener {
            if (binding.tvHeaderSub2.visibility == View.GONE) {
                binding.tvHeaderSub2.visibility = View.VISIBLE
            } else
                binding.tvHeaderSub2.visibility = View.GONE
        }

        binding.tvHeaderTitle3.setOnClickListener {
            if (binding.tvHeaderSub3.visibility == View.GONE) {
                binding.tvHeaderSub3.visibility = View.VISIBLE
            } else
                binding.tvHeaderSub3.visibility = View.GONE
        }
    }
}