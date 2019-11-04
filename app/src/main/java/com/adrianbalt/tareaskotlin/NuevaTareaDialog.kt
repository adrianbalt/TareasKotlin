package com.adrianbalt.tareaskotlin

import android.app.ActionBar
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class NuevaTareaDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            val inflater:LayoutInflater = requireActivity().layoutInflater;
            val view:View = inflater.inflate(R.layout.fragment_nueva_tarea_dialog, null)
            val editText2 = view.findViewById<EditText>(R.id.editText2)
            builder
                .setView(view)
                .setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire,
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        dialog?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
    }

}
