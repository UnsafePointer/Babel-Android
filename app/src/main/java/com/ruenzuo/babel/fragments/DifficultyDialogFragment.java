package com.ruenzuo.babel.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.ruenzuo.babel.models.enums.DifficultyType;

/**
 * Created by renzocrisostomo on 21/08/14.
 */
public class DifficultyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setSingleChoiceItems(DifficultyType.difficultyTypes(), -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return super.onCreateDialog(savedInstanceState);
    }

}