package com.maemlab.suggesterfx.suggestion;

import com.maemlab.suggesterfx.entries.Entry;
import javafx.util.StringConverter;

/**
 * Converts between {@link Entry} objects and their string representations for use in JavaFX components.
 * This converter is specifically designed to work with auto-completion components,
 * providing string representations of {@link Entry} objects for display purposes.
 *
 * <p>The converter implements one-way conversion from Entry to String, using the Entry's
 * description as its string representation. The reverse conversion (String to Entry)
 * is not supported and will return null.
 */
public class EntryConverter extends StringConverter<Entry> {
    /**
     * Converts an Entry object to its string representation, calling {@link Entry#getDescription}.
     *
     * @param entry The {@link Entry} object to convert
     * @return The description of the Entry, or null if the input Entry is null
     */
    @Override
    public String toString(Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getDescription();
    }

    /**
     * Converts a string back to an Entry object.
     * <p><b>This operation is not supported in the current implementation and will return null.</b>
     *
     * @param string The string to convert
     * @return Always returns null as conversion from string to {@link Entry} is not supported
     */
    @Override
    public Entry fromString(String string) {
        return null;
    }
}
