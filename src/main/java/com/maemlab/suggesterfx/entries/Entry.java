package com.maemlab.suggesterfx.entries;

import java.util.List;

/**
 * Interface representing a data entity with primary keys and description.
 * This interface defines the basic contract for entities that can be used with
 * the suggestion/autocompletion system.
 *
 * <p>The Entry interface provides:
 * <ul>
 *   <li>Access to entity primary keys (supports composite keys).
 *   <li>Descriptive text for display purposes.
 * </ul>
 */
public interface Entry {
    /**
     * Returns the primary key values for this entity.
     * <p>Supports composite keys by returning a list of key values.
     *
     * @return a list of Integer values representing the primary key(s)
     */
    List<Integer> getPKs();

    /**
     * Returns a human-readable description of this entity.
     * <p>This description is typically used for display in suggestion lists
     * and autocomplete fields.
     *
     * @return a string description of the entity
     */
    String getDescription();
}
