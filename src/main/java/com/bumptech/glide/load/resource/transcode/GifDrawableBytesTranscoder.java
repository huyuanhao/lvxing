package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;

public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    public Resource<byte[]> transcode(Resource<GifDrawable> uVar, Options fVar) {
        return new BytesResource(ByteBufferUtil.m6090a(((GifDrawable) uVar.get()).getBuffer()));
    }
}
