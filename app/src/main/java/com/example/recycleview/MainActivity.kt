package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    lateinit var buttonClearFragment: Button
    var buttonClicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callBack()
    }


    private fun callBack(){
        buttonClearFragment = findViewById(R.id.buttonClearFragment)
        buttonClearFragment.setOnClickListener{
            if (!buttonClicked){
                supportFragmentManager.beginTransaction()
                .replace(R.id.container,EmptyFragment() )
                .commitNow()
                buttonClicked = buttonClicked.not()
                animateChangeButtonText(buttonClearFragment, "Restore Recycle View")
            }else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container,ContactListFragment() )
                    .commitNow()
                buttonClicked = buttonClicked.not()
                animateChangeButtonText(buttonClearFragment, "Hide Recycle View")

            }
        }
    }











    private fun animateChangeButtonText(button:Button,newText:String){
        // Animate text change
        button.animate()
            .alpha(0f) // Fade out the text
            .setDuration(200) // Animation duration in milliseconds
            .withEndAction {
                // Update text after animation
                button.text = newText

                // Fade in the updated text
                button.alpha = 0f
                button.animate()
                    .alpha(1f)
                    .setDuration(200)
                    .start()
            }
            .start()
    }

}