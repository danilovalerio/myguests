package projetos.danilo.myguests.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import projetos.danilo.myguests.R
import projetos.danilo.myguests.service.model.GuestModel


class GuestViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val name = itemView.findViewById<TextView>(R.id.textview_name)
        name.text = guest.name
    }
}