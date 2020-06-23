package projetos.danilo.myguests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: GuestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        viewModel = ViewModelProvider(this).get(GuestViewModel::class.java)

        setListeners()
    }

    //escutar os toques na tela
    private fun setListeners() {
        button_save.setOnClickListener { this }
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.button_save){
            //realiza algo aqui
        }
    }
}
