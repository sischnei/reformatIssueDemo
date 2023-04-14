package com.github.sischnei.reformatissuedemo;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import javax.swing.Icon;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class DemoFileType extends LanguageFileType {

    public static final DemoFileType INSTANCE = new DemoFileType();

    public DemoFileType() {
        super(DemoLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Demo file";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Demo file description";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "demo";
    }

    @Override
    public Icon getIcon() {
        return null;
    }
}
