package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {
    var dieSides: Int = 6
    val dieRoll = MutableLiveData<Int>()

    fun getDieRoll(): LiveData<Int> {
        return dieRoll
    }

    fun throwDie() {
        dieRoll.value = Random.nextInt(1, dieSides + 1)
    }

    fun setSides(new_sides: Int) {
        dieSides = new_sides
    }

}