package com.hazelcast.nio.serialization;

import com.hazelcast.nio.ObjectDataInput;

import java.io.IOException;

class InvalidRawDataPortable2 extends RawDataPortable {

    InvalidRawDataPortable2() {
    }

    InvalidRawDataPortable2(long l, char[] c, NamedPortable p, int k, String s, ByteArrayDataSerializable sds) {
        super(l, c, p, k, s, sds);
    }

    @Override
    public int getClassId() {
        return TestSerializationConstants.INVALID_RAW_DATA_PORTABLE_2;
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        c = reader.readCharArray("c");
        final ObjectDataInput input = reader.getRawDataInput();
        k = input.readInt();
        l = reader.readLong("l");
        s = input.readUTF();
        p = reader.readPortable("p");
        sds = input.readObject();
    }
}
