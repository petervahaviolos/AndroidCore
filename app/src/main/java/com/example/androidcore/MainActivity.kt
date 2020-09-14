package com.example.androidcore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Make a toast appear when the app starts
        val toast = Toast.makeText(applicationContext, "Can you see this?", Toast.LENGTH_SHORT)
        toast.show()

        //Make a toast appear at the top of the screen
        val topToast = Toast.makeText(applicationContext, "This is at the top", Toast.LENGTH_SHORT)
        topToast.setGravity(Gravity.TOP, 0, 0)
        topToast.show()

        //Using a custom toast
        val inflater = layoutInflater //Allows instantiating an XML file into view objects
        val container : ViewGroup = findViewById(R.id.custom_toast_container)
        val layout : View = inflater.inflate(R.layout.custom_toast, container)
        val text : TextView = layout.findViewById(R.id.text)
        text.text = "This is a custom toast message!"
        with(Toast(applicationContext)) {
            setGravity(Gravity.CENTER_VERTICAL, 0,0)
            duration = Toast.LENGTH_LONG
            setContentView(layout)
            show()
        }
    }
}