package es.schooleando.ejercicio2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button botonDescarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonDescarga = (Button)findViewById(R.id.botonDescarga);
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

        //Instancio mi clase DescargaAsyncTask para ejecutar la tarea (espera y actualización del botón) en el background thread.
        //Paso al constructor esta activity Main y el botón para poder actualizarlo
        DescargaAsyncTask descargaAsync = new DescargaAsyncTask(this, botonDescarga);
        descargaAsync.execute("Descargar");
    }

}
