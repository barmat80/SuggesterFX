package com.maemlab.suggesterfx.data.beans.autocompletion;

import com.maemlab.suggesterfx.exception.FXException;
import com.maemlab.suggesterfx.mvci.Interactor;
import com.maemlab.suggesterfx.widgets.autocompletion.AutoCompletionBinding;
import javafx.util.Callback;

import java.util.Collection;

public class StringSuggesterCallback implements Callback<AutoCompletionBinding.ISuggestionRequest, Collection<String>> {
    private final Interactor interactor;

    public StringSuggesterCallback(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public Collection<String> call(AutoCompletionBinding.ISuggestionRequest request) {
        try {
            return interactor.fetchNames(request.getUserText());
        } catch (FXException e) {
            throw new RuntimeException(e);
        }
    }
}
