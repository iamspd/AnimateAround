package com.iamspd.animatearound;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.iamspd.animatearound.fragments.EarthMoonFragment;
import com.iamspd.animatearound.fragments.FramedFragment;

public class MainActivity extends AppCompatActivity {

    // widgets
    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomNavigationView = findViewById(R.id.bottomNavBar);
        mBottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
    }

    /**
     * method to handle the back press event on home screen
     *  it will prompt an {@link AlertDialog} on a single press with two options
     *  and will operate according to the selection user opts out for
     */
    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // title of the AlertDialog
        builder.setTitle(R.string.alert_title);

        // icon of the AlertDialog
        builder.setIcon(R.drawable.ic_alert);

        // message of the AlertDialog
        builder.setMessage(R.string.alert_message);

        // selecting this button will get user out of the application
        builder.setPositiveButton(R.string.alert_yes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                MainActivity.super.onBackPressed();
            }
        });

        // selecting this button will dismiss the AlertDialog and stays on the main screen
        builder.setNegativeButton(R.string.alert_no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    // listener handles the BottomNavigationView item click calls
    //  which fragment to initialize on FrameLayout
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.menuItem1:
                            selectedFragment = new FramedFragment();
                            break;

                        case R.id.menuItem2:
                            selectedFragment = new EarthMoonFragment();
                            break;

                    }

                    // replaces and inflates the Fragment Layout on to the FrameLayout
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                            selectedFragment).commit();
                    return true;
                }
            };
}