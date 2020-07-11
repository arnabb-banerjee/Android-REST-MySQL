package arnab.evol.ecom;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import arnab.evol.general.common;
import arnab.evol.general.serviceurls;
import arnab.evol.helper.DataPart;
import arnab.evol.helper.JsonGetMasterList;
import arnab.evol.helper.VolleyMultipartRequest;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Product_Image#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Product_Image extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btnChoose;
    private Button btnUpload;
    private ImageView imgView;

    private View view;
    //Image request code
    private int PICK_IMAGE_REQUEST = 1;
    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;
    //Bitmap to get image from gallery
    private Bitmap bitmap;
    //Uri to store the image uri
    private Uri filePath;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Product_Image() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Product_Image.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Product_Image newInstance(String param1, String param2) {
        Fragment_Product_Image fragment = new Fragment_Product_Image();
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
        view = inflater.inflate(R.layout.fragment__product__image, container, false);
        final View formElementsView = inflater.inflate(R.layout.fragment__product_image_entry, null, false);
        btnChoose = (Button) formElementsView.findViewById(R.id.btnChoose);
        imgView = (ImageView) formElementsView.findViewById(R.id.imgViewUploaded);

        //Setting clicklistener
        Context context = view.getContext();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            //On click function
            public void onClick(View view) {
                //Permission

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
                        .setPositiveButton("Upload",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        uploadMultipart(formElementsView.getContext());
                                    }
                                }).show();
            }
        };

        ((Button) view.findViewById(R.id.btnProductImageUpload)).setOnClickListener(onClickListener);



        ((Button) formElementsView.findViewById(R.id.btnChoose)).setOnClickListener(new View.OnClickListener() {
            @Override
            //On click function
            public void onClick(View view) {
                showFileChooser();
            }
        });

        new JsonGetMasterList(inflater.getContext(), serviceurls.Product_Image_Select, null, (LinearLayout) view.findViewById(R.id.linearLayoutProductImages), "prod_id", "prod_name", onClickListener);

        return view;
    }

    /*
     * This is the method responsible for image upload
     * We need the full image path and the name for the image in this method
     * */
    public void uploadMultipart(Context context) {
        //getting name for the image
        String name = "arnab";

        //getting the actual path of the image
        String path = getPath(filePath, context);

        //Uploading code
        /*try {
            String uploadId = UUID.randomUUID().toString();

            //Creating a multi part request
            new MultipartUploadRequest(getContext(), uploadId, serviceurls.Product_Image_Entry)
                    .addFileToUpload(path, "image") //Adding file
                    .addParameter("name", name) //Adding text parameter to the request
                    .setNotificationConfig(new UploadNotificationConfig())
                    .setMaxRetries(2)
                    .startUpload(); //Starting the upload

        } catch (Exception exc) {
            common.ShowToast(getContext(), exc.getMessage());
        }*/


        VolleyMultipartRequest volleyMultipartRequest = new VolleyMultipartRequest(Request.Method.POST, serviceurls.Product_Image_Entry,
                new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        try {
                            Log.e("Ok", response.toString());
                            JSONObject obj = new JSONObject(new String(response.data));
                            Log.e("Ok", "Clickied2");
                            common.ShowToast(context, obj.toString());
                            Log.e("Ok", "Clickied1");

                        } catch (JSONException e) {
                            Log.e("Ok", "Clickied4");
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Ok", "Clickied5");

                        common.ShowToast(context, error.getMessage());
                        Log.e("GotError",""+error.getMessage());
                    }
                }) {


            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<String, DataPart>();
                long imagename = System.currentTimeMillis();
                params.put("file", new DataPart(imagename + ".JPEG", getFileDataFromDrawable(bitmap)));

                return params;
            }
        };

        //adding the request to volley
        Volley.newRequestQueue(context).add(volleyMultipartRequest);
    }

    //method to show file chooser
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //handling the image chooser activity result
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(view.getContext().getContentResolver(), filePath);
                imgView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //method to get the file path from uri
    public String getPath(Uri uri, Context context) {
        String path = "";
        String document_id ="";
                Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        while(cursor.moveToNext()) {
            cursor.moveToFirst();
            document_id = cursor.getString(0);
        }

        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);

        cursor.close();

        cursor = context.getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);

        while(cursor.moveToNext()) {
            cursor.moveToFirst();
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        }
        cursor.close();

        return path;
    }

    //Requesting permission
    private void requestStoragePermission(Context context, Activity activity) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;
        /*if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;*/

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE /*,Manifest.permission.WRITE_EXTERNAL_STORAGE*/}, STORAGE_PERMISSION_CODE);
    }

    //This method will be called when the user will tap on allow or deny
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == STORAGE_PERMISSION_CODE) {

            //If permission is granted
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //Displaying a toast
                common.ShowToast(view.getContext(), "Permission granted now you can read the storage");
            } else {
                //Displaying another toast if permission is not granted
                common.ShowToast(view.getContext(), "Oops you just denied the permission");
            }
        }
    }

    public byte[] getFileDataFromDrawable(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
