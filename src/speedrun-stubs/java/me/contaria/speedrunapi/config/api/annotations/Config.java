package me.contaria.speedrunapi.config.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Minimal compile-time stub of the Speedrun API's Config annotation hierarchy
 * to allow compiling the mod when the real Speedrun API isn't present.
 * This should be removed when compiling with the real API.
 */
public @interface Config {
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Boolean {
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface Default {
            boolean value();
        }
    }
}
