package com.maemlab.suggesterfx.data.beans.autocompletion;

import com.maemlab.suggesterfx.data.beans.Bean;
import com.maemlab.suggesterfx.exception.FXException;
import com.maemlab.suggesterfx.mvci.Interactor;
import com.maemlab.suggesterfx.widgets.autocompletion.AutoCompletionBinding;
import javafx.util.Callback;

import java.util.Collection;

public class BeanSuggesterCallback implements Callback<AutoCompletionBinding.ISuggestionRequest, Collection<Bean>> {
    private final Interactor interactor;

    public BeanSuggesterCallback(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public Collection<Bean> call(AutoCompletionBinding.ISuggestionRequest request) {
        try {
            return interactor.fetchData(request.getUserText());
        } catch (FXException e) {
            throw new RuntimeException(e);
        }
    }
}
