package com.example.healthcheck;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.core.app.ActivityCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NameActivity extends BaseActivity {
    // in Logcat : (MainApp)|(IAMApp)|(MyHeartApp)
    public static final String APP_TAG = "NameActivityApp";

    // Listes des permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private TextInputEditText txtiputeditName;
    private Button btnStart;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private ImageButton imgButtonAvatar;
    private Button btnAvatarPopup;
    private GridView gridViewAvatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        btnAvatarPopup = findViewById(R.id.btnAvatarPopup);

        init();
    }

    private void init() {

        person = new Person();
        btnStart = findViewById(R.id.btnStartTest);
        txtiputeditName = findViewById(R.id.txtiputeditName);
        imgButtonAvatar = findViewById(R.id.imgButtonAvatar);


        //ouvre la popup lorqu'on clique sur l'image
        imgButtonAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialog();
            }
        });

        btnStart.setOnClickListener(view -> gotoNextActivity(IAmActivity.class));
        //Log.i(APP_TAG, "Name ----- reloadSavedPersons");
        reloadSavedPersons();
        //Log.i(APP_TAG, "Name ----- displaySavedPersons");
        displaySavedPersons();

        verifyStoragePermissions(this);
    }

    @Override
    protected boolean validateWidgetsAndAffectPersonData() {
        // check name
        String name = txtiputeditName.getText().toString();
        if(TextUtils.isEmpty(name)) {
            return handleError(getString(R.string.txterror), txtiputeditName);
        }
        person.setName(name);

        return true;
    }

    public static void verifyStoragePermissions(Activity activity) {
        // Vérifie si nous avons les droits d'écriture
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // Aie, il faut les demander àl'utilisateur
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    public void createDialog(){
        //pop up dialogue

        dialogBuilder = new AlertDialog.Builder(this);
        final View popUpAvatar = getLayoutInflater().inflate(R.layout.avatar_popup,null);
        btnAvatarPopup = popUpAvatar.findViewById(R.id.btnAvatarPopup);

        gridViewAvatar = popUpAvatar.findViewById(R.id.gridViewAvatar);
        //partie de la grid
        gridViewAvatar.setAdapter(new ImageAdapter(this));
        gridViewAvatar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               // ImageAdapter imageAdapter = new ImageAdapter(NameActivity.this);

            }
        });


        dialogBuilder.setView(popUpAvatar);
        dialog = dialogBuilder.create();
        dialog.show();


        btnAvatarPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }


}