package arnab.evol.helper;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import arnab.evol.general.common;

public class JsonGetArrayRequest {
    private JSONArray JsonResponse;

    public JSONArray getJSONResponse() {
        return JsonResponse;
    }

    public JsonGetArrayRequest(final Context context, String url, JSONArray param, final VolleyJsonArrayResponseListener volleyResponseListener)
    {
        final JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, param,
                new Response.Listener<JSONArray>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(JSONArray response)
                    {
                        try{
                            volleyResponseListener.onVolleySuccess(response);
                        }
                        catch (NullPointerException e){
                            volleyResponseListener.onVolleyFailure(e.toString());
                        }
                        catch (Exception e){
                            volleyResponseListener.onVolleyFailure(e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyResponseListener.onVolleyFailure("Error: " + error
                                        + ">>" + error.getCause()
                                        + ">>" + error.getMessage());
                        common.ErrorLog("JsonGetArrayList",
                                        "Error: " + error
                                        + ">>" + error.getCause()
                                        + ">>" + error.getMessage());
                    }
                });

        RequestQueue requestQueue = vollyhelper.getInstance(context).getRequestQueue();
        vollyhelper.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}