package com.katiearose.sobriety.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.katiearose.sobriety.ProgressBarAdapter
import com.katiearose.sobriety.databinding.ActivitySummaryBinding
import com.katiearose.sobriety.shared.Addiction
import com.katiearose.sobriety.utils.*

class Summary : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding
    private lateinit var addiction: Addiction
    private lateinit var progressAdapter: ProgressBarAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        applyThemes()
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addiction = Main.addictions[checkValidIntentData()]
        title = addiction.name


        progressAdapter = ProgressBarAdapter(addiction, this)
        binding.progressBarList.layoutManager = LinearLayoutManager(this)
        binding.progressBarList.setHasFixedSize(true)
        binding.progressBarList.adapter = progressAdapter
        (binding.progressBarList.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
    }

    private fun update() {
        progressAdapter.update()
    }
}