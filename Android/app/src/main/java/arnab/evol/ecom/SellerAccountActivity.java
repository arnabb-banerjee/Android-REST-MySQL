package arnab.evol.ecom;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import arnab.evol.general.common;

import static java.util.Objects.isNull;

public class SellerAccountActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_account);

        if(isNull(common.GetLoggedUserInfo(this).getUser_coe()) || (
                !isNull(common.GetLoggedUserInfo(this).getUser_coe()) &&
                        common.GetLoggedUserInfo(this).getUser_type().equals("B")
        ))
        {
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
        }

        ((Button)findViewById(R.id.btnCreateButtn)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), New_Product_Entry.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.seller_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {

            if(!Objects.isNull(common.GetLoggedUserInfo(this).getUser_coe()))
            {
                common.LogoutUser(this);
            }

            if(Objects.isNull(common.GetLoggedUserInfo(this).getUser_coe())) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        }

        return true;
    }

}
