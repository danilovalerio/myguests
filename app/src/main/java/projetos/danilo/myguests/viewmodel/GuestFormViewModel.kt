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

    fun save(id: Int, name: String, presence: Boolean) {

        val guest = GuestModel(id, name, presence)

        if(name.isNullOrEmpty()) {
            mSaveGuest.value = false
        } else {
            if(id == 0) {
                mSaveGuest.value = repository.save(guest)
            } else {
                mSaveGuest.value = repository.update(guest)
            }
        }




    }

    fun load(id: Int) {
        mGuest.value = repository.get(id)
    }
}