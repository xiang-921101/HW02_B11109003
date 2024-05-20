package com.example.test4
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val place = intent.getSerializableExtra("place") as? Place?
        if (place != null) {
            val imageView = findViewById<ImageView>(R.id.imageView)
            val textViewDescription = findViewById<TextView>(R.id.textViewDescription)

            imageView.setImageResource(place.imageResId)
            textViewDescription.text = place.description

            val buttonOpenMap = findViewById<Button>(R.id.buttonOpenMap)
            buttonOpenMap.setOnClickListener {
                val gmmIntentUri = Uri.parse("geo:${place.latitude},${place.longitude}?q=${Uri.encode(place.name)}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }
        } else {
            val textViewDescription = findViewById<TextView>(R.id.textViewDescription)
            textViewDescription.text = "無法加載地點詳情"
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
