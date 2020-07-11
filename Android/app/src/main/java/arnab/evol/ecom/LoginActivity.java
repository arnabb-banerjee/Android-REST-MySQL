package arnab.evol.ecom;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.StringPostRequest;
import arnab.evol.helper.VolleyStringResponseListener;

public class LoginActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if(!Objects.isNull(common.GetLoggedUserInfo(this.getApplicationContext()).getUser_coe()))
        {
            if(common.GetLoggedUserInfo(this).getUser_type().equals("S")){
                Intent intent = new Intent(getBaseContext(), SellerAccountActivity.class);
                startActivity(intent);
            }
            else if(common.GetLoggedUserInfo(this).getUser_type().equals("B")){
                Intent intent = new Intent(getBaseContext(), BuyerAccountActivity.class);
                startActivity(intent);
            }
        }
    }

    public void Login_onClick(View v) {

        HashMap<String, String> item = new HashMap<String, String>();

        try {
            item.put("UserName", ((EditText) findViewById(R.id.username)).getText().toString());
            item.put("Password", ((EditText) findViewById(R.id.password)).getText().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        if(getIntent().getIntExtra("clicked_by", -1) == R.id.menuadmin)
        {
            Intent intent = new Intent(getBaseContext(), admin_account.class);
            startActivity(intent);
        }

        StringPostRequest jsonPostArrayRequest = new StringPostRequest(v.getContext(), serviceurls.Login_User, item, new VolleyStringResponseListener() {
            @Override
            public void onVolleySuccess(String strvalue) {
                Log.e("Seller Login", strvalue);

                try {
                    JSONObject obj = new JSONObject(strvalue);
                    common.ShowToast(v.getContext(), "User Session not Avalilable");
                    common.SetLoggedUserInfo(v.getContext(),
                            obj.getString("user_type"),
                            obj.getString("user_code"),
                            obj.getString("email"),
                            obj.getString("mobile"),
                            "",
                            "");

                    Log.e("Login:", "User Session Avalilable");
                    if(obj.getString("user_type").equals("B")) {
                        Log.e("Login:", "Buyer user");
                        Intent intent = new Intent(getBaseContext(), BuyerAccountActivity.class);
                        startActivity(intent);
                    }
                    else if(obj.getString("user_type").equals("S")) {
                        Log.e("Login:", "Buyer seller");
                        Intent intent = new Intent(getBaseContext(), SellerAccountActivity.class);
                        startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onVolleyFailure(String ErrorMessage) { Log.e("Credential-Error:", ErrorMessage); }
        });
            //Login Logic will go here

    }

    public void btnOpenregister_onClick(View v) {
        /*LayoutInflater factory = LayoutInflater.from(this);
        View titleView = factory.inflate(R.layout.user_registration, null);

        AlertDialog.Builder adb = new AlertDialog.Builder(this)
                .setCustomTitle(titleView);

        adb.show();*/

        common.ShowToast(getApplicationContext(), getIntent().getStringExtra("UserType"));
        if(getIntent().getStringExtra("UserType").equals("S")) {
            Intent intent = new Intent(getBaseContext(), Registration.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(getBaseContext(), BuyerRegistration.class);
            startActivity(intent);
        }
    }
}
