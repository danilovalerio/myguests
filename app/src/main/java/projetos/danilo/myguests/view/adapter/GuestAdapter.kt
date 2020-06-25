package projetos.danilo.myguests.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import projetos.danilo.myguests.R
import projetos.danilo.myguests.service.model.GuestModel
import projetos.danilo.myguests.view.listener.GuestListener
import projetos.danilo.myguests.view.viewholder.GuestViewHolder

class GuestAdapter: RecyclerView.Adapter<GuestViewHolder>() {
    private var list: List<GuestModel> = arrayListOf()
    private lateinit var mListener: GuestListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_guest, parent, false)
        return GuestViewHolder(item, mListener)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateListGuest(guestList: List<GuestModel>) {
        list = guestList
        notifyDataSetChanged()
    }

    fun attachListener(listener: GuestListener){
        mListener = listener
    }
}