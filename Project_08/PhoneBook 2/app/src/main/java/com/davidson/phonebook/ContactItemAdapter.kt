package com.davidson.phonebook

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactItemAdapter: RecyclerView.Adapter<ContactItemAdapter.ContactItemViewHolder>() {
    var data = listOf<Contact>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ContactItemViewHolder = ContactItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ContactItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {

        val contactName = rootView.findViewById<TextView>(R.id.contact_name)
        val contactNumber = rootView.findViewById<TextView>(R.id.contact_number)

        companion object {
            fun inflateFrom(parent: ViewGroup) : ContactItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.contact_item, parent, false) as CardView
                return ContactItemViewHolder(view)
            }
        }

        fun bind(item: Contact) {
            contactName.text = item.contactName
            contactNumber.text = item.contactNumber
        }
    }
}

