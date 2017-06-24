package android.lavtaxi.retrofit;

import android.content.Context;
import android.lavtaxi.R;

import java.io.IOException;
import java.lang.*;
import java.lang.annotation.Annotation;


/**
 * Created by anahit on 7/15/16.
 */
public class BaseManager {

//    public static final int UNAUTHORIZED = 401;
//    public static String parseError(okhttp3.ResponseBody error, Context context){
//        try {
//            java.lang.Error myError = (java.lang.Error)RetrofitHelper.retrofit.responseBodyConverter(
//                    java.lang.Error.class, new Annotation[0])
//                    .convert(error);
//            return parseErrorModel(myError,context);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return context.getString(R.string.unknown_error_code);
//    }
//
//    public static String parseErrorModel(java.lang.Error myError, Context context){
//        if (myError != null ) {
//            if(myError.getCode() == UNAUTHORIZED) {
//                MyApplication.removeUserAndLogout();
//            }
//            if (myError.getMessage() != null){
//                return myError.getMessage();
//            }
//        }
//        return context.getString(R.string.unknown_error_code);
//    }
}
