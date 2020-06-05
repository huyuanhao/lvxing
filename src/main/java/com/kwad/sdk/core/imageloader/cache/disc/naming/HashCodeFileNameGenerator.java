package com.kwad.sdk.core.imageloader.cache.disc.naming;

public class HashCodeFileNameGenerator implements FileNameGenerator {
    public String generate(String str) {
        return String.valueOf(str.hashCode());
    }
}
