package arnab.evol.ecom;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MasterPages extends AppCompatActivity {
    private MasterPagesAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_pages);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        adapter = new MasterPagesAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Brand(), "Brands");
        adapter.addFragment(new Fragment_Category(), "Categories");
        adapter.addFragment(new Fragment_Division(), "Divisions");
        adapter.addFragment(new Fragment_Unit(), "Units");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
