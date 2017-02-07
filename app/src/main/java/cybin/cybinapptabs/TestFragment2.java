package cybin.cybinapptabs;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by SIONIN on 06/02/2017.
 */

public class TestFragment2 extends Fragment {
    Bitmap myBitmap = null;
    ImageView imageView;
    public static TestFragment2 newInstance(String rutaImagen) {
        TestFragment2 testFragment2 = new TestFragment2();
        Bundle bundle = new Bundle();
        bundle.putString("ruta", rutaImagen);
        testFragment2.setArguments(bundle);

        return testFragment2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        GetBitmap(getArguments().getString("ruta"), view); // recogemos la ruta y la asignamos a la variable bitmap


        return view;
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);

            return myBitmap;
        } catch (IOException e) {
            // Log exception
            return null;
        }
    }


    // RECOGEMOS LAS EMPRESAS Y LOS AGENTES SEGUN LA FECHA DE LA ULTIMA SINCRONIZACION
    public void GetBitmap(final String src, final View view) {
        new AsyncTask<Void, Integer, Void>() {


            @Override
            protected void onPreExecute() {

                System.out.println("RUTA: " + src);
            }
            @Override
            protected Void doInBackground(Void... arg0) {

                try {
                    URL url = new URL(src);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput(true);
                    connection.connect();
                    InputStream input = connection.getInputStream();
                    myBitmap = BitmapFactory.decodeStream(input);
                } catch (IOException e) {
                    System.out.println("ERROR: " + e);
                    return null;
                }
                return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                ((ImageView) view.findViewById(R.id.fragimg)).setImageBitmap(myBitmap); // setamos el bitmap
            }
        }.execute();
    }

}
