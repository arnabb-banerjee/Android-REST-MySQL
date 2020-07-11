package arnab.evol.ecom;
import android.content.Context;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SaveProduct implements View.OnClickListener
{
    @Override
    public void onClick(View view) {
        Context context = view.getRootView().getContext();

        //Mention: android:usesCleartextTraffic="true" in Android Manifest
        //Mention: <uses-permission android:name="android.permission.INTERNET" /> in Android Manifest
        //Mention: Change the URL: http://10.0.2.2 instead of http://127.0.0.1 Because Android emulator runs in a Virtual Machine therefore here 127.0.0.1 or localhost will be emulator's own loopback address
        final String URL = "http://10.0.2.2:8080/rest/webapi/myresource2/save";
        RequestQueue req = Volley.newRequestQueue(context);

        /*final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Rest Response", response.toString());

                        List<ProductInfo> list = new ArrayList<ProductInfo>();
                        ProductInfo obj= null;
                        for(int i = 0; i < response.length(); i++)
                        {
                            try {
                                JSONObject json = response.getJSONObject(i);
                                if(json!=null)
                                {
                                    obj=new ProductInfo();
                                    obj.setDescription(json.getString("description"));
                                    obj.setName(json.getString("name"));
                                    list.add(obj);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        GridLayout viewList = (GridLayout) findViewById(R.id.grdProductsBuyer);
                        viewList.removeAllViews();

                        int total = 12;
                        int cols = 2;
                        int rows = 12/2;

                        viewList.setColumnCount(cols);
                        viewList.setRowCount(rows+1);

                        for(int j=0, c=0, r=0; j < total; j++, c++)
                        {
                            if(c == cols) {
                                c = 0;
                                r++;
                            }

                            //View cView = new View(MainActivity.this);
                            //oImageView.setImageResource(R.drawable.ic_launcher);
                            GridLayout.LayoutParams param = new GridLayout.LayoutParams();
                            param.height = GridLayout.LayoutParams.WRAP_CONTENT;
                            param.width = GridLayout.LayoutParams.WRAP_CONTENT;
                            param.rightMargin = 5;
                            param.topMargin = 5;
                            param.setGravity(Gravity.CENTER);

                            param.columnSpec = GridLayout.spec(c);
                            param.rowSpec = GridLayout.spec(r);
                            //cView.setLayoutParams(param);

                            TextView txtview1 = new TextView(ProductActivity.this);
                            txtview1.setText(list.get(0).getName());
                            viewList.addView(txtview1);
                            TextView txtview2 = new TextView(ProductActivity.this);
                            txtview2.setText(list.get(0).getDescription());
                            viewList.addView(txtview2);
                            //viewList.addView(cView);
                        }

                        //setContentView(viewList);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Log.d("RVA", "error:" + error);

                        String errorText = "";
                        if (error instanceof TimeoutError) {
                            errorText = "Time out";
                        } else if (error instanceof NoConnectionError) {
                            errorText = "NoConnectionError";
                        } else if (error instanceof AuthFailureError) {
                            errorText = "AuthFailureError";
                        } else if (error instanceof ServerError) {
                            errorText = "ServerError";
                        } else if (error instanceof NetworkError) {
                            errorText = "NetworkError";
                        } else if (error instanceof ParseError) {
                            errorText = "ParseError";
                        }
                        Toast.makeText(ProductActivity.this, errorText, Toast.LENGTH_SHORT).show();
                    }
                }
        );

        req.add(jsonObjectRequest);*/

    }
}
