package arnab.evol.helper;

import android.content.Context;
import android.util.Log;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONObject;

public interface VolleyResponseListener {
    default void onVolleySuccess(JSONArray jsonArray){}
    default void onVolleySuccess(JSONObject jsonObject){}
    default void onVolleySuccess(String sArray){}
    default void onVolleyFailure(String url, String ErrorMessage){ Log.e("Volley error", ErrorMessage); }
    default void bindDropDownList(Context context, JSONArray jsonArray, Spinner spinner, String Value){}
}
