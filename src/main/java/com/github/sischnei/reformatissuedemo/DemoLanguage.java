package com.github.sischnei.reformatissuedemo;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class DemoLanguage extends Language {
    public static final DemoLanguage INSTANCE = new DemoLanguage();

    public DemoLanguage() {
        super("DemoLanguage");
    }
}
