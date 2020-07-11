package arnab.evol.helper;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class StringPostRequest {
    public StringPostRequest(final Context context, String url, final HashMap<String, String> HashMapParams, final VolleyStringResponseListener volleyResponseListener) {
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
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
                    }
                })
        {

            @Override
            protected Map<String, String> getParams()
            {
                return HashMapParams;
            }
        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

            RequestQueue requestQueue = vollyhelper.getInstance(context).getRequestQueue();
            vollyhelper.getInstance(context).addToRequestQueue(stringRequest);
        }
        catch (Exception ex)
        {
            throw  ex;
        }
    }

}