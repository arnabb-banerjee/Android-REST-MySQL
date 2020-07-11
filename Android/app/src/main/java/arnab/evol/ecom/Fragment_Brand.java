package arnab.evol.ecom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.JsonGetMasterList;
import arnab.evol.helper.StringPostRequest;
import arnab.evol.helper.VolleyStringResponseListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Brand#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Brand extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Brand() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Brand.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Brand newInstance(String param1, String param2) {
        Fragment_Brand fragment = new Fragment_Brand();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__brand, container, false);
        final View formElementsView = inflater.inflate(R.layout.fragment__brand_entry, null, false);

        EditText txtBrandName = (EditText) formElementsView.findViewById(R.id.txtBrandName);

        View.OnClickListener onClickListener = new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                ViewGroup parent = (ViewGroup)formElementsView.getParent();

                if(parent!=null && parent.getChildCount() > 0){
                    ((ViewGroup)formElementsView.getParent()).removeView(formElementsView);
                }

                new AlertDialog.Builder(inflater.getContext())
                        .setView(formElementsView)
                        .setTitle("New Brand")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(txtBrandName.getText().toString().isEmpty()){
                                            txtBrandName.setError("Please enter Product Name");
                                        }

                                        HashMap<String, String> params = new HashMap<String, String>();
                                        params.put("id", "0");
                                        params.put("name", txtBrandName.getText().toString());

                                        StringPostRequest req = new StringPostRequest(inflater.getContext(), serviceurls.master_brand_save, params, new VolleyStringResponseListener() {
                                            @Override
                                            public void onVolleySuccess(String sArray) {

                                            }

                                            @Override
                                            public void onVolleyFailure(String ErrorMessage) {

                                            }
                                        });

                                        common.ShowToast(inflater.getContext(), txtBrandName.getText().toString());
                                    }
                                }).show();

            }
        };
        ((Button) view.findViewById(R.id.btnBrandCreate)).setOnClickListener(onClickListener);

        new JsonGetMasterList(inflater.getContext(), serviceurls.master_brand_select, null, (LinearLayout) view.findViewById(R.id.linearLayoutBrands), "brand_id", "brand_name", onClickListener);

        return view;
    }

    public void btnCreate_OnCLick(View v){

    }
}
