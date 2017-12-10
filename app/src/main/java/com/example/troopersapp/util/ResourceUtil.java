package com.example.troopersapp.util;

import android.widget.Switch;

import com.example.troopersapp.R;
import com.example.troopersapp.model.Affiliation;

/**
 * Created by lslopes on 18/11/2017.
 */

public class ResourceUtil {

    public static int getResourceBasedOnAffiliation(Affiliation affiliation) {
        switch (affiliation) {
            case GALACT_REPUBLIC:
                return R.drawable.galactic_republic;
            case GALACTIC_EMPIRE:
                return R.drawable.galactic_empire;
            case FIRST_ORDER:
                return R.drawable.first_order;
            default:
                return 0;
        }
    }

}
