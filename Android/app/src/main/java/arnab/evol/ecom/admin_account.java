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

public class admin_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_account);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.masterdata) {
            /*
            LayoutInflater factory = LayoutInflater.from(this);
            View titleView = factory.inflate(R.layout.login, null);

            AlertDialog.Builder adb = new AlertDialog.Builder(this)
                    .setCustomTitle(titleView);

            adb.show();*/

            Intent intent=new Intent(getBaseContext(), MasterPages.class);
            intent.putExtra("clicked_by", item.getItemId());
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.logout) {
            common.LogoutUser(getBaseContext());
            if(Objects.isNull(common.GetLoggedUserInfo(this).getUser_coe()) || (
                    !Objects.isNull(common.GetLoggedUserInfo(this).getUser_coe()) &&
                            !common.GetLoggedUserInfo(this).getUser_type().equals("*&^*&*$$@@SuperUser&^%&%&&")
            ))
            {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
            }
        }

        return true;
    }
}
