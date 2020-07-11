package arnab.evol.ecom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import java.util.HashMap;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.JsonGetDropDownList;
import arnab.evol.helper.JsonGetMasterList;
import arnab.evol.helper.StringPostRequest;
import arnab.evol.helper.VolleyStringResponseListener;
import arnab.evol.helper.MyOnClickListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Product#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Product extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Product() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Product.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Product newInstance(String param1, String param2) {
        Fragment_Product fragment = new Fragment_Product();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__product, container, false);
        final View formElementsView = inflater.inflate(R.layout.fragment__product_entry, null, false);

        Context context = view.getContext();

        View.OnClickListener onClickListener = new MyOnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {

                try
                {
                    EditText txtProductName = (EditText) formElementsView.findViewById(R.id.txtProductName);
                    EditText txtProductDec = (EditText) formElementsView.findViewById(R.id.txtProductDescription);
                    Spinner spinDivision = (Spinner) formElementsView.findViewById(R.id.spin_division);
                    Spinner spinCategory = (Spinner) formElementsView.findViewById(R.id.spin_category);
                    Spinner spinBrand = (Spinner) formElementsView.findViewById(R.id.spin_brand);

                    new JsonGetDropDownList(context, serviceurls.master_division_select, null, spinDivision, "div_id", "div_name");
                    new JsonGetDropDownList(context, serviceurls.master_category_select, null, spinCategory, "cat_Id", "cat_name");
                    new JsonGetDropDownList(context, serviceurls.master_brand_select, null, spinBrand, "brand_id", "brand_name");

                    ViewGroup parent = (ViewGroup)formElementsView.getParent();

                    if(parent!=null && parent.getChildCount() > 0){
                        ((ViewGroup)formElementsView.getParent()).removeView(formElementsView);
                    }

                    new AlertDialog.Builder(inflater.getContext())
                            .setView(formElementsView)
                            .setTitle("New Product")
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    })
                            .setPositiveButton("Save",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            if(txtProductName.getText().toString().isEmpty()){
                                                txtProductName.setError("Please enter Product Name");
                                            }

                                            HashMap<String, String> params = new HashMap<String, String>();
                                            params.put("prod_id", "0");
                                            params.put("prod_name", txtProductName.getText().toString());
                                            params.put("prod_desc", txtProductDec.getText().toString());
                                            params.put("cat_Id", spinCategory.getTag().toString());
                                            params.put("div_id", spinDivision.getTag().toString());
                                            params.put("brand_id", spinBrand.getTag().toString());

                                            StringPostRequest req = new StringPostRequest(inflater.getContext(), serviceurls.Product_Entry, params, new VolleyStringResponseListener() {
                                                @Override
                                                public void onVolleySuccess(String sArray) {

                                                }

                                                @Override
                                                public void onVolleyFailure(String ErrorMessage) {

                                                }
                                            });

                                            common.ShowToast(inflater.getContext(), txtProductName.getText().toString());
                                        }
                                    }).show();
                }
                catch (Exception e){
                    common.ErrorLog("btnProductCreate_Onclick", e.toString());
                }
            }
        };

        ((Button) view.findViewById(R.id.btnProductCreate)).setOnClickListener(onClickListener);

        new JsonGetMasterList(inflater.getContext(), serviceurls.Product_Select, null, (LinearLayout) view.findViewById(R.id.linearLayoutProducts), "prod_id", "prod_name", onClickListener);

        return view;
    }
}