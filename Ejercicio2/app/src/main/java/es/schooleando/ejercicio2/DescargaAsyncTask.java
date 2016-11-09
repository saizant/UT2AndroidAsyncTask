package es.schooleando.ejercicio2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;

/**
 * Creado por Antonio Sáiz. Fecha: 09/11/2016.
 */

public class DescargaAsyncTask extends AsyncTask<String, Integer, String[]> {

    private Activity activity;
    private Button botonDescarga;

    //En el constructor de esta clase AsyncTask, recibo la activity Main y el botón para poder actualizarlo
    public DescargaAsyncTask(Activity activity, Button botonDescarga) {
        this.activity = activity;
        this.botonDescarga = botonDescarga;
    }

    @Override
    protected String[] doInBackground(String... strings) {

        //Realizo la tarea de espera en este background thread
        SystemClock.sleep(10000);

        return new String[0];
    }

    @Override
    protected void onPostExecute(String[] strings) {

        //Actualizo el botón después de ejecutar la tarea del background thread
        botonDescarga.setText("Descargado!");
        botonDescarga.setEnabled(false);
    }
}
