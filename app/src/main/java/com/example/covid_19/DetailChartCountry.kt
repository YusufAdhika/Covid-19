package com.example.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.covid_19.model.CountriesItem
import kotlinx.android.synthetic.main.activity_detail_chart_country.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat

class DetailChartCountry : AppCompatActivity() {

    companion object{
        const val EXTRA_COUNTRY ="EXTRA COUNTRY "
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_chart_country)

        val data = intent.getParcelableExtra<CountriesItem>(EXTRA_COUNTRY)
        val formatter : NumberFormat = DecimalFormat("#,###")

        data?.let {
            txt_name_counrty.text = data.country
            txt_latest_update.text = data.date
            totalConfirm.text = formatter.format(data.totalConfirmed?.toDouble())
            totalDead.text = formatter.format(data.totalDeaths?.toDouble())
            newRecover.text = formatter.format(data.newRecovered?.toDouble())
            newConfirm.text = formatter.format(data.newConfirmed?.toDouble())
            Glide.with(this).load("https://www.countryflags.io/" + data.countryCode + "/flat/64.png")
                .into(img_flag_country)
        }
    }
}