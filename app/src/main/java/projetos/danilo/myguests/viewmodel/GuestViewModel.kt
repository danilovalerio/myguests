package projetos.danilo.myguests.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import projetos.danilo.myguests.service.model.GuestModel
import projetos.danilo.myguests.service.repository.GuestRepository

class GuestViewModel: ViewModel() {
    private lateinit var repository: GuestRepository

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest


    fun save(name: String, presence: Boolean) {

        val guest =
            GuestModel(name, presence)

        repository.save(guest)
    }
}