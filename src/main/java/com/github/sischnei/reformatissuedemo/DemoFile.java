package com.github.sischnei.reformatissuedemo;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class DemoFile extends PsiFileBase {

    public DemoFile(final @NotNull FileViewProvider viewProvider) {
        super(viewProvider, DemoLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return DemoFileType.INSTANCE;
    }
}
