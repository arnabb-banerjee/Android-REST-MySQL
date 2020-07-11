package arnab.evol.ecom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class New_Product_Entry extends AppCompatActivity {
    private MasterPagesAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product_entry);

        viewPager = (ViewPager) findViewById(R.id.viewPager2);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout2);
        adapter = new MasterPagesAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Product(), "Product");
        adapter.addFragment(new Fragment_Product_price(), "Prices");
        adapter.addFragment(new Fragment_Product_Image(), "Images");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
