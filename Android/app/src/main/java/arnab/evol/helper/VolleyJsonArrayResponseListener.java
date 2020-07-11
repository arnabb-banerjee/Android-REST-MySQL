package arnab.evol.helper;

import org.json.JSONArray;

public interface VolleyJsonArrayResponseListener {
    void onVolleySuccess(JSONArray jsonArray);
    void onVolleyFailure(String ErrorMessage);
}
