package com.maemlab.suggesterfx.suggestion;

import com.maemlab.mvcifx.exception.MVCIException;
import com.maemlab.suggesterfx.entries.Entry;
import com.maemlab.suggesterfx.mvci.SuggestionInteractor;
import com.maemlab.suggesterfx.controlsfx.autocompletion.textfield.AutoCompletionBinding;
import javafx.util.Callback;

import java.util.Collection;

/**
 * Provides String suggestions for auto-completion text fields based on user input.
 * This callback fetches relevant String suggestions through a {@link SuggestionInteractor}
 * when users type in an auto-completion-enabled text field.
 *
 * <p>Unlike {@link EntrySuggesterCallback} which provides full {@link Entry} objects,
 * this callback returns simple strings, making it suitable for simpler
 * auto-completion scenarios where only text matching is needed.
 */
public class StringSuggesterCallback implements Callback<AutoCompletionBinding.ISuggestionRequest, Collection<String>> {
    private final SuggestionInteractor interactor;

    /**
     * Creates a new StringSuggesterCallback with the specified interactor.
     *
     * @param interactor The {@link SuggestionInteractor} that will fetch String suggestions
     */
    public StringSuggesterCallback(SuggestionInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * Retrieves String suggestions based on the user's input text.
     * Delegates the actual fetching of suggestions to the interactor, calling {@link SuggestionInteractor#fetchNames(String)}.
     *
     * @param request The suggestion request containing the user's input text
     * @return A collection of String suggestions matching the user's input
     * @throws RuntimeException if there's an error fetching the suggestions
     */
    @Override
    public Collection<String> call(AutoCompletionBinding.ISuggestionRequest request) {
        try {
            return interactor.fetchNames(request.getUserText());
        } catch (MVCIException e) {
            throw new RuntimeException(e);
        }
    }
}
