package com.maemlab.suggesterfx.mvci;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

abstract class Model {
    private final ObjectProperty<Throwable> error = new SimpleObjectProperty<>();
    private final ObjectProperty<Boolean> deleteRequested = new SimpleObjectProperty<>(false);
    private final ObjectProperty<Boolean> deleteConfirmed = new SimpleObjectProperty<>(false);

    public ObjectProperty<Throwable> errorProperty() {
        return error;
    }

    public ObjectProperty<Boolean> deleteRequestedProperty() {
        return deleteRequested;
    }

    public ObjectProperty<Boolean> deleteConfirmedProperty() {
        return deleteConfirmed;
    }
}
