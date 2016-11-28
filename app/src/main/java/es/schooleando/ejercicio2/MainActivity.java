package es.schooleando.ejercicio2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button botonDescarga;
    private ProgressBar progress;
    private TextView texto;
    private DescargaAsyncTask descargaAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Engancho las vistas
        botonDescarga = (Button)findViewById(R.id.botonDescarga);
        progress = (ProgressBar)findViewById(R.id.progress);
        texto = (TextView)findViewById(R.id.texto);
    }

    public void onClickBotonDescarga(View view) {

       //No podemos modificar el botón desde otro thread!
        /*new Thread(new Runnable() {

            @Override
            public void run() {
                sleep(10000);
                botonDescarga.setText("Descargado!");
                botonDescarga.setEnabled(false);
            }

        }).start();*/

        //Según cuando se pulse, ejecuto la DescargaAsyncTask o la cancelo
        if (botonDescarga.getText().equals("Descargar")) {
            //Cambio el texto que muestra el botón
            botonDescarga.setText("Cancelar");

            //Instancio mi clase DescargaAsyncTask para ejecutar la tarea (espera y actualización del botón) en el background thread.
            //Paso al constructor esta activity Main y el botón para poder actualizarlo
            descargaAsync = new DescargaAsyncTask(this, botonDescarga);
            descargaAsync.execute("Descargar");

        } else if (botonDescarga.getText().equals("Cancelar")) {
            //Cambio el texto que muestra el botón
            botonDescarga.setText("Cancelando...");

            //Deshabilito el botón y cancelo la DescargaAsyncTask
            botonDescarga.setEnabled(false);
            descargaAsync.cancel(true);
        }

    }

}
