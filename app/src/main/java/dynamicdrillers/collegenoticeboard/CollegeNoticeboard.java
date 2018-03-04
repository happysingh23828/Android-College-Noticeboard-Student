package dynamicdrillers.collegenoticeboard;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

/**
 * Created by Happy-Singh on 3/4/2018.
 */

public class CollegeNoticeboard extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if(!checkInternetConnection())
        {
            Toast.makeText(this,"Your Have No Internet Connection", Toast.LENGTH_SHORT).show();
        }



    }


    private boolean checkInternetConnection() {
        ConnectivityManager cm = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        // Test for connection
        if (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        }
        else {
            return false;
        }
    }
}