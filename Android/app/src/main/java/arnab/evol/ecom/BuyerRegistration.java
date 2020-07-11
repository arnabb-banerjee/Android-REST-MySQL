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

public class BuyerRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_registration);
    }

    public void Registration_onClick(View v) {
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

        params.put("user_type", "B");
        params.put("shop_name", "");
        params.put("mobile", ((EditText)findViewById(R.id.mobile)).getText().toString());
        params.put("email", ((EditText)findViewById(R.id.email)).getText().toString());
        params.put("Password", ((EditText)findViewById(R.id.password)).getText().toString());
        common.ShowToast(v.getContext(), params.toString());

        try {
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
        catch (Exception ex) {
            common.ShowToast(this.getApplicationContext(), ex.toString());
        }
    }

}
