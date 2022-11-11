package com.davidson.phonebook.addcontact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.davidson.phonebook.ContactDatabase
import com.davidson.phonebook.R
import com.davidson.phonebook.databinding.FragmentAddContactBinding

class AddContactFragment : Fragment() {

    private var _binding: FragmentAddContactBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = ContactDatabase.getInstance(application).contactDao
        val viewModelFactory = AddContactViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(AddContactViewModel::class.java)

        binding.addConViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.showButton.setOnClickListener{showContactList()}
    }

    private fun showContactList() {
        findNavController().navigate(R.id.action_addContactFragment_to_showContactFragment)
    }
}