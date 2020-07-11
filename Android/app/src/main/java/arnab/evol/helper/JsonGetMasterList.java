package arnab.evol.helper;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import arnab.evol.general.common;

import static java.util.Objects.isNull;

public class JsonGetMasterList {
    public JsonGetMasterList(final Context context, String url, JSONArray param, LinearLayout viewList, String ID, String Name, View.OnClickListener onclickListener)
    {
        final JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, param,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(JSONArray jsonArray)
                    {
                        if(jsonArray !=null) {
                            Log.e(Name + " List Found",jsonArray.toString());
                            //common.ShowToast(inflater.getContext(), "Record found");

                            viewList.removeAllViews();

                            for(int j=0; j < jsonArray.length(); j++)
                            {
                                try {
                                    JSONObject json = jsonArray.getJSONObject(j);
                                    if(!isNull(json))
                                    {
                                        Log.e(Name + " Master Data",json.toString());

                                        TextView textViewStudentItem= new TextView(context);
                                        textViewStudentItem.setPadding(0, 10, 0, 10);
                                        textViewStudentItem.setText(json.getString(Name));
                                        textViewStudentItem.setTag(json.getString(ID));
                                        textViewStudentItem.setClickable(true);
                                        textViewStudentItem.setOnClickListener(onclickListener);
                                        viewList.addView(textViewStudentItem);


                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    common.ShowToast(context, e.toString());
                                }
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        common.ErrorLog("JsonGetMasterList",
                                        "Error: " + error
                                        + ">>" + error.getCause()
                                        + ">>" + error.getMessage());
                    }
                });

        RequestQueue requestQueue = vollyhelper.getInstance(context).getRequestQueue();
        vollyhelper.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}