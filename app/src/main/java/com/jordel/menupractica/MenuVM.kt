package com.jordel.menupractica

import android.view.Menu
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuVM : ViewModel() {

    // Primer plat
    private val _menu = MutableLiveData<MenuModel>()
    val menu: LiveData<MenuModel> = _menu

    init {
        _menu.value = MenuModel("plat", 0, 12.0, "beguda", 0, 5.0)
    }

    fun updateMenuPrimerPlat(cantitatPlats: Int) {
        _menu.value = _menu.value?.copy(
            cantitatPlats = cantitatPlats
        ) ?: MenuModel("plat", cantitatPlats, 12.0, "beguda", 0, 5.0)
    }

    fun updateMenuBeguda(cantitatVegudes: Int) {
        _menu.value = _menu.value?.copy(
            cantitatVegudes = cantitatVegudes
        ) ?: MenuModel("plat", 0, 12.0, "beguda", cantitatVegudes, 5.0)
    }


}