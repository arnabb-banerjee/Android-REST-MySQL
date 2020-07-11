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
 * Use the {@link Fragment_Division#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Division extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Division() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Division.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Division newInstance(String param1, String param2) {
        Fragment_Division fragment = new Fragment_Division();
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
        View view = inflater.inflate(R.layout.fragment__division, container, false);
        final View formElementsView = inflater.inflate(R.layout.fragment_division_entry, null, false);

        EditText txtDivisionName = (EditText) formElementsView.findViewById(R.id.txtDivisionName);

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
                        .setTitle("New Division")
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Save",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        if(txtDivisionName.getText().toString().isEmpty()){
                                            txtDivisionName.setError("Please enter Product Name");
                                        }

                                        HashMap<String, String> params = new HashMap<String, String>();
                                        params.put("id", "0");
                                        params.put("name", txtDivisionName.getText().toString());

                                        StringPostRequest req = new StringPostRequest(inflater.getContext(), serviceurls.master_division_save, params, new VolleyStringResponseListener() {
                                            @Override
                                            public void onVolleySuccess(String sArray) {

                                            }

                                            @Override
                                            public void onVolleyFailure(String ErrorMessage) {

                                            }
                                        });

                                        common.ShowToast(inflater.getContext(), txtDivisionName.getText().toString());
                                    }
                                }).show();

            }
        };

        ((Button) view.findViewById(R.id.btnDivisionCreate)).setOnClickListener(onClickListener);

        new JsonGetMasterList(inflater.getContext(), serviceurls.master_division_select, null, (LinearLayout) view.findViewById(R.id.linearLayoutDivisions), "div_id", "div_name", onClickListener);

        return view;
    }
}
