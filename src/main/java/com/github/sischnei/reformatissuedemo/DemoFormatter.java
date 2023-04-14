package com.github.sischnei.reformatissuedemo;

import com.intellij.formatting.service.AsyncDocumentFormattingService;
import com.intellij.formatting.service.AsyncFormattingRequest;
import com.intellij.formatting.service.FormattingService;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiFile;
import java.util.EnumSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DemoFormatter extends AsyncDocumentFormattingService {

    public static final String NOTIFICATION_GROUP_ID = "DEMO_ID";

    private static final Set<Feature> FEATURES = EnumSet.noneOf(Feature.class);

    @Override
    protected @Nullable FormattingTask createFormattingTask(@NotNull final AsyncFormattingRequest formattingRequest) {
        return new FormattingTask() {
            @Override
            public boolean cancel() {
                return false;
            }

            @Override
            public void run() {
                try {
                    //Dummy formatting, transforms text like "abcd,1234" into "abcd,\n1234" - works on individual files, but for some reason not when
                    //reformatting an entire folder see https://intellij-support.jetbrains.com/hc/en-us/community/posts/10941363689106-FormattingService-implementing-AsyncDocumentFormattingService-not-invoked-on-mass-reformat-save-action
                    final String text = formattingRequest.getDocumentText();
                    final String formattedText = text.replace(",", ",\n");
                    formattingRequest.onTextReady(formattedText);
                } catch (Exception ex) {
                    formattingRequest.onError("Failed to format " + getName(), ex.getMessage());
                }
            }
        };
    }
    @Override
    protected @NotNull @NlsSafe String getName() {
        return "Demo File format";
    }

    @Override
    public @NotNull Set<Feature> getFeatures() {
        return FEATURES;
    }

    @Override
    public boolean canFormat(@NotNull final PsiFile file) {
        return file instanceof DemoFile;
    }

    @Override
    protected @NotNull String getNotificationGroupId() {
        return NOTIFICATION_GROUP_ID;
    }
}
