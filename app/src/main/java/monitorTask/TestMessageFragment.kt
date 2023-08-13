package monitorTask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.recycleview.R

class TestMessageFragment(val callBack:CallBacksInterface) :Fragment() {
    private lateinit var mainView: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mainView =  inflater.inflate(R.layout.fragment_test_message, container, false)
        return mainView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myButton = mainView.findViewById<Button>(R.id.buttonToast)

//        val parentActivity = requireActivity() as TestActivity

        myButton.setOnClickListener {
//            callBack("from TestMessageFragment")
//            parentActivity.showMessage("from TestMessageFragment requireActivity")
            callBack.showMessage("from TestMessageFragment requireActivity")

        }
    }

    interface CallBacksInterface{
        fun showMessage(text:String)
    }
}