package arnab.evol.ecom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import java.util.HashMap;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.JsonGetMasterList;
import arnab.evol.helper.StringPostRequest;
import arnab.evol.helper.VolleyStringResponseListener;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Category#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Category extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Category() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Category.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Category newInstance(String param1, String param2) {
        Fragment_Category fragment = new Fragment_Category();
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
        View view = inflater.inflate(R.layout.fragment__category, container, false);
        final View formElementsView = inflater.inflate(R.layout.fragment__category_entry, null, false);

        EditText txtCategoryName = (EditText) formElementsView.findViewById(R.id.txtCategoryName);

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
                        .setTitle("New Category")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(txtCategoryName.getText().toString().isEmpty()){
                                            txtCategoryName.setError("Please enter Product Name");
                                        }

                                        HashMap<String, String> params = new HashMap<String, String>();
                                        params.put("id", "0");
                                        params.put("name", txtCategoryName.getText().toString());

                                        StringPostRequest req = new StringPostRequest(inflater.getContext(), serviceurls.master_category_save, params, new VolleyStringResponseListener() {

                                            @Override
                                            public void onVolleySuccess(String sArray) {

                                            }

                                            @Override
                                            public void onVolleyFailure(String ErrorMessage) {

                                            }
                                        });

                                        common.ShowToast(inflater.getContext(), txtCategoryName.getText().toString());
                                    }
                                }).show();

            }
        };

        ((Button) view.findViewById(R.id.btnCategoryCreate)).setOnClickListener(onClickListener);

        new JsonGetMasterList(inflater.getContext(), serviceurls.master_category_select, null, (LinearLayout) view.findViewById(R.id.linearLayoutCategories), "cat_Id", "cat_name", onClickListener);

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment__brand, container, false);
    }

    public void btnCreate_OnCLick(Fragment f){
        LayoutInflater factory = LayoutInflater.from(f.getContext());
        View titleView = factory.inflate(R.layout.fragment__category_entry, null);

        AlertDialog.Builder adb = new AlertDialog.Builder(f.getContext())
                .setCustomTitle(titleView);

        adb.show();
    }
}
