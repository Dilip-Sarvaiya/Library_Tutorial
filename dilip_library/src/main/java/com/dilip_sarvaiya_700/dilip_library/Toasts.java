package com.dilip_sarvaiya_700.dilip_library;

import android.content.Context;
import android.widget.Toast;

public class Toasts {
    public static void simpleToast (Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
