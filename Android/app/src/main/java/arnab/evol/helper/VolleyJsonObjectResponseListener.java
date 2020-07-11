package arnab.evol.helper;

import org.json.JSONObject;

public interface VolleyJsonObjectResponseListener {
    void onVolleySuccess(JSONObject jsonObject);
    void onVolleyFailure(String ErrorMessage);
}
