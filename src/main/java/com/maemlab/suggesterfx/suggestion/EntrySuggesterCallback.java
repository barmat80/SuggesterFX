package com.maemlab.suggesterfx.suggestion;

import com.maemlab.mvcifx.exception.MVCIException;
import com.maemlab.suggesterfx.entries.Entry;
import com.maemlab.suggesterfx.mvci.SuggestionInteractor;
import com.maemlab.suggesterfx.controlsfx.autocompletion.textfield.AutoCompletionBinding;
import javafx.util.Callback;

import java.util.Collection;

/**
 * Provides {@link Entry} suggestions for auto-completion text fields based on user input.
 * This callback fetches relevant {@link Entry} suggestions through a {@link SuggestionInteractor}
 * when users type in an auto-completion-enabled text field.
 *
 * <p>The callback converts user input into a collection of matching {@link Entry} objects
 * that can be displayed as suggestions in the auto-completion popup.
 */
public class EntrySuggesterCallback implements Callback<AutoCompletionBinding.ISuggestionRequest, Collection<Entry>> {
    private final SuggestionInteractor interactor;

    /**
     * Creates a new EntrySuggesterCallback with the specified interactor.
     *
     * @param interactor The {@link SuggestionInteractor} that will fetch {@link Entry} suggestions
     */
    public EntrySuggesterCallback(SuggestionInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * Retrieves {@link Entry} suggestions based on the user's input text.
     * Delegates the actual fetching of suggestions to the interactor, calling {@link SuggestionInteractor#fetchEntries(String)}.
     *
     * @param request The suggestion request containing the user's input text
     * @return A collection of {@link Entry} suggestions matching the user's input
     * @throws RuntimeException if there's an error fetching the suggestions
     */
    @Override
    public Collection<Entry> call(AutoCompletionBinding.ISuggestionRequest request) {
        try {
            return interactor.fetchEntries(request.getUserText());
        } catch (MVCIException e) {
            throw new RuntimeException(e);
        }
    }
}
