package com.maemlab.suggesterfx.mvci;

import com.maemlab.mvcifx.exception.MVCIException;
import com.maemlab.mvcifx.mvci.Interactor;
import com.maemlab.suggesterfx.entries.Entry;
import com.maemlab.suggesterfx.suggestion.EntrySuggesterCallback;

import java.util.Collection;

/**
 * Abstract interactor class specialized for handling data suggestions and autocompletion operations.
 * This class extends the MVCI framework to support suggestion-based data retrieval and updates,
 * typically used with autocomplete text fields.
 *
 * <p>The SuggestionInteractor provides a framework for:
 * <ul>
 *   <li>Fetching data based on partial user input
 *   <li>Retrieving suggestion names for autocompletion
 *   <li>Updating models after successful autocompletion
 * </ul>
 *
 * <p>This class is designed to work in conjunction with autocomplete text field components
 * and the {@link EntrySuggesterCallback} interface for handling suggestion selections.
 *
 * @see Entry
 * @see EntrySuggesterCallback
 */
public abstract class SuggestionInteractor implements Interactor {
    /**
     * Retrieves entries based on a user's suggestion or partial input.
     * <p>Typically, is used in combination with {@link EntrySuggesterCallback} and it's called when users type in an autocomplete field,
     * returning matching {@link Entry} objects based on the input.
     *
     * @param suggest a partial string input used to filter or autocomplete data
     * @return a collection of {@link Entry} objects matching the suggestion criteria
     * @throws MVCIException if data retrieval fails
     */
    public abstract Collection<Entry> fetchEntries(String suggest) throws MVCIException;

    /**
     * Retrieves a list of names matching a user's suggestion or partial input.
     * <p>This method is typically used for implementing auto-complete or search suggestion features.
     *
     * @param suggest a partial string input used to filter name suggestion
     * @return a collection of names matching the suggestion criteria
     * @throws MVCIException if data retrieval fails
     */
    public abstract Collection<String> fetchNames(String suggest) throws MVCIException;

    /**
     * Updates the underlying model after an autocompletion is done.
     * <p>This method is called when a user selects a suggestion from the autocomplete list,
     * allowing the model to be updated with the complete data associated with the selection.
     * @param entry the entry fetched
     */
    public abstract void updateModelAfterSuggestion(Entry entry);
}
