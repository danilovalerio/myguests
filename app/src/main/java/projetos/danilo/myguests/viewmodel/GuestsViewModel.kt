package projetos.danilo.myguests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import projetos.danilo.myguests.service.constants.GuestConstants
import projetos.danilo.myguests.service.model.GuestModel
import projetos.danilo.myguests.service.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {
        when (filter) {
            GuestConstants.FILTER.EMPTY -> mGuestList.value = mGuestRepository.getAll()
            GuestConstants.FILTER.PRESENT -> mGuestList.value = mGuestRepository.getPresent()
            GuestConstants.FILTER.ABSENT -> mGuestList.value = mGuestRepository.getAbsent()
        }
    }

    fun delete(guest: GuestModel) {
        mGuestRepository.delete(guest)
    }
}