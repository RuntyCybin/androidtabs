package cybin.cybinapptabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup tipo_agente_rg;
    RadioButton responsable_rb, superior_rb, agente_rb;
    LinearLayout fragmentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipo_agente_rg = (RadioGroup) findViewById(R.id.radioTipoAgente);
        superior_rb = (RadioButton) findViewById(R.id.rdsuperior);
        responsable_rb = (RadioButton) findViewById(R.id.rdresponsable);
        agente_rb = (RadioButton) findViewById(R.id.rdagente);
        fragmentLayout = (LinearLayout) findViewById(R.id.layout_contenido);
        radioButtonsListener();
    }

    public void radioButtonsListener(){
        responsable_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        responsable_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        superior_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        superior_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        agente_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        agente_rb.setTextColor(getResources().getColor(R.color.colorPrimary));

        // seteamos el fragment por defecto
        try {
            fragmentLayout.removeAllViews();
        } catch (Exception e){}
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setId(R.id.titleId);
        getFragmentManager().beginTransaction().add(
                linearLayout.getId(),
                TestFragment.newInstance("ESCENARIO AGENTE CARGADO"),
                "someTAG").commit();
        fragmentLayout.addView(linearLayout);

        tipo_agente_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdagente){
                    agente_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    agente_rb.setTextColor(getResources().getColor(R.color.colorPrimary));
                    responsable_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    responsable_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    superior_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    superior_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    // seteamos el fragment
                    try {
                        fragmentLayout.removeAllViews();
                    } catch (Exception e){}
                    LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                    linearLayout.setId(R.id.titleId);
                    getFragmentManager().beginTransaction().add(
                            linearLayout.getId(),
                            TestFragment.newInstance("ESCENARIO AGENTE CARGADO"),
                            "someTAG").commit();
                    fragmentLayout.addView(linearLayout);

                } else if(checkedId == R.id.rdresponsable){
                    responsable_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    responsable_rb.setTextColor(getResources().getColor(R.color.colorPrimary));
                    superior_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    superior_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    agente_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    agente_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    // seteamos el fragment
                    try {
                        fragmentLayout.removeAllViews();
                    } catch (Exception e){}
                    LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                    linearLayout.setId(R.id.imagenId);
                    getFragmentManager().beginTransaction().add(
                            linearLayout.getId(),
                            TestFragment2.newInstance("http://www.eventprophire.com/_images/products/large/tank_warning_circular_sign.jpg"),
                            "someTAG").commit();
                    fragmentLayout.addView(linearLayout);

                } else if(checkedId == R.id.rdsuperior){
                    superior_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    superior_rb.setTextColor(getResources().getColor(R.color.colorPrimary));
                    responsable_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    responsable_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                    agente_rb.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    agente_rb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                    // seteamos el fragment
                    try {
                        fragmentLayout.removeAllViews();
                    } catch (Exception e){}
                    LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                    linearLayout.setId(R.id.botonId);
                    getFragmentManager().beginTransaction().add(
                            linearLayout.getId(),
                            TestFragment.newInstance("ESCENARIO SUPERIOR CARGADO"),
                            "someTAG").commit();
                    fragmentLayout.addView(linearLayout);
                }
            }
        });
    }
}
