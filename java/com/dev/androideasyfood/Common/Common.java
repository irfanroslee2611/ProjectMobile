package com.dev.androideasyfood.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.dev.androideasyfood.Model.Request;
import com.dev.androideasyfood.Model.User;

/**
 * Created by user on 10/19/2017.
 */

public class Common {
    public static User currentUser;
    public static Request currentRequest;

//    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";
    public static final String USER_KEY = "User";
    public static final String PWD_KEY = "Password";


    public static String convertCodeToStatus(String code)
    {
        if(code.equals("0"))
            return "Order Received";
        else if(code.equals("1"))
            return "Prepared";
        else
            return "Out Of Stock";
    }

    public static boolean isConnectedToInternet(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if(connectivityManager != null)
        {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if(info != null)
            {
                for (int i=0;i<info.length;i++)
                {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED)
                        return true;
                }
            }
        }
        return false;
    }
}
