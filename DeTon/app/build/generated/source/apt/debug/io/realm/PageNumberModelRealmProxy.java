package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
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

public class PageNumberModelRealmProxy extends PageNumberModel
    implements RealmObjectProxy {

    private static long INDEX_PAGENUMBER;
    private static long INDEX_LINK;
    private static long INDEX_ISLOADED;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("pageNumber");
        fieldNames.add("link");
        fieldNames.add("isloaded");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public int getPageNumber() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_PAGENUMBER);
    }

    @Override
    public void setPageNumber(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_PAGENUMBER, (long) value);
    }

    @Override
    public String getLink() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_LINK);
    }

    @Override
    public void setLink(String value) {
        realm.checkIfValid();
        row.setString(INDEX_LINK, (String) value);
    }

    @Override
    public boolean isloaded() {
        realm.checkIfValid();
        return (boolean) row.getBoolean(INDEX_ISLOADED);
    }

    @Override
    public void setIsloaded(boolean value) {
        realm.checkIfValid();
        row.setBoolean(INDEX_ISLOADED, (boolean) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_PageNumberModel")) {
            Table table = transaction.getTable("class_PageNumberModel");
            table.addColumn(ColumnType.INTEGER, "pageNumber");
            table.addColumn(ColumnType.STRING, "link");
            table.addColumn(ColumnType.BOOLEAN, "isloaded");
            table.addSearchIndex(table.getColumnIndex("pageNumber"));
            table.setPrimaryKey("pageNumber");
            return table;
        }
        return transaction.getTable("class_PageNumberModel");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_PageNumberModel")) {
            Table table = transaction.getTable("class_PageNumberModel");
            if (table.getColumnCount() != 3) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 3 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 3; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type PageNumberModel");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_PAGENUMBER = table.getColumnIndex("pageNumber");
            INDEX_LINK = table.getColumnIndex("link");
            INDEX_ISLOADED = table.getColumnIndex("isloaded");

            if (!columnTypes.containsKey("pageNumber")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'pageNumber'");
            }
            if (columnTypes.get("pageNumber") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'pageNumber'");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("pageNumber")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'pageNumber'");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("pageNumber"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'pageNumber'");
            }
            if (!columnTypes.containsKey("link")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'link'");
            }
            if (columnTypes.get("link") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'link'");
            }
            if (!columnTypes.containsKey("isloaded")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'isloaded'");
            }
            if (columnTypes.get("isloaded") != ColumnType.BOOLEAN) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'boolean' for field 'isloaded'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The PageNumberModel class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_PageNumberModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static PageNumberModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        PageNumberModel obj = null;
        if (update) {
            Table table = realm.getTable(PageNumberModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("pageNumber")) {
                long rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("pageNumber"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new PageNumberModelRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getUncheckedRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(PageNumberModel.class);
        }
        if (!json.isNull("pageNumber")) {
            obj.setPageNumber((int) json.getInt("pageNumber"));
        }
        if (json.has("link")) {
            if (json.isNull("link")) {
                obj.setLink("");
            } else {
                obj.setLink((String) json.getString("link"));
            }
        }
        if (!json.isNull("isloaded")) {
            obj.setIsloaded((boolean) json.getBoolean("isloaded"));
        }
        return obj;
    }

    public static PageNumberModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        PageNumberModel obj = realm.createObject(PageNumberModel.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("pageNumber") && reader.peek() != JsonToken.NULL) {
                obj.setPageNumber((int) reader.nextInt());
            } else if (name.equals("link")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setLink("");
                    reader.skipValue();
                } else {
                    obj.setLink((String) reader.nextString());
                }
            } else if (name.equals("isloaded")  && reader.peek() != JsonToken.NULL) {
                obj.setIsloaded((boolean) reader.nextBoolean());
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static PageNumberModel copyOrUpdate(Realm realm, PageNumberModel object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        PageNumberModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(PageNumberModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = table.findFirstLong(pkColumnIndex, object.getPageNumber());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new PageNumberModelRealmProxy();
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

    public static PageNumberModel copy(Realm realm, PageNumberModel newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        PageNumberModel realmObject = realm.createObject(PageNumberModel.class, newObject.getPageNumber());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setPageNumber(newObject.getPageNumber());
        realmObject.setLink(newObject.getLink() != null ? newObject.getLink() : "");
        realmObject.setIsloaded(newObject.isloaded());
        return realmObject;
    }

    static PageNumberModel update(Realm realm, PageNumberModel realmObject, PageNumberModel newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setLink(newObject.getLink() != null ? newObject.getLink() : "");
        realmObject.setIsloaded(newObject.isloaded());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PageNumberModel = [");
        stringBuilder.append("{pageNumber:");
        stringBuilder.append(getPageNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{link:");
        stringBuilder.append(getLink());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{isloaded:");
        stringBuilder.append(isloaded());
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
        PageNumberModelRealmProxy aPageNumberModel = (PageNumberModelRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aPageNumberModel.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aPageNumberModel.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aPageNumberModel.row.getIndex()) return false;

        return true;
    }

}
