package android.lavtaxi.retrofit;

public interface ResponseCallback {
    void success(Object object);
    void fail(String error);
}
