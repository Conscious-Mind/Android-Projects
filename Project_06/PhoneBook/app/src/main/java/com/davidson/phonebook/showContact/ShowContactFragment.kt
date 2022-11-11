package com.davidson.phonebook.showContact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.davidson.phonebook.ContactDatabase
import com.davidson.phonebook.R
import com.davidson.phonebook.databinding.FragmentShowContactBinding

class ShowContactFragment : Fragment() {
    private var _binding: FragmentShowContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowContactBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = ContactDatabase.getInstance(application).contactDao
        val viewModelFactory = ShowContactViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(ShowContactViewModel::class.java)

        binding.showConViewModel = viewModel
//        viewModel.contactsString.observe(
//            viewLifecycleOwner, Observer {
////                Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
//                binding.contacts.text t= it
//            }
//        )
        binding.lifecycleOwner = this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener { addContacts() }
    }

    private fun addContacts() {
        findNavController().navigate(R.id.action_showContactFragment_to_addContactFragment)
    }
}