package com.pushtorefresh.storio.contentresolver.annotations;

import android.database.Cursor;
import android.support.annotation.NonNull;
import com.pushtorefresh.storio.contentresolver.operations.get.DefaultGetResolver;
import java.lang.Override;
import java.lang.String;

/**
 * Generated resolver for Get Operation.
 */
public class PrimitiveMethodsFactoryMethodStorIOContentResolverGetResolver extends DefaultGetResolver<PrimitiveMethodsFactoryMethod> {
    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public PrimitiveMethodsFactoryMethod mapFromCursor(@NonNull Cursor cursor) {

        boolean field1 = cursor.getInt(cursor.getColumnIndex("field1")) == 1;
        short field2 = cursor.getShort(cursor.getColumnIndex("field2"));
        int field3 = cursor.getInt(cursor.getColumnIndex("field3"));
        long field4 = cursor.getLong(cursor.getColumnIndex("field4"));
        float field5 = cursor.getFloat(cursor.getColumnIndex("field5"));
        double field6 = cursor.getDouble(cursor.getColumnIndex("field6"));
        String field7 = cursor.getString(cursor.getColumnIndex("field7"));
        byte[] field8 = cursor.getBlob(cursor.getColumnIndex("field8"));

        PrimitiveMethodsFactoryMethod object = PrimitiveMethodsFactoryMethod.create(field1, field2, field3, field4, field5, field6, field7, field8);

        return object;
    }
}
