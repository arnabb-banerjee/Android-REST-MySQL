package arnab.evol.helper;

public interface VolleyStringResponseListener {
    void onVolleySuccess(String JsonString);
    void onVolleyFailure(String ErrorMessage);
}
