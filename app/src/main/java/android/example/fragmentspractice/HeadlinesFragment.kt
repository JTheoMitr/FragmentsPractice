package android.example.fragmentspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HeadlinesFragment : Fragment(), AdapterView.OnItemClickListener {
    lateinit var headlinesListview: ListView

    interface  HeadlinesClickListener{ //switchboard
        fun onHeadlineclick(headline: String) //switch
    }

    lateinit var headlinesClickListener : HeadlinesClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //as is typecasting
        headlinesClickListener = activity as MainActivity  //wiring
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var layout: View = inflater.inflate(R.layout.fragment_headlines, container, false)
        headlinesListview = layout.findViewById(R.id.headlinesListview)
        headlinesListview.setOnItemClickListener(this)
        return layout
    }

    override fun onItemClick(adapter: AdapterView<*>?, row: View?, position: Int, rowId: Long) {
        var item  = adapter?.getItemAtPosition(position).toString()
        //Toast.makeText(activity, item, Toast.LENGTH_SHORT).show()
        displayToast(item)
        headlinesClickListener.onHeadlineclick(item)
    }

    fun Fragment.displayToast( message: String){
        Toast.makeText(activity,"extension function --"+message,Toast.LENGTH_SHORT).show()
    }

}