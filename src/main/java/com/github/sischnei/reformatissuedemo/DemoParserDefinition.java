package com.github.sischnei.reformatissuedemo;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.EmptyLexer;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import java.util.EnumSet;
import org.intellij.lang.regexp.RegExpCapability;
import org.intellij.lang.regexp.RegExpParser;
import org.jetbrains.annotations.NotNull;

public class DemoParserDefinition implements ParserDefinition {

    private static final IFileElementType FILE = new IFileElementType(DemoLanguage.INSTANCE);

    @Override
    public @NotNull Lexer createLexer(final Project project) {
        return new EmptyLexer();
    }

    @Override
    public @NotNull PsiParser createParser(final Project project) {
        return new RegExpParser(EnumSet.noneOf(RegExpCapability.class));
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @Override
    public @NotNull PsiElement createElement(final ASTNode node) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull final FileViewProvider viewProvider) {
        return new DemoFile(viewProvider);
    }
}
