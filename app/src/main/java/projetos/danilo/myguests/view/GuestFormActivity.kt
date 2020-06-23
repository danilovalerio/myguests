package projetos.danilo.myguests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_guest_form.*
import projetos.danilo.myguests.viewmodel.GuestViewModel
import projetos.danilo.myguests.R

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: GuestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        viewModel = ViewModelProvider(this).get(GuestViewModel::class.java)

        setListeners()
        observe()
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.button_save){


            val name = edit_name.text.toString()
            val presence = radio_presence.isChecked

            viewModel.save(name, presence)
        }
    }

    private fun observe() {
        viewModel.saveGuest.observe(this, Observer {
            if(it){
                Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Falha", Toast.LENGTH_SHORT).show()
            }
        })
    }

    //escutar os toques na tela
    private fun setListeners() {
        button_save.setOnClickListener { this }
    }
}
