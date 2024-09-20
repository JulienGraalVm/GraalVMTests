package org.rcs.graalvm.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
class DemoLocaleUtilsTest {
    @Test
    public void testGetResourceBundleLocales() {
        log.debug("starting test test_GetResourceBundleLocales");
        // WHEN
        var locales = DemoLocaleUtils.getResourceBundleLocales("locale/test");

        // THEN
        var expectedLocales = new String[] { "de", "en_UK", "fr_CA", "en", "fr_FR", "en_US", "fr_FR_ch" };

        assertEquals(expectedLocales.length, locales.size(), "failed to load test locales");
        for (var expectedLocale : expectedLocales) {
            assertTrue(locales.toString().contains(expectedLocale));
        }
    }
}