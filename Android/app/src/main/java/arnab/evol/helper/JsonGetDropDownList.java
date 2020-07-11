package arnab.evol.helper;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import arnab.evol.general.common;

public class JsonGetDropDownList {
    HashMap<String, String> KeyValueMap = new HashMap<String, String>();

    public JsonGetDropDownList(final Context context, String url, JSONArray param, Spinner spinner, String Key, String Value)
    {
        final JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, param,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(JSONArray jsonArray)
                    {
                        try {
                            if(jsonArray !=null) {
                                Log.e(Value+" List Found", jsonArray.toString());
                                List<String> brad_names = new ArrayList<String>();
                                int icount = 0;
                                for (int j = 0; j < jsonArray.length(); j++) {

                                    if (jsonArray.getJSONObject(j).has(Value) && jsonArray.getJSONObject(j).has(Key)) {
                                        brad_names.add(jsonArray.getJSONObject(j).getString(Value));
                                        KeyValueMap.put(jsonArray.getJSONObject(j).getString(Key), jsonArray.getJSONObject(j).getString(Value));
                                        icount++;
                                    }
                                }

                                if(icount > 0) {
                                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, brad_names);
                                    spinner.setAdapter(adapter);


                                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                        @Override
                                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                            spinner.setTag(KeyValueMap.keySet().toArray()[position]);
                                            /*common.ShowToast(context, spinner.getTag().toString());*/
                                        }

                                        @Override
                                        public void onNothingSelected(AdapterView<?> parent) {

                                        }
                                    });
                                }
                            }
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        common.ErrorLog("JsonGetDropdownList",
                                "Error: " + error
                                        + ">>" + error.getCause()
                                        + ">>" + error.getMessage());

                    }
                });

        RequestQueue requestQueue = vollyhelper.getInstance(context).getRequestQueue();
        vollyhelper.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }


}