package arnab.evol.ecom;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.StringPostRequest;
import arnab.evol.helper.VolleyStringResponseListener;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void Registration_onClick(View v) {
        if(((EditText)findViewById(R.id.shop_name)).getText().toString().isEmpty()){
            ((EditText)findViewById(R.id.shop_name)).setError("Please enter Shop Name");
        }
        if(((EditText)findViewById(R.id.mobile)).getText().toString().isEmpty()){
            ((EditText)findViewById(R.id.mobile)).setError("Please enter Mobile number");
        }
        if(((EditText)findViewById(R.id.email)).getText().toString().isEmpty()){
            ((EditText)findViewById(R.id.email)).setError("Please enter Email Address");
        }
        if(((EditText)findViewById(R.id.password)).getText().toString().isEmpty()){
            ((EditText)findViewById(R.id.password)).setError("Please enter Password");
        }

        HashMap<String, String> params = new HashMap<String, String>();
        params.put("user_type", "S");
        params.put("shop_name", ((EditText)findViewById(R.id.shop_name)).getText().toString());
        params.put("mobile", ((EditText)findViewById(R.id.mobile)).getText().toString());
        params.put("email", ((EditText)findViewById(R.id.email)).getText().toString());
        params.put("Password", ((EditText)findViewById(R.id.password)).getText().toString());

        common.ShowToast(v.getContext(), params.toString());

        StringPostRequest req = new StringPostRequest(this.getApplicationContext(), serviceurls.Registration_User, params, new VolleyStringResponseListener() {
            @Override
            public void onVolleySuccess(String sArray) {
                common.ShowToast(v.getContext(), sArray);
            }

            @Override
            public void onVolleyFailure(String ErrorMessage) {
                common.ShowToast(v.getContext(), ErrorMessage);
            }
        });
    }

    /*public void Registration_onClick(View v) throws IOException {
        String url= common.ServiceUrl + "saap/sellerlogin/save";

        final StringRequest jsonObjectRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("Rest Response", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        common.ShowToast(getApplicationContext(), "error place 4: "+ ">>" + (error.networkResponse==null?"":error.networkResponse.statusCode+"") + error);
                    }
                })
        {

            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("shop_name", "Arnab");
                params.put("mobile", "adhksa");
                params.put("email", "lkdfls");
                params.put("Password", "lasfkdjlsfks");

                return params;
            }
        };

        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = vollyhelper.getInstance(this.getApplicationContext()).getRequestQueue();
        vollyhelper.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }*/

    public void btnCancel_onClick(View v)
    {

    }
}
