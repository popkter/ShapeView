package com.popkter.shape

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hjq.bar.OnTitleBarListener
import com.hjq.bar.TitleBar
import com.hjq.shape.view.ShapeButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleBar: TitleBar = findViewById<TitleBar>(R.id.tb_main_bar)
        titleBar.setOnTitleBarListener(object : OnTitleBarListener {
            override fun onTitleClick(titleBar: TitleBar) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(titleBar.title.toString()))
                startActivity(intent)
            }
        })

        val shapeButton: ShapeButton = findViewById<ShapeButton>(R.id.btn_main_test)
        shapeButton.setOnClickListener { v: View? ->
            shapeButton.shapeDrawableBuilder
                .setSolidColor(-0x1000000)
                .setStrokeColor(-0xa57221)
                .intoBackground()
            shapeButton.textColorBuilder
                .setTextColor(-0x1)
                .intoTextColor()
            shapeButton.text = "颜色已经改变啦"
        }
    }
}