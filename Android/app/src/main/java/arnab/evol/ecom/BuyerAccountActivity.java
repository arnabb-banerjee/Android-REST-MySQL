package arnab.evol.ecom;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import arnab.evol.general.common;

import static java.util.Objects.isNull;

public class BuyerAccountActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_account);

        if(isNull(common.GetLoggedUserInfo(this).getUser_coe()) || (
                !isNull(common.GetLoggedUserInfo(this).getUser_coe()) &&
                        common.GetLoggedUserInfo(this).getUser_type().equals("S")
        ))
        {
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.buyer_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            /*
            LayoutInflater factory = LayoutInflater.from(this);
            View titleView = factory.inflate(R.layout.login, null);

            AlertDialog.Builder adb = new AlertDialog.Builder(this)
                    .setCustomTitle(titleView);

            adb.show();*/

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
