package com.mjcwrks.quransdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sdk.quran.common.Quran
import com.sdk.quran.common.SurahCallback
import com.sdk.quran.models.Surah

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Quran.Companion.surahList(object: SurahCallback() {
            override fun success(volumes: List<Surah>) {
for(surah in volumes){
    
}
            }

            override fun failure(e: Throwable) {

            }

        })
    }
}