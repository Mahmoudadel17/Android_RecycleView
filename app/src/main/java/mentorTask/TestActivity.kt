package mentorTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.recycleview.R

class TestActivity : AppCompatActivity(), TestMessageFragment.CallBacksInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        init()
    }

    private fun init(){
        val testMessageFragment = TestMessageFragment(this)
        addFragments(testMessageFragment)
    }

    private fun addFragments(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container_view,fragment)
        transaction.commit()
    }

    override fun showMessage(text: String) {
        Toast.makeText(this,"hi $text",Toast.LENGTH_SHORT).show()
    }


//     val showMessage =  fun(myText:String){
//        Toast.makeText(this,"hi $myText",Toast.LENGTH_SHORT).show()
//
//    }
//

}