package com.maemlab.suggesterfx.mvci;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class Model {
    private final ObjectProperty<Throwable> error = new SimpleObjectProperty<>();
    private final ObjectProperty<Boolean> deleteRequested = new SimpleObjectProperty<>(false);
    private final ObjectProperty<Boolean> deleteConfirmed = new SimpleObjectProperty<>(false);
    private final ObjectProperty<Boolean> saveRequested = new SimpleObjectProperty<>(false);
    private final ObjectProperty<Boolean> saveDone = new SimpleObjectProperty<>(false);
    private final ObjectProperty<Boolean> quitRequested = new SimpleObjectProperty<>(false);
    private final ObjectProperty<Boolean> quitConfirmed = new SimpleObjectProperty<>(false);

    public ObjectProperty<Throwable> errorProperty() {
        return error;
    }

    public void setError(Throwable throwable) {
        error.set(throwable);
    }

    public ObjectProperty<Boolean> deleteRequestedProperty() {
        return deleteRequested;
    }

    public void setDeleteRequested(boolean b) {
        deleteRequested.set(b);
    }

    public ObjectProperty<Boolean> deleteConfirmedProperty() {
        return deleteConfirmed;
    }

    public void setDeleteConfirmed(boolean b) {
        deleteConfirmed.set(b);
    }

    public ObjectProperty<Boolean> getSaveRequestedProperty() {
        return saveRequested;
    }

    public void setSaveRequested(boolean b) {
        saveRequested.set(b);
    }

    public ObjectProperty<Boolean> saveDoneProperty() {
        return saveDone;
    }

    public void setSaveDone(boolean b) {
        saveDone.set(b);
    }

    public ObjectProperty<Boolean> quitRequestedProperty() {
        return quitRequested;
    }

    public void setQuitRequested(boolean b) {
        quitRequested.set(b);
    }

    public ObjectProperty<Boolean> quitConfirmedProperty() {
        return quitConfirmed;
    }

    public void setQuitConfirmed(boolean b) {
        quitConfirmed.set(b);
    }
}
