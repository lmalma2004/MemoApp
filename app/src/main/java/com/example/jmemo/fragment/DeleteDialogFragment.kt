package com.example.jmemo.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.jmemo.R
import com.example.jmemo.activity.EditActivity
import kotlinx.android.synthetic.main.dialog_input_uri.*

class DeleteDialogFragment : DialogFragment(){


    companion object{
        val DELETE_DIALOG = "delete_dialog"
        fun getInstance() : DeleteDialogFragment {
            val e = DeleteDialogFragment()
            return e
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.dialog_delete, container)
        val okButton = v.findViewById(R.id.okButton) as Button
        val cancelButton = v.findViewById(R.id.cancelButton) as Button

        okButton.setOnClickListener {
            val editActivity = activity as EditActivity
            editActivity.deleteMemo(editActivity.id)
            dismiss()
        }
        cancelButton.setOnClickListener {
            dismiss()
        }
        return v;
    }
}