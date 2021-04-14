package com.mjcwrks.quransdk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mjcwrks.quran.common.Quran
import com.mjcwrks.quran.common.SurahCallback
import com.mjcwrks.quran.models.Surah

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