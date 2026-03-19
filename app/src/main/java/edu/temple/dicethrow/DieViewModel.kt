package edu.temple.dicethrow

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {
    var sides: Int = 6
    val dieRoll = MutableLiveData<Int>()
    fun throwDie() {
        currentDieRoll = Random.nextInt(1, dieSides + 1)
        dieTextView.text = currentDieRoll.toString()

    }

}