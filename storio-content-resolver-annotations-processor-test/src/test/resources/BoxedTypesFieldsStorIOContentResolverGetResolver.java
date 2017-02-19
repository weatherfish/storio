package com.pushtorefresh.storio.contentresolver.annotations;

import android.database.Cursor;
import android.support.annotation.NonNull;
import com.pushtorefresh.storio.contentresolver.operations.get.DefaultGetResolver;
import java.lang.Override;
/**
 * Generated resolver for Get Operation.
 */
public class BoxedTypesFieldsStorIOContentResolverGetResolver extends DefaultGetResolver<BoxedTypesFields> {
    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public BoxedTypesFields mapFromCursor(@NonNull Cursor cursor) {
        BoxedTypesFields object = new BoxedTypesFields();

        if (!cursor.isNull(cursor.getColumnIndex("field1"))) {
            object.field1 = cursor.getInt(cursor.getColumnIndex("field1")) == 1;
        }
        if (!cursor.isNull(cursor.getColumnIndex("field6"))) {
            object.field6 = cursor.getDouble(cursor.getColumnIndex("field6"));
        }
        if (!cursor.isNull(cursor.getColumnIndex("field3"))) {
            object.field3 = cursor.getInt(cursor.getColumnIndex("field3"));
        }
        if (!cursor.isNull(cursor.getColumnIndex("field2"))) {
            object.field2 = cursor.getShort(cursor.getColumnIndex("field2"));
        }
        if (!cursor.isNull(cursor.getColumnIndex("field5"))) {
            object.field5 = cursor.getFloat(cursor.getColumnIndex("field5"));
        }
        if (!cursor.isNull(cursor.getColumnIndex("field4"))) {
            object.field4 = cursor.getLong(cursor.getColumnIndex("field4"));
        }

        return object;
    }
}
