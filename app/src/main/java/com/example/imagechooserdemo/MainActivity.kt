package com.example.imagechooserdemo

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagechooserdemo.databinding.ActivityMainBinding
import com.github.dhaval2404.imagepicker.ImagePicker

class MainActivity : AppCompatActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.BLUE))
        binding.floatingActionButton.setOnClickListener {
            ImagePicker.with(this)
                .crop(1.5f,1.5f)	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.imageButton.setImageURI(data?.data)
    }
}