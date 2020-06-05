package com.p522qq.taf.jce.dynamic;

import com.p522qq.taf.jce.JceDecodeException;
import com.p522qq.taf.jce.JceOutputStream;
import com.p522qq.taf.jce.JceStruct;
import java.nio.ByteBuffer;

/* renamed from: com.qq.taf.jce.dynamic.DynamicOutputStream */
public final class DynamicOutputStream extends JceOutputStream {
    public DynamicOutputStream() {
    }

    public DynamicOutputStream(int i) {
        super(i);
    }

    public DynamicOutputStream(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public void write(JceField jceField) {
        int tag = jceField.getTag();
        int i = 0;
        if (jceField instanceof ZeroField) {
            write(0, tag);
        } else if (jceField instanceof IntField) {
            write(((IntField) jceField).get(), tag);
        } else if (jceField instanceof ShortField) {
            write(((ShortField) jceField).get(), tag);
        } else if (jceField instanceof ByteField) {
            write(((ByteField) jceField).get(), tag);
        } else if (jceField instanceof StringField) {
            write(((StringField) jceField).get(), tag);
        } else if (jceField instanceof ByteArrayField) {
            write(((ByteArrayField) jceField).get(), tag);
        } else if (jceField instanceof ListField) {
            ListField listField = (ListField) jceField;
            reserve(8);
            writeHead(9, tag);
            write(listField.size(), 0);
            JceField[] jceFieldArr = listField.get();
            int length = jceFieldArr.length;
            while (i < length) {
                write(jceFieldArr[i]);
                i++;
            }
        } else if (jceField instanceof MapField) {
            MapField mapField = (MapField) jceField;
            reserve(8);
            writeHead(8, tag);
            int size = mapField.size();
            write(size, 0);
            while (i < size) {
                write(mapField.getKey(i));
                write(mapField.getValue(i));
                i++;
            }
        } else if (jceField instanceof StructField) {
            StructField structField = (StructField) jceField;
            reserve(2);
            writeHead(10, tag);
            for (JceField write : structField.get()) {
                write(write);
            }
            reserve(2);
            writeHead(JceStruct.STRUCT_END, 0);
        } else if (jceField instanceof LongField) {
            write(((LongField) jceField).get(), tag);
        } else if (jceField instanceof FloatField) {
            write(((FloatField) jceField).get(), tag);
        } else if (jceField instanceof DoubleField) {
            write(((DoubleField) jceField).get(), tag);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("unknow JceField type: ");
            sb.append(jceField.getClass().getName());
            throw new JceDecodeException(sb.toString());
        }
    }
}
