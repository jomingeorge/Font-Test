package com.test.font

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.font.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FontSelected {

    private lateinit var binding: ActivityMainBinding

    val texts = listOf("Caveat", "Dancing Script", "Gochi Hand",
        "Great Vibes", "Indie Flower","Lato","Lobster","Pacifico","Saira Condensed")
    val fonts = listOf(
        R.font.caveat_regular, // Replace with your actual font resource IDs
        R.font.dancingscript_regular,
        R.font.gochihand_regular,
        R.font.greatvibes_regular,
        R.font.indieflower,
        R.font.lato_regular,
        R.font.lobster_regular,
        R.font.pacifico_regular,
        R.font.sairacondensed_regular
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.welcomeTextView

        binding.fontRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.fontRecyclerView.adapter = TextAdapter(this, this,texts, fonts)

    }

    override fun fontSelected(position: Int) {
        val typeface = ResourcesCompat.getFont(this, fonts[position])
        binding.welcomeTextView.typeface = typeface

    }

}