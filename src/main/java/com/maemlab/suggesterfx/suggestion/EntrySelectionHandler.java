package com.maemlab.suggesterfx.suggestion;

import com.maemlab.suggesterfx.entries.Entry;
import com.maemlab.suggesterfx.controlsfx.autocompletion.textfield.AutoCompletionBinding;
import com.maemlab.suggesterfx.mvci.SuggestionInteractor;
import javafx.event.EventHandler;

/**
 * Handles selection events from auto-completion text fields for {@link Entry} objects.
 * This handler processes the selection of {@link Entry} suggestions and updates the underlying
 * model through the {@link SuggestionInteractor}.
 *
 * <p>When a user selects a suggestion from the auto-completion list, this handler
 * ensures that the selected {@link Entry} is properly processed and the model is updated
 * accordingly through the interactor.
 */
public class EntrySelectionHandler implements EventHandler<AutoCompletionBinding.AutoCompletionEvent<Entry>> {

    private final SuggestionInteractor interactor;

    /**
     * Creates a new EntrySelectionHandler with the specified interactor.
     *
     * @param interactor The {@link SuggestionInteractor} that will process selected entries
     */
    public EntrySelectionHandler(SuggestionInteractor interactor) {
        this.interactor = interactor;
    }

    /**
     * Processes an auto-completion selection event by updating the model with the selected {@link Entry}.
     * If no interactor is available, the selection will be ignored.
     *
     * @param event The auto-completion event containing the selected Entry
     */
    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<Entry> event) {
        Entry entry = event.getCompletion();
        if(interactor != null) {
            interactor.updateModelAfterSuggestion(entry);
        }
    }
}
