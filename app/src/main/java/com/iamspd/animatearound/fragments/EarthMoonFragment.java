package com.iamspd.animatearound.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.iamspd.animatearound.R;

public class EarthMoonFragment extends Fragment {

    // widgets
    private ImageView fAnimMoon, fAnimEarth;
    private Button fBtnStart, fBtnStop;

    /**
     * method to provide a fragment view on the screen
     *
     * @param inflater           inflates the layout to the fragment
     * @param container          the view where the layout is going to be inflated
     * @param savedInstanceState state of the layout at which it is inflated
     * @return view on the screen
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_framed, container, false);
    }

    /**
     * method to handle operations on view
     * starts and stops the animation from the {@link AnimationUtils}
     * based on the user click
     *
     * @param rootView           is where the actual view is created
     * @param savedInstanceState state of the view at a time
     */

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);

        fAnimMoon = rootView.findViewById(R.id.ivMoon);
        final Animation revolveMoon = AnimationUtils.loadAnimation(getActivity(), R.anim.tween_revolve);
        fAnimMoon.startAnimation(revolveMoon);


        fAnimEarth = rootView.findViewById(R.id.ivEarth);
        final Animation rotateEarth = AnimationUtils.loadAnimation(getActivity(), R.anim.tween_rotate);
        fAnimEarth.startAnimation(rotateEarth);

        fBtnStart = rootView.findViewById(R.id.btnAnimStart);
        fBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAnimEarth.startAnimation(rotateEarth);
                fAnimMoon.startAnimation(revolveMoon);
            }
        });

        fBtnStop = rootView.findViewById(R.id.btnAnimStop);
        fBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAnimEarth.clearAnimation();
                rotateEarth.cancel();

                fAnimMoon.clearAnimation();
                revolveMoon.cancel();

            }
        });
    }
}
