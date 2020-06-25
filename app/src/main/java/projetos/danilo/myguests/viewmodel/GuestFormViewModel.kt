package projetos.danilo.myguests.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import projetos.danilo.myguests.service.model.GuestModel
import projetos.danilo.myguests.service.repository.GuestRepository

class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    private val mContext = application.applicationContext
    private var repository: GuestRepository = GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    private var mGuest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = mGuest

    fun save(name: String, presence: Boolean) {

        val guest =
            GuestModel(null, name, presence)

        mSaveGuest.value = repository.save(guest)
    }

    fun load(id: Int) {
        mGuest.value = repository.get(id)
    }
}