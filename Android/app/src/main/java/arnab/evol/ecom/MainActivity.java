package arnab.evol.ecom;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.JsonGetArrayRequest;
import arnab.evol.helper.VolleyJsonArrayResponseListener;

import static java.util.Objects.isNull;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Button btnProductCreateButtn = (Button) findViewById(R.id.btnCreateButtn);
        btnProductCreateButtn.setOnClickListener(new OpenNewProductForm());*/
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        //Mention: android:usesCleartextTraffic="true" in Android Manifest
        //Mention: <uses-permission android:name="android.permission.INTERNET" /> in Android Manifest
        //Mention: Change the URL: http://10.0.2.2 instead of http://127.0.0.1 Because Android emulator runs in a Virtual Machine therefore here 127.0.0.1 or localhost will be emulator's own loopback address
        //RequestQueue req = Volley.newRequestQueue(this);

        ((Button)findViewById(R.id.btnBusinessUser)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(), LoginActivity.class);
                intent.putExtra("UserType", "S");
                startActivity(intent);
            }
        });

        Context context=this.getApplicationContext();
        JSONArray response = new JSONArray();
        new JsonGetArrayRequest(this.getApplicationContext(), serviceurls.Product_Select, null, new VolleyJsonArrayResponseListener(){
            @Override
            public void onVolleySuccess(JSONArray response)
            {
                if(response !=null) {
                    common.ShowToast(context, "Record found");
                    GridLayout viewList = (GridLayout) findViewById(R.id.grdProductsBuyer);
                    viewList.removeAllViews();

                    int total = response.length();
                    int cols = common.NoOfProductsInARow_MainPage;
                    int rows = total/cols;

                    viewList.setColumnCount(cols);
                    viewList.setRowCount(rows+1);

                    for(int j=0, c=0, r=0; j < total; j++, c++)
                    {
                        if(c == cols) {
                            c = 0;
                            r++;
                        }
                        try {
                            JSONObject json = response.getJSONObject(j);
                            if(isNull(json))
                            {
                                Log.e("Main Activity response",json.toString());

                                //View cView = new View(MainActivity.this);
                                //oImageView.setImageResource(R.drawable.ic_launcher);
                                GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                                param.height = GridLayout.LayoutParams.WRAP_CONTENT;
                                param.width = GridLayout.LayoutParams.WRAP_CONTENT;
                                param.rightMargin = 5;
                                param.topMargin = 5;
                                param.setGravity(Gravity.CENTER);

                                param.columnSpec = GridLayout.spec(c);
                                param.rowSpec = GridLayout.spec(r);
                                //cView.setLayoutParams(param);

                                TextView viewName = new TextView(MainActivity.this);
                                TextView viewDesc = new TextView(MainActivity.this);
                                TextView viewCat = new TextView(MainActivity.this);
                                TextView viewBrand = new TextView(MainActivity.this);
                                viewDesc.setText(json.getString("prod_desc"));
                                viewName.setText(json.getString("prod_name"));
                                viewCat.setText(json.getString("cat_name"));
                                viewBrand.setText(json.getString("brand_name"));
                                viewList.addView(viewCat);
                                viewList.addView(viewBrand);
                                viewList.addView(viewName);
                                viewList.addView(viewDesc);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            common.ShowToast(MainActivity.this, e.toString());
                        }
                    }

                }
            }

            @Override
            public void onVolleyFailure(String ErrorMessage) {
                Log.e("Callback JSON Error", ErrorMessage);
            }
        });
        if(response !=null) {
            common.ShowToast(this.getApplicationContext(), "Record found");
            GridLayout viewList = (GridLayout) findViewById(R.id.grdProductsBuyer);
            viewList.removeAllViews();

            int total = response.length();
            int cols = common.NoOfProductsInARow_MainPage;
            int rows = total/cols;

            viewList.setColumnCount(cols);
            viewList.setRowCount(rows+1);

            for(int j=0, c=0, r=0; j < total; j++, c++)
            {
                if(c == cols) {
                    c = 0;
                    r++;
                }
                try {
                    JSONObject json = response.getJSONObject(j);
                    if(isNull(json))
                    {
                        Log.e("Main Activity response",json.toString());

                        //View cView = new View(MainActivity.this);
                        //oImageView.setImageResource(R.drawable.ic_launcher);
                        GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                        param.height = GridLayout.LayoutParams.WRAP_CONTENT;
                        param.width = GridLayout.LayoutParams.WRAP_CONTENT;
                        param.rightMargin = 5;
                        param.topMargin = 5;
                        param.setGravity(Gravity.CENTER);

                        param.columnSpec = GridLayout.spec(c);
                        param.rowSpec = GridLayout.spec(r);
                        //cView.setLayoutParams(param);

                        TextView viewName = new TextView(MainActivity.this);
                        TextView viewDesc = new TextView(MainActivity.this);
                        TextView viewCat = new TextView(MainActivity.this);
                        TextView viewBrand = new TextView(MainActivity.this);
                        viewDesc.setText(json.getString("prod_desc"));
                        viewName.setText(json.getString("prod_name"));
                        viewCat.setText(json.getString("cat_name"));
                        viewBrand.setText(json.getString("brand_name"));
                        viewList.addView(viewCat);
                        viewList.addView(viewBrand);
                        viewList.addView(viewName);
                        viewList.addView(viewDesc);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    common.ShowToast(MainActivity.this, e.toString());
                }
                            /*
                            List<ProductInfo> list = new ArrayList<ProductInfo>();
                            ProductInfo obj= null;


                            for(int i = 0; i < response.length(); i++)
                            {
                                try {
                                    JSONObject json = response.getJSONObject(i);
                                    if(isNull(json))
                                    {
                                        obj=new ProductInfo();
                                        obj.setDescription(json.getString("prod_desc"));
                                        obj.setProd_name(json.getString("prod_name"));
                                        obj.setBrand_name(json.getString("brand_name"));
                                        obj.setCategory(json.getString("cat_name"));
                                        list.add(obj);
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    common.ShowToast(MainActivity.this, e.toString());
                                }
                            }*/
        }
        //setContentView(viewList);

    }

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "arnab banerjee", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement

        if (item.getItemId() == R.id.menubuyer ||
                item.getItemId() == R.id.menuadmin ) {
            /*
            LayoutInflater factory = LayoutInflater.from(this);
            View titleView = factory.inflate(R.layout.login, null);

            AlertDialog.Builder adb = new AlertDialog.Builder(this)
                    .setCustomTitle(titleView);

            adb.show();*/

            Intent intent=new Intent(getBaseContext(), LoginActivity.class);
            intent.putExtra("clicked_by", item.getItemId());
            startActivity(intent);
        }

        return true;
    }

}
