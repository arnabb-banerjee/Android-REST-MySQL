package arnab.evol.helper;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import arnab.evol.general.common;

public class JsonPostObjectRequest {
    private JSONArray JsonResponse;

    public JSONArray getJSONResponse() {
        return JsonResponse;
    }

    public JsonPostObjectRequest(final Context context, String url, JSONObject param, final VolleyJsonObjectResponseListener volleyResponseListener)
    {
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, param,
                new Response.Listener<JSONObject>() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onResponse(JSONObject response)
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
                        common.ErrorLog("JsonPostObjectRequest",
                                "Error: " + error
                                        + ">>" + error.getCause()
                                        + ">>" + error.getMessage());

                    }
                });

        RequestQueue requestQueue = vollyhelper.getInstance(context).getRequestQueue();
        vollyhelper.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }
}