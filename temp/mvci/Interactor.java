package com.maemlab.suggesterfx.mvci;

import com.maemlab.suggesterfx.data.beans.Bean;
import com.maemlab.suggesterfx.data.beans.suggestion.BeanSuggesterCallback;
import com.maemlab.suggesterfx.exception.FXException;

import java.beans.Beans;
import java.util.Collection;

public interface Interactor {
    /**
     * Retrieves all available data without any specific filtering.
     *
     * @throws FXException if data retrieval fails
     */
    void fetchData() throws FXException;

    /**
     * Retrieves data based on a user's suggestion or partial input.
     * Typically, is used in combination with {@link BeanSuggesterCallback}.
     *
     * @param suggest a partial string input used to filter or autocomplete data
     * @return a collection of {@link Beans} objects matching the suggestion criteria
     * @throws FXException if data retrieval fails
     */
    Collection<Bean> fetchData(String suggest) throws FXException;

    /**
     * Retrieves a list of names matching a user's suggestion or partial input
     *
     * @param suggest a partial string input used to filter name suggestion
     * @return a collection of names matching the suggestion criteria
     * @throws FXException if data retrieval fails
     */
    Collection<String> fetchNames(String suggest) throws FXException;

    /**
     * Updates the underlying model after a standard data fetch operation.
     * Typically used to refresh UI components or internal state after data retrieval.
     */
    void updateModelAfterFetchingData();

    /**
     * Updates the underlying model after an autocompletion is done.
     *
     * @param bean the bean fetch
     */
    void updateModelAfterAutocompletion(Bean bean);
}
