package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.anh.deton.Model.ChapterModel;
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

public class ChapterModelRealmProxy extends ChapterModel
    implements RealmObjectProxy {

    private static long INDEX_ID;
    private static long INDEX_STORYID;
    private static long INDEX_CHAPTERNUMBER;
    private static long INDEX_PAGENUMBER;
    private static long INDEX_CHAPTERNAME;
    private static long INDEX_SHOWNAME;
    private static long INDEX_CONTENT;
    private static Map<String, Long> columnIndices;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("storyId");
        fieldNames.add("chapterNumber");
        fieldNames.add("pageNumber");
        fieldNames.add("chapterName");
        fieldNames.add("showName");
        fieldNames.add("content");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    @Override
    public String getId() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_ID);
    }

    @Override
    public void setId(String value) {
        realm.checkIfValid();
        row.setString(INDEX_ID, (String) value);
    }

    @Override
    public int getStoryId() {
        realm.checkIfValid();
        return (int) row.getLong(INDEX_STORYID);
    }

    @Override
    public void setStoryId(int value) {
        realm.checkIfValid();
        row.setLong(INDEX_STORYID, (long) value);
    }

    @Override
    public String getChapterNumber() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CHAPTERNUMBER);
    }

    @Override
    public void setChapterNumber(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CHAPTERNUMBER, (String) value);
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
    public String getChapterName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CHAPTERNAME);
    }

    @Override
    public void setChapterName(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CHAPTERNAME, (String) value);
    }

    @Override
    public String getShowName() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_SHOWNAME);
    }

    @Override
    public void setShowName(String value) {
        realm.checkIfValid();
        row.setString(INDEX_SHOWNAME, (String) value);
    }

    @Override
    public String getContent() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(INDEX_CONTENT);
    }

    @Override
    public void setContent(String value) {
        realm.checkIfValid();
        row.setString(INDEX_CONTENT, (String) value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_ChapterModel")) {
            Table table = transaction.getTable("class_ChapterModel");
            table.addColumn(ColumnType.STRING, "id");
            table.addColumn(ColumnType.INTEGER, "storyId");
            table.addColumn(ColumnType.STRING, "chapterNumber");
            table.addColumn(ColumnType.INTEGER, "pageNumber");
            table.addColumn(ColumnType.STRING, "chapterName");
            table.addColumn(ColumnType.STRING, "showName");
            table.addColumn(ColumnType.STRING, "content");
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return transaction.getTable("class_ChapterModel");
    }

    public static void validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_ChapterModel")) {
            Table table = transaction.getTable("class_ChapterModel");
            if (table.getColumnCount() != 7) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 7 but was " + table.getColumnCount());
            }
            Map<String, ColumnType> columnTypes = new HashMap<String, ColumnType>();
            for (long i = 0; i < 7; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            columnIndices = new HashMap<String, Long>();
            for (String fieldName : getFieldNames()) {
                long index = table.getColumnIndex(fieldName);
                if (index == -1) {
                    throw new RealmMigrationNeededException(transaction.getPath(), "Field '" + fieldName + "' not found for type ChapterModel");
                }
                columnIndices.put(fieldName, index);
            }
            INDEX_ID = table.getColumnIndex("id");
            INDEX_STORYID = table.getColumnIndex("storyId");
            INDEX_CHAPTERNUMBER = table.getColumnIndex("chapterNumber");
            INDEX_PAGENUMBER = table.getColumnIndex("pageNumber");
            INDEX_CHAPTERNAME = table.getColumnIndex("chapterName");
            INDEX_SHOWNAME = table.getColumnIndex("showName");
            INDEX_CONTENT = table.getColumnIndex("content");

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'id'");
            }
            if (columnTypes.get("id") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'id'");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field 'id'");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field 'id'");
            }
            if (!columnTypes.containsKey("storyId")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'storyId'");
            }
            if (columnTypes.get("storyId") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'storyId'");
            }
            if (!columnTypes.containsKey("chapterNumber")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'chapterNumber'");
            }
            if (columnTypes.get("chapterNumber") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'chapterNumber'");
            }
            if (!columnTypes.containsKey("pageNumber")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'pageNumber'");
            }
            if (columnTypes.get("pageNumber") != ColumnType.INTEGER) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'int' for field 'pageNumber'");
            }
            if (!columnTypes.containsKey("chapterName")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'chapterName'");
            }
            if (columnTypes.get("chapterName") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'chapterName'");
            }
            if (!columnTypes.containsKey("showName")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'showName'");
            }
            if (columnTypes.get("showName") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'showName'");
            }
            if (!columnTypes.containsKey("content")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'content'");
            }
            if (columnTypes.get("content") != ColumnType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'content'");
            }
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The ChapterModel class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ChapterModel";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static Map<String,Long> getColumnIndices() {
        return columnIndices;
    }

    public static ChapterModel createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        ChapterModel obj = null;
        if (update) {
            Table table = realm.getTable(ChapterModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (!json.isNull("id")) {
                long rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
                if (rowIndex != TableOrView.NO_MATCH) {
                    obj = new ChapterModelRealmProxy();
                    obj.realm = realm;
                    obj.row = table.getUncheckedRow(rowIndex);
                }
            }
        }
        if (obj == null) {
            obj = realm.createObject(ChapterModel.class);
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                obj.setId("");
            } else {
                obj.setId((String) json.getString("id"));
            }
        }
        if (!json.isNull("storyId")) {
            obj.setStoryId((int) json.getInt("storyId"));
        }
        if (json.has("chapterNumber")) {
            if (json.isNull("chapterNumber")) {
                obj.setChapterNumber("");
            } else {
                obj.setChapterNumber((String) json.getString("chapterNumber"));
            }
        }
        if (!json.isNull("pageNumber")) {
            obj.setPageNumber((int) json.getInt("pageNumber"));
        }
        if (json.has("chapterName")) {
            if (json.isNull("chapterName")) {
                obj.setChapterName("");
            } else {
                obj.setChapterName((String) json.getString("chapterName"));
            }
        }
        if (json.has("showName")) {
            if (json.isNull("showName")) {
                obj.setShowName("");
            } else {
                obj.setShowName((String) json.getString("showName"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                obj.setContent("");
            } else {
                obj.setContent((String) json.getString("content"));
            }
        }
        return obj;
    }

    public static ChapterModel createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        ChapterModel obj = realm.createObject(ChapterModel.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setId("");
                    reader.skipValue();
                } else {
                    obj.setId((String) reader.nextString());
                }
            } else if (name.equals("storyId")  && reader.peek() != JsonToken.NULL) {
                obj.setStoryId((int) reader.nextInt());
            } else if (name.equals("chapterNumber")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setChapterNumber("");
                    reader.skipValue();
                } else {
                    obj.setChapterNumber((String) reader.nextString());
                }
            } else if (name.equals("pageNumber")  && reader.peek() != JsonToken.NULL) {
                obj.setPageNumber((int) reader.nextInt());
            } else if (name.equals("chapterName")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setChapterName("");
                    reader.skipValue();
                } else {
                    obj.setChapterName((String) reader.nextString());
                }
            } else if (name.equals("showName")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setShowName("");
                    reader.skipValue();
                } else {
                    obj.setShowName((String) reader.nextString());
                }
            } else if (name.equals("content")) {
                if (reader.peek() == JsonToken.NULL) {
                    obj.setContent("");
                    reader.skipValue();
                } else {
                    obj.setContent((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static ChapterModel copyOrUpdate(Realm realm, ChapterModel object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        ChapterModel realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(ChapterModel.class);
            long pkColumnIndex = table.getPrimaryKey();
            if (object.getId() == null) {
                throw new IllegalArgumentException("Primary key value must not be null.");
            }
            long rowIndex = table.findFirstString(pkColumnIndex, object.getId());
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new ChapterModelRealmProxy();
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

    public static ChapterModel copy(Realm realm, ChapterModel newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        ChapterModel realmObject = realm.createObject(ChapterModel.class, newObject.getId());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setId(newObject.getId() != null ? newObject.getId() : "");
        realmObject.setStoryId(newObject.getStoryId());
        realmObject.setChapterNumber(newObject.getChapterNumber() != null ? newObject.getChapterNumber() : "");
        realmObject.setPageNumber(newObject.getPageNumber());
        realmObject.setChapterName(newObject.getChapterName() != null ? newObject.getChapterName() : "");
        realmObject.setShowName(newObject.getShowName() != null ? newObject.getShowName() : "");
        realmObject.setContent(newObject.getContent() != null ? newObject.getContent() : "");
        return realmObject;
    }

    static ChapterModel update(Realm realm, ChapterModel realmObject, ChapterModel newObject, Map<RealmObject, RealmObjectProxy> cache) {
        realmObject.setStoryId(newObject.getStoryId());
        realmObject.setChapterNumber(newObject.getChapterNumber() != null ? newObject.getChapterNumber() : "");
        realmObject.setPageNumber(newObject.getPageNumber());
        realmObject.setChapterName(newObject.getChapterName() != null ? newObject.getChapterName() : "");
        realmObject.setShowName(newObject.getShowName() != null ? newObject.getShowName() : "");
        realmObject.setContent(newObject.getContent() != null ? newObject.getContent() : "");
        return realmObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ChapterModel = [");
        stringBuilder.append("{id:");
        stringBuilder.append(getId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{storyId:");
        stringBuilder.append(getStoryId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{chapterNumber:");
        stringBuilder.append(getChapterNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pageNumber:");
        stringBuilder.append(getPageNumber());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{chapterName:");
        stringBuilder.append(getChapterName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{showName:");
        stringBuilder.append(getShowName());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(getContent());
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
        ChapterModelRealmProxy aChapterModel = (ChapterModelRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aChapterModel.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aChapterModel.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aChapterModel.row.getIndex()) return false;

        return true;
    }

}
