package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/** Lab Activity Branch
 * 1. DONE  Create a new branch of your previous in-class activity (Die Roll)
 * 2. DONE Modify the DieFragment class implementation to accept the number
 * sides the die should have (6 is the default) using a Factory Method
 * 3. DONE Add an additional FragmentContainerView to the Activity's layout and include another die so that clicking the Roll button results in 2 dice being rolled
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(
                R.id
                    .fragmentContainerView
            ) == null ||
            supportFragmentManager.findFragmentById(
                R.id
                    .fragmentContainerView2
            ) == null
        ) {
            val dieFragment = DieFragment.newInstance(6)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, dieFragment)
                .commit()
            val dieFragment2 = DieFragment.newInstance(6)
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView2, dieFragment2)
                .commit()

        }
        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView)?.run {
                    (this as DieFragment).throwDie()
                }
            supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView2)?.run {
                    (this as DieFragment).throwDie()
                }
        }
    }
}