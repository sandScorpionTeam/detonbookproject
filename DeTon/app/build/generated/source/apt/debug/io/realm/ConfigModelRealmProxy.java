package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.anh.deton.Model.ConfigModel;
import com.example.anh.deton.Model.PageNumberModel;
import io.realm.RealmObject;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnType;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigModelRealmProxy extends ConfigModel
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_LASTPAGE;
    private static long INDEX_LASTCHAP;
    private static long INDEX_CURRENTCHAP;
    private static long INDEX_FONTSIZE;
    private static long INDEX_ARRPAGELOADED;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("lastPage");
        fieldNames.add("lastChap");
        fieldNames.add("currentChap");
        fieldNames.add("fontSize");
        fieldNames.add("arrPageLoaded");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public int getId() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_ID);
    }

    @Override
    public void setId(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_ID, (long) value);
    }

    @Override
    public int getLastPage() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_LASTPAGE);
    }

    @Override
    public void setLastPage(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_LASTPAGE, (long) value);
    }

    @Override
    public int getLastChap() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_LASTCHAP);
    }

    @Override
    public void setLastChap(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_LASTCHAP, (long) value);
    }

    @Override
    public int getCurrentChap() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_CURRENTCHAP);
    }

    @Override
    public void setCurrentChap(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_CURRENTCHAP, (long) value);
    }

    @Override
    public int getFontSize() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_FONTSIZE);
    }

    @Override
    public void setFontSize(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_FONTSIZE, (long) value);
    }

    @Override
    public RealmList<PageNumberModel> getArrPageLoaded() {
        return new RealmList<PageNumberModel>(PageNumberModel.class, row.getLinkList(INDEX_ARRPAGELOADED), realm);
    }

    @Override
    public void setArrPageLoaded(RealmList<PageNumberModel> value) {
        LinkView links = row.getLinkList(INDEX_ARRPAGELOADED);
        if (value == null) {
            return;
        }
        links.clear();
        for (RealmObject linkedObject : (RealmList<? extends RealmObject>) value) {
            links.add(linkedObject.row.getIndex());
        }
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_ConfigModel")) {
            Table table = transaction.getTable("class_ConfigModel");
            table.addColumn(ColumnType.INTEGER, "id");
            table.addColumn(ColumnType.INTEGER, "lastPage");
            table.addColumn(ColumnType.INTEGER, "lastChap");
            table.addColumn(ColumnType.INTEGER, "currentChap");
            table.addColumn(ColumnType.INTEGER, "fontSize");
            if (!transaction.hasTable("class_PageNumberModel")) {
                PageNumberModelRealmProxy.initTable(transaction);
            }
            table.addColumnLink(ColumnType.LINK_LIST, "arrPageLoaded", transaction.getTable("class_PageNumberModel"));
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_ConfigModel");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_ConfigModel")) {
            Table table = transaction.getTable("class_ConfigModel");
            if (table.getColumnCount() != 6) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 6 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 6; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type ConfigModel");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_LASTPAGE = table.getColumnIndex("lastPage");
            INDEX_LASTCHAP = table.getColumnIndex("lastChap");
            INDEX_CURRENTCHAP = table.getColumnIndex("currentChap");
            INDEX_FONTSIZE = table.getColumnIndex("fontSize");
            INDEX_ARRPAGELOADED = table.getColumnIndex("arrPageLoaded");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'id'");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'id'");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'id'");
            }
            if (!columnTypes.containsKey("lastPage")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'lastPage'");
            }
            if (columnTypes.get("lastPage") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'lastPage'");
            }
            if (!columnTypes.containsKey("lastChap")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'lastChap'");
            }
            if (columnTypes.get("lastChap") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'lastChap'");
            }
            if (!columnTypes.containsKey("currentChap")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'currentChap'");
            }
            if (columnTypes.get("currentChap") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'currentChap'");
            }
            if (!columnTypes.containsKey("fontSize")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'fontSize'");
            }
            if (columnTypes.get("fontSize") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'fontSize'");
            }
            if (!columnTypes.containsKey("arrPageLoaded")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'arrPageLoaded'");
            }
            if (columnTypes.get("arrPageLoaded") != ColumnType.LINK_LIST) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'PageNumberModel' for field 'arrPageLoaded'");
            }
            if (!transaction.hasTable("class_PageNumberModel")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_PageNumberModel' for field 'arrPageLoaded'");
            }
            Table table_5 = transaction.getTable("class_PageNumberModel");
            if (!table.getLinkTarget(INDEX_ARRPAGELOADED).hasSameSchema(table_5)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmList type for field 'arrPageLoaded': '" + table.getLinkTarget(INDEX_ARRPAGELOADED).getName() + "' expected - was '" + table_5.getName() + "'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The ConfigModel class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ConfigModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static ConfigModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        ConfigModel obj = null;
        if (update) {
            Table table = realm.getTable(ConfigModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new ConfigModelRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getUncheckedRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(ConfigModel.class);
        }
        if (!json.isNull("id")) {
            obj.setId((int) json.getInt("id"));
        }
        if (!json.isNull("lastPage")) {
            obj.setLastPage((int) json.getInt("lastPage"));
        }
        if (!json.isNull("lastChap")) {
            obj.setLastChap((int) json.getInt("lastChap"));
        }
        if (!json.isNull("currentChap")) {
            obj.setCurrentChap((int) json.getInt("currentChap"));
        }
        if (!json.isNull("fontSize")) {
            obj.setFontSize((int) json.getInt("fontSize"));
        }
        if (!json.isNull("arrPageLoaded")) {
            obj.getArrPageLoaded().clear();
            JSONArray array = json.getJSONArray("arrPageLoaded");
            for (int i = 0; i < array.length(); i++) {
                com.example.anh.deton.Model.PageNumberModel item = PageNumberModelRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                obj.getArrPageLoaded().add(item);
            }
        }
        return obj;
    }

    public static ConfigModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        ConfigModel obj = realm.createObject(ConfigModel.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id") && reader.peek() != JsonToken.NULL) {
                obj.setId((int) reader.nextInt());
            } else if (name.equals("lastPage")  && reader.peek() != JsonToken.NULL) {
                obj.setLastPage((int) reader.nextInt());
            } else if (name.equals("lastChap")  && reader.peek() != JsonToken.NULL) {
                obj.setLastChap((int) reader.nextInt());
            } else if (name.equals("currentChap")  && reader.peek() != JsonToken.NULL) {
                obj.setCurrentChap((int) reader.nextInt());
            } else if (name.equals("fontSize")  && reader.peek() != JsonToken.NULL) {
                obj.setFontSize((int) reader.nextInt());
            } else if (name.equals("arrPageLoaded")  && reader.peek() != JsonToken.NULL) {
                reader.beginArray();
                while (reader.hasNext()) {
                    com.example.anh.deton.Model.PageNumberModel item = PageNumberModelRealmProxy.createUsingJsonStream(realm, reader);
                    obj.getArrPageLoaded().add(item);
                }
                reader.endArray();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static ConfigModel copyOrUpdate(Realm realm, ConfigModel object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        ConfigModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(ConfigModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstLong(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new ConfigModelRealmProxy();
                realmObject.realm = realm;
                realmObject.row = table.getUncheckedRow(rowIndex);
                cache.put(object, (RealmObjectProxy) realmObject);
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static ConfigModel copy(Realm realm, ConfigModel newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        ConfigModel realmObject = realm.createObject(ConfigModel.class, newObject.getId());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId());
        realmObject.setLastPage(newObject.getLastPage());
        realmObject.setLastChap(newObject.getLastChap());
        realmObject.setCurrentChap(newObject.getCurrentChap());
        realmObject.setFontSize(newObject.getFontSize());

        RealmList<PageNumberModel> arrPageLoadedList = newObject.getArrPageLoaded();
        if (arrPageLoadedList != null) {
            RealmList<PageNumberModel> arrPageLoadedRealmList = realmObject.getArrPageLoaded();
            for (int i = 0; i < arrPageLoadedList.size(); i++) {
                PageNumberModel arrPageLoadedItem = arrPageLoadedList.get(i);
                PageNumberModel cachearrPageLoaded = (PageNumberModel) cache.get(arrPageLoadedItem);
                if (cachearrPageLoaded != null) {
                    arrPageLoadedRealmList.add(cachearrPageLoaded);
                } else {
                    arrPageLoadedRealmList.add(PageNumberModelRealmProxy.copyOrUpdate(realm, arrPageLoadedList.get(i), update, cache));
                }
            }
        }

        return realmObject;
    }

    static ConfigModel update(Realm realm, ConfigModel realmObject, ConfigModel newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setLastPage(newObject.getLastPage());
        realmObject.setLastChap(newObject.getLastChap());
        realmObject.setCurrentChap(newObject.getCurrentChap());
        realmObject.setFontSize(newObject.getFontSize());
        RealmList<PageNumberModel> arrPageLoadedList = newObject.getArrPageLoaded();
        RealmList<PageNumberModel> arrPageLoadedRealmList = realmObject.getArrPageLoaded();
        arrPageLoadedRealmList.clear();
        if (arrPageLoadedList != null) {
            for (int i = 0; i < arrPageLoadedList.size(); i++) {
                PageNumberModel arrPageLoadedItem = arrPageLoadedList.get(i);
                PageNumberModel cachearrPageLoaded = (PageNumberModel) cache.get(arrPageLoadedItem);
                if (cachearrPageLoaded != null) {
                    arrPageLoadedRealmList.add(cachearrPageLoaded);
                } else {
                    arrPageLoadedRealmList.add(PageNumberModelRealmProxy.copyOrUpdate(realm, arrPageLoadedList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ConfigModel = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastPage:");
        stringBuilder.append(getLastPage());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastChap:");
        stringBuilder.append(getLastChap());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{currentChap:");
        stringBuilder.append(getCurrentChap());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fontSize:");
        stringBuilder.append(getFontSize());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{arrPageLoaded:");
        stringBuilder.append("RealmList<PageNumberModel>[").append(getArrPageLoaded().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigModelRealmProxy aConfigModel = (ConfigModelRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aConfigModel.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aConfigModel.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aConfigModel.row.getIndex()) return false;

        return true;
    }

}
