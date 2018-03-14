package py.com.codium.test;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by eferreira on 14/03/18.
 */

public class Utils {

    private static ProgressDialog progressDialog;

    public static void showProgressDialog(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }


    public static void hideProgressDialog() {
        progressDialog.dismiss();
    }


    public static void showErrorMessage(Context ctx, String msg) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        builder.setMessage(msg);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
