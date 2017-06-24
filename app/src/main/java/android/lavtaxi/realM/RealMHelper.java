package android.lavtaxi.realM;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.internal.LinkView;

/**
 * Created by rob on 6/25/17.
 */

public class RealMHelper {
    public static void removeObjectFromRealM(RealmObject object) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        object.removeFromRealm();
        realm.commitTransaction();
    }

    public static void saveObjectInRealM(RealmObject object) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(object);
        realm.commitTransaction();
    }

    public static RealmResults<? extends RealmObject> getAllObjectByType(Class<? extends RealmObject> clazz){
        return Realm.getDefaultInstance().where(clazz).findAll();
    }
}
