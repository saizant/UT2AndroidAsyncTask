package es.schooleando.beeradviser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);

        // Simulamos una tarea larga (acceso a la red, cálculo, base de datos) y forzamos un ANR.
        // Nunca debemos hacer esto en el UI Thread!

        //Tarea larga de espera simulada en el background thread (clase FindBeerAsyncTask), para no bloquear este UI thread
        //SystemClock.sleep(14000);

        //Instancio la CLASE FindBeerAsyncTask para EJECUTAR la tarea larga de espera en el background thread
        FindBeerAsyncTask findBeer = new FindBeerAsyncTask();
        findBeer.execute("Obtener marcas de cerveza");

        String beerType = String.valueOf(color.getSelectedItem());
        List<String> brandList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand: brandList) {
            brandsFormatted.append(brand).append("\n");
        }
        brands.setText(brandsFormatted);



    }
}
