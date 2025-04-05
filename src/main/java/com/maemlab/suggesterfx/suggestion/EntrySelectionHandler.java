package com.maemlab.suggesterfx.suggestion;

import com.maemlab.mvcifx.mvci.Model;
import com.maemlab.suggesterfx.entries.Entry;
import com.maemlab.suggesterfx.controlsfx.autocompletion.textfield.AutoCompletionBinding;
import com.maemlab.suggesterfx.mvci.SuggestionInteractor;
import javafx.event.EventHandler;

/**
 * Handles selection events from autocompletion text fields for {@link Entry} objects.
 * <p>This handler processes the selection of {@link Entry} suggestions and updates the underlying
 * {@link Model} through a {@link SuggestionInteractor}.
 *
 * <p>When a user selects a suggestion from the autocompletion list, this handler
 * ensures that the selected {@link Entry} is properly processed and the model is updated
 * accordingly through the interactor.
 *
 * @param <M> The type of {@link Model} this handler uses
 *
 * @see Model
 * @see SuggestionInteractor
 */
public class EntrySelectionHandler<M extends Model> implements EventHandler<AutoCompletionBinding.AutoCompletionEvent<Entry>> {

    private final SuggestionInteractor<M> interactor;

    /**
     * Creates a new EntrySelectionHandler with the specified interactor.
     *
     * @param interactor The {@link SuggestionInteractor} that will process selected entries
     */
    public EntrySelectionHandler(SuggestionInteractor<M> interactor) {
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
