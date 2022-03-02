package android.example.fragmentspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity(), HeadlinesFragment.HeadlinesClickListener {
    companion object{
        var TAG = MainActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onHeadlineclick(headline: String) {
        Log.i(TAG,"from main activity --"+headline)
    }
}