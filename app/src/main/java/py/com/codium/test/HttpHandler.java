package py.com.codium.test;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by eferreira on 14/03/18.
 */

public class HttpHandler {
    Context ctx;
    RequestQueue queue;


    public interface HttpCallback<T> {
        void onSuccess(T response);
        Boolean onError(NetworkResponse error);
    }

    public HttpHandler(Context context) {
        this.ctx = context;
        this.queue = Volley.newRequestQueue(context);
    }


    /**
     * Generic method that perform the http request
     * @param url
     * @param method
     * @param cls
     * @param callback
     */
    private void doRequest(String url, int method, final Class cls, final HttpCallback callback) {
        Utils.showProgressDialog(ctx);
        StringRequest stringRequest = new StringRequest(method, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Utils.hideProgressDialog();
                Object obj = new Gson().fromJson(response.toString(), cls);
                callback.onSuccess(obj);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Utils.hideProgressDialog();
                NetworkResponse networkResponse = error.networkResponse;
                if (callback.onError(networkResponse)) {
                    //if is TRUE, the client will manage the error
                } else {
                    Utils.showErrorMessage(ctx, ctx.getResources().getString(R.string.generic_error));
                }
            }
        });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                3000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        queue.add(stringRequest);
    }


    public void getPersons(HttpCallback<Person[]> callback) {
        doRequest("http://www.filltext.com/?rows=100&fname=%7BfirstName%7D&lname=%7BlastName%7D&city=%7Bcity%7D&pretty=true",
                Request.Method.GET, Person[].class, callback);
    }


}
