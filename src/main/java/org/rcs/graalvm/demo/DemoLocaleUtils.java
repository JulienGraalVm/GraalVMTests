package org.rcs.graalvm.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class DemoLocaleUtils {

    public static Set<Locale> getResourceBundleLocales(String basename) {
        log.debug("basename: {}", basename);

        File directory;
        var resourceLoader = new DefaultResourceLoader(); // the default one used by ReloadableResourceBundleMessageSource

        // retrieve directory
        var index = basename.lastIndexOf("/");
        var dir = basename.substring(0, Math.max(0, index));
        var prefix = basename.substring(index + 1);

        try {
            directory = resourceLoader.getResource(dir).getFile();
            Assert.isTrue(directory.exists(), "ResourceLoader cannot find any " + dir + " directory.");
        } catch (Exception ex) {
            log.warn("ResourceLoader cannot find any '{}' directory.", dir, ex);
            return Set.of();
        }

        var pattern = Pattern.compile("^" + prefix + "(_\\w*)?" + "[.](properties|xml)$");

        var files = directory.listFiles();
        log.debug("files to be loaded under '{}' folder: '{}'", directory, files != null ? files.length : 0);

        return Arrays.stream(Objects.requireNonNull(files))
            // get all files matching resource bundle regexp
            .map(file -> pattern.matcher(file.getName()))
            .filter(Matcher::find)
            // then parse language group to locale
            .map(matcher -> parseLocale(matcher.group(1)))
            // and finally keep valid locale
            .filter(Objects::nonNull)
            .collect(Collectors.toSet());
    }

    private static Locale parseLocale(String str) {
        log.debug("parsing locale '{}'", str);

        // case of 'message.properties'
        if (StringUtils.isEmpty(str)) {
            return LocaleUtils.toLocale(StringUtils.EMPTY);
        }

        // remove first '_'
        if (str.charAt(0) == '_') {
            str = str.substring(1);
        }

        // try to parse locale
        try {
            return LocaleUtils.toLocale(str);
        } catch (Exception e) {
            log.debug("failed to parse locale: '{}'", str, e);
            return null;
        }
    }

}
