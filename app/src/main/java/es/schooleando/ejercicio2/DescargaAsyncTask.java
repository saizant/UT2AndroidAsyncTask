package es.schooleando.ejercicio2;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Creado por Antonio Sáiz. Fecha: 09/11/2016.
 */

public class DescargaAsyncTask extends AsyncTask<String, Integer, String[]> {

    private Activity activity;
    private Button botonDescarga;

    private ProgressBar progreso;
    private TextView texto;

    //En el constructor de esta clase AsyncTask, recibo la activity Main y el botón para poder actualizarlo
    public DescargaAsyncTask(Activity activity, Button botonDescarga) {
        this.activity = activity;
        this.botonDescarga = botonDescarga;

        //(Otra forma de interactuar: en lugar de recibir vistas en el constructor, las instancio mediante la Activity)
        progreso = (ProgressBar)activity.findViewById(R.id.progress);
        texto = (TextView)activity.findViewById(R.id.texto);
    }

    @Override
    protected String[] doInBackground(String... strings) {

        //Realizo la tarea de espera y progreso en este background thread
        for (int i = 1; i < 101; i++) {
            SystemClock.sleep(100);
            publishProgress(i);

            if (isCancelled()) {
                //Si se cancela simula una espera
                SystemClock.sleep(3000);
                break;
            }
        }

        return new String[0];
    }

    @Override
    protected void onPostExecute(String[] strings) {

        //Actualizo el botón y el progreso después de ejecutar la tarea del background thread
        Toast.makeText(activity, "Descarga realizada", Toast.LENGTH_SHORT).show();
        botonDescarga.setText("Descargar");
        botonDescarga.setEnabled(true);
        progreso.setProgress(0);
        texto.setText("");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //Actualizar barra de progreso y texto:
        progreso.setProgress(values[0]);
        texto.setText(values[0] + "/100");
    }

    @Override
    protected void onCancelled() {
        //Actualizo el botón y el progreso si se cancela
        Toast.makeText(activity, "Descarga cancelada", Toast.LENGTH_SHORT).show();
        botonDescarga.setText("Descargar");
        botonDescarga.setEnabled(true);
        progreso.setProgress(0);
        texto.setText("");
    }
}
