package es.schooleando.beeradviser;

import android.os.AsyncTask;
import android.os.SystemClock;

/**
 * Created by ruben on 17/10/16.
 */

public class FindBeerAsyncTask extends AsyncTask<String, Integer, String[]> {
    @Override
    protected String[] doInBackground(String... params) {

        //Se hace aquí la simulación de tarea larga de espera, en el background thread
        SystemClock.sleep(14000);

        return new String[0];
    }
}
