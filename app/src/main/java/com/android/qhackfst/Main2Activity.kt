package com.android.qhackfst

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {
    override fun finish() {
        super.finish()
        val fade = Fade()

        overridePendingTransition(0, R.anim.fadeout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
         val  edti:EditText = findViewById(R.id.editText);
        val decor= window.decorView
        val fade = Fade()
        fade.excludeTarget(android.R.id.statusBarBackground, true);
        fade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        editText.setOnClickListener {
            var intent :Intent = Intent(this@Main2Activity,SearchActivity::class.java)
            var option = ViewCompat.getTransitionName(edti)?.let { it1 ->
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,edti, it1)
            }
            overridePendingTransition(0, R.anim.fadeout)
            startActivity(intent,option?.toBundle())
            getWindow().setEnterTransition(fade);
            getWindow().setExitTransition(fade);

        }
    }
}
