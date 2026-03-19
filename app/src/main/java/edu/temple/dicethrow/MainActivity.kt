package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

/** Lab Activity Branch
 * 1. DONE  Create a new branch of your previous in-class activity (Die Roll)
 * 2. DONE Modify the DieFragment class implementation to accept the number
 * sides the die should have (6 is the default) using a Factory Method
 * 3. DONE Add an additional FragmentContainerView to the Activity's layout and include another die so that clicking the Roll button results in 2 dice being rolled
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val dieViewModel = ViewModelProvider(this)[DieViewModel::class.java]
        dieViewModel.setSides(20)

        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(
                R.id
                    .fragmentContainerView
            ) == null
        ) {
            val dieFragment = DieFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, dieFragment)
                .commit()

        }
        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            dieViewModel.throwDie()
        }
    }
}