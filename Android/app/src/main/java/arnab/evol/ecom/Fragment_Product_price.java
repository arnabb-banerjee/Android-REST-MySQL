package arnab.evol.ecom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.HashMap;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.JsonGetDropDownList;
import arnab.evol.helper.JsonGetMasterList;
import arnab.evol.helper.StringPostRequest;
import arnab.evol.helper.VolleyStringResponseListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Product_price#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Product_price extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Product_price() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Product_price.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Product_price newInstance(String param1, String param2) {
        Fragment_Product_price fragment = new Fragment_Product_price();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__product_price, container, false);
        final View formElementsView = inflater.inflate(R.layout.fragment__product_price_entry, null, false);

        Context context = view.getContext();

        View.OnClickListener onclickListener = new View.OnClickListener(){
            @Override
            //On click function
            public void onClick(View view) {
                TextView tv = (TextView) view;
                String ID = String.valueOf(tv.getTag());

                EditText txtQty = (EditText) formElementsView.findViewById(R.id.txtQty);
                EditText txtPrice_Buying = (EditText) formElementsView.findViewById(R.id.txtPrice_Buying);
                EditText txtPrice_Delivery = (EditText) formElementsView.findViewById(R.id.txtPrice_Delivery);
                EditText txtPrice_Making = (EditText) formElementsView.findViewById(R.id.txtPrice_Making);
                EditText txtPrice_Packing = (EditText) formElementsView.findViewById(R.id.txtPrice_Packing);
                EditText txtPrice_Service = (EditText) formElementsView.findViewById(R.id.txtPrice_Service);
                EditText txtPrice_Storage = (EditText) formElementsView.findViewById(R.id.txtPrice_Storage);
                EditText txtTax = (EditText) formElementsView.findViewById(R.id.txtTax);
                EditText txtprice_Total = (EditText) formElementsView.findViewById(R.id.txtprice_Total);

                TextWatcher tw = new TextWatcher() {
                    public void afterTextChanged(Editable s) {
                        txtprice_Total.setText(
                                String.valueOf(
                                        (s.toString().trim().length() > 0 ? Double.parseDouble(s.toString().trim()):Double.parseDouble("0"))
                                                + (txtprice_Total.getText().toString().trim().length() > 0 ? Double.parseDouble(txtprice_Total.getText().toString().trim()):Double.parseDouble("0"))
                                ));
                    }

                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                    public void onTextChanged(CharSequence s, int start, int before, int count) {}
                };

                txtPrice_Buying.addTextChangedListener(tw);
                txtPrice_Delivery.addTextChangedListener(tw);
                txtPrice_Making.addTextChangedListener(tw);
                txtPrice_Packing.addTextChangedListener(tw);
                txtPrice_Service.addTextChangedListener(tw);
                txtPrice_Storage.addTextChangedListener(tw);
                txtTax.addTextChangedListener(tw);

                Spinner spinProducts = (Spinner) formElementsView.findViewById(R.id.spin_product);
                Spinner spinUnits = (Spinner) formElementsView.findViewById(R.id.spin_unit);

                new JsonGetDropDownList(formElementsView.getContext(), serviceurls.Product_Select, null, spinProducts, "prod_id", "prod_name");
                new JsonGetDropDownList(formElementsView.getContext(), serviceurls.master_unit_select, null, spinUnits, "unit_id", "unit_name");

                ViewGroup parent = (ViewGroup)formElementsView.getParent();

                if(parent!=null && parent.getChildCount() > 0){
                    ((ViewGroup)formElementsView.getParent()).removeView(formElementsView);
                }

                new AlertDialog.Builder(inflater.getContext())
                        .setView(formElementsView)
                        .setTitle("New Price")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(txtQty.getText().toString().isEmpty()){
                                            txtQty.setError("Please enter Quantity");
                                        }
                                        if(txtTax.getText().toString().isEmpty()){
                                            txtTax.setError("Please enter Tax");
                                        }

                                        HashMap<String, String> params = new HashMap<String, String>();

                                        params.put("prod_price_id", String.valueOf(ID));
                                        params.put("Qty", txtQty.getText().toString());
                                        params.put("Unit", spinUnits.getTag().toString());
                                        params.put("prod_id", spinProducts.getTag().toString());
                                        params.put("price_Buying", txtPrice_Buying.getText().toString());
                                        params.put("price_Packing", txtPrice_Packing.getText().toString());
                                        params.put("price_Delivery", txtPrice_Delivery.getText().toString());
                                        params.put("price_Making", txtPrice_Making.getText().toString());
                                        params.put("price_Service", txtPrice_Service.getText().toString());
                                        params.put("price_Storage", txtPrice_Storage.getText().toString());
                                        params.put("tax", txtTax.getText().toString());
                                        params.put("price_Total", txtprice_Total.getText().toString());
                                        params.put("seller_code", common.GetLoggedUserInfo(inflater.getContext()).getUser_coe());

                                        StringPostRequest req = new StringPostRequest(inflater.getContext(), serviceurls.Product_Price_Entry, params, new VolleyStringResponseListener() {
                                            @Override
                                            public void onVolleySuccess(String sArray) {

                                            }

                                            @Override
                                            public void onVolleyFailure(String ErrorMessage) {

                                            }
                                        });

                                        common.ShowToast(inflater.getContext(), txtprice_Total.getText().toString());
                                    }
                                }).show();

            }
        };

        ((Button) view.findViewById(R.id.btnProductPriceCreate)).setOnClickListener(onclickListener);

        new JsonGetMasterList(inflater.getContext(), serviceurls.Product_Price_Select, null, (LinearLayout) view.findViewById(R.id.linearLayoutProductPrices), "prod_id", "prod_name", onclickListener);

        return view;
    }
}
