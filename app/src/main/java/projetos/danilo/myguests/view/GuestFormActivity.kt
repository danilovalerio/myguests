package projetos.danilo.myguests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_guest_form.*
import projetos.danilo.myguests.viewmodel.GuestFormViewModel
import projetos.danilo.myguests.R
import projetos.danilo.myguests.service.constants.GuestConstants

class GuestFormActivity : AppCompatActivity() {

    private lateinit var formViewModel: GuestFormViewModel
    private var mGuestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        formViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        loadData()
        setListeners()
        observe()

        radio_presence.isChecked = true
    }

    private fun loadData() {
        val bundle = intent.extras
        if(bundle != null){
            mGuestId = bundle.getInt(GuestConstants.GUEST_ID)
            formViewModel.load(mGuestId)
        }
    }

    private fun observe() {
        formViewModel.saveGuest.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        formViewModel.guest.observe(this, Observer {
            edit_name.setText(it.name)
            edit_name.setSelection(it.name.length)
            if(it.presence) {
                radio_presence.isChecked = true
            } else {
                radio_absent.isChecked = true
            }
        })
    }

    //escutar os toques na tela
    private fun setListeners() {
        button_save.setOnClickListener {
            val name = edit_name.text.toString()
            val presence = radio_presence.isChecked

            //regra de negócio é da viewModel
            formViewModel.save(mGuestId, name, presence)
        }
    }
}
