package com.zikozee.tabianconsulting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NewDepartmentDialog extends DialogFragment {

    private static final String TAG = "NewDepartmentDialog";

    //widgets
    private EditText mNewDepartment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_department, container, false);
        mNewDepartment = (EditText) view.findViewById(R.id.input_new_department);

        TextView confirmDialog = (TextView) view.findViewById(R.id.dialogConfirm);
        confirmDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty(mNewDepartment.getText().toString())){
                    Log.d(TAG, "onClick: adding new department to the list.");
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                    reference
                            .child(getString(R.string.dbnode_departments))
                            .child(mNewDepartment.getText().toString())
                            .setValue(mNewDepartment.getText().toString()).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, e.getLocalizedMessage());
                        }
                    });
                    getDialog().dismiss();

                    ((AdminActivity)getActivity()).getDepartments();
                }
            }
        });

        return view;
    }

    /**
     * Return true if the @param is null
     * @param string
     * @return
     */
    private boolean isEmpty(String string){
        return string.equals("");
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        checkAuthenticationState();
//    }
//
//    private void checkAuthenticationState(){
//        Log.d(TAG, "checkAuthenticationState: checking authentication state.");
//
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//
//        if(user == null){
//            Log.d(TAG, "checkAuthenticationState: user is null, navigating back to login screen.");
//
//            NewDepartmentDialog departmentDialog = new NewDepartmentDialog();
//            departmentDialog.dismiss();
//        }else{
//            Log.d(TAG, "checkAuthenticationState: user is authenticated.");
//        }
//    }
}

















