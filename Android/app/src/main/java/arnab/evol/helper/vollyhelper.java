package arnab.evol.helper;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class vollyhelper  {

    private static vollyhelper instance;
    private RequestQueue requestQueue;
    private static Context ctx;
    private vollyhelper(Context context)
    {
        ctx = context;
        requestQueue = getRequestQueue();
    }
    public static synchronized vollyhelper getInstance(Context context)
    {
        if(instance==null){
            instance= new vollyhelper(context);
        }

        return instance;
    }

    public RequestQueue getRequestQueue()
    {
        if(requestQueue == null)
        {
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getRequestQueue().add(req);
    }


}