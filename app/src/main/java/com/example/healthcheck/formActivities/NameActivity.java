package com.example.healthcheck.formActivities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.core.app.ActivityCompat;

import com.example.healthcheck.BaseActivity;
import com.example.healthcheck.adapters.ImageAdapter;
import com.example.healthcheck.R;
import com.example.healthcheck.data.Person;
import com.google.android.material.textfield.TextInputEditText;

public class NameActivity extends BaseActivity {

    public static final String APP_TAG = "NameActivityMyMyApp";

    // List of permissions
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

        // open popup
        imgButtonAvatar.setOnClickListener(view -> createDialog());

        btnStart.setOnClickListener(view -> gotoNextActivity(IAmActivity.class));
        displaySavedPersons();

        verifyStoragePermissions(this);

        animatePop(imgButtonAvatar);
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
        int permission = ActivityCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
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
        // grid part
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridViewAvatar.setAdapter(imageAdapter);
        gridViewAvatar.setOnItemClickListener((adapterView, view, i, l) ->  {
                imgButtonAvatar.setImageResource(imageAdapter.getImg(i));
                person.setAvatar(imageAdapter.getImg(i));
                dialog.dismiss();
        });

        dialogBuilder.setView(popUpAvatar);
        dialog = dialogBuilder.create();
        dialog.show();

        btnAvatarPopup.setOnClickListener(view -> dialog.dismiss());
    }


}