package com.maemlab.suggesterfx.widgets.autocompletion;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.PopupControl;
import javafx.scene.control.Skin;
import javafx.stage.Window;
import javafx.util.StringConverter;

import java.util.UUID;

public class AutoCompletePopup<T> extends PopupControl {

    /***************************************************************************
     *                                                                         *
     * Private fields                                                          *
     *                                                                         *
     **************************************************************************/

    private final ObservableList<T> suggestions = FXCollections.observableArrayList();
    private StringConverter<T> converter;
    /**
     * The maximum number of rows to be visible in the popup when it is
     * showing. By default this value is 10, but this can be changed to increase
     * or decrease the height of the popup.
     */
    private final IntegerProperty visibleRowCount = new SimpleIntegerProperty(this, "visibleRowCount", 10);

    /***************************************************************************
     *                                                                         *
     * Inner classes                                                           *
     *                                                                         *
     **************************************************************************/

    /**
     * Represents an Event which is fired when the user has selected a suggestion
     * for auto-complete
     *
     * @param <TE>
     */
    @SuppressWarnings("serial")
    public static class SuggestionEvent<TE> extends Event {
        public static final EventType<SuggestionEvent<?>> SUGGESTION 
                = new EventType<>("SUGGESTION" + UUID.randomUUID()); //$NON-NLS-1$

        private final TE suggestion;

        public SuggestionEvent(TE suggestion) {
            super(SUGGESTION);
            this.suggestion = suggestion;
        }

        /**
         * Returns the suggestion which was chosen by the user
         * @return
         */
        public TE getSuggestion() {
            return suggestion;
        }
    }


    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a new AutoCompletePopup
     */
    public AutoCompletePopup(){
        this.setAutoFix(true);
        this.setAutoHide(true);
        this.setHideOnEscape(true);

        getStyleClass().add(DEFAULT_STYLE_CLASS);
    }


    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/


    /**
     * Get the suggestions presented by this AutoCompletePopup
     * @return
     */
    public ObservableList<T> getSuggestions() {
        return suggestions;
    }

    /**
     * Show this popup right below the given Node
     * @param node
     */
    public void show(Node node){

        if(node.getScene() == null || node.getScene().getWindow() == null)
            throw new IllegalStateException("Can not show popup. The node must be attached to a scene/window."); //$NON-NLS-1$

        if(isShowing()){
            return;
        }
        
        Window parent = node.getScene().getWindow();
        getScene().setNodeOrientation(node.getEffectiveNodeOrientation());
        if (node.getEffectiveNodeOrientation() == NodeOrientation.RIGHT_TO_LEFT) {
            setAnchorLocation(AnchorLocation.CONTENT_TOP_RIGHT);
        } else {
            setAnchorLocation(AnchorLocation.CONTENT_TOP_LEFT);
        }
        this.show(
                parent,
                parent.getX() + node.localToScene(0, 0).getX() +
                node.getScene().getX(),
                parent.getY() + node.localToScene(0, 0).getY() +
                node.getScene().getY() + node.getBoundsInParent().getHeight());

    }

    /**
     * Set the string converter used to turn a generic suggestion into a string
     */
    public void setConverter(StringConverter<T> converter) {
		this.converter = converter;
	}
    
    /**
     * Get the string converter used to turn a generic suggestion into a string
     */
	public StringConverter<T> getConverter() {
		return converter;
	}

    public final void setVisibleRowCount(int value) {
        visibleRowCount.set(value);
    }

    public final int getVisibleRowCount() {
        return visibleRowCount.get();
    }

    public final IntegerProperty visibleRowCountProperty() {
        return visibleRowCount;
    }

    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/


    public final ObjectProperty<EventHandler<SuggestionEvent<T>>> onSuggestionProperty() { return onSuggestion; }
    public final void setOnSuggestion(EventHandler<SuggestionEvent<T>> value) { onSuggestionProperty().set(value); }
    public final EventHandler<SuggestionEvent<T>> getOnSuggestion() { return onSuggestionProperty().get(); }
    private final ObjectProperty<EventHandler<SuggestionEvent<T>>> onSuggestion = new ObjectPropertyBase<EventHandler<SuggestionEvent<T>>>() {
        @SuppressWarnings({"rawtypes", "unchecked"})
        @Override
        protected void invalidated() {
            setEventHandler(SuggestionEvent.SUGGESTION, (EventHandler<SuggestionEvent>)(Object)get());
        }

        @Override
        public Object getBean() {
            return AutoCompletePopup.this;
        }

        @Override
        public String getName() {
            return "onSuggestion"; //$NON-NLS-1$
        }
    };

    /***************************************************************************
     *                                                                         *
     * Stylesheet Handling                                                     *
     *                                                                         *
     **************************************************************************/

    public static final String DEFAULT_STYLE_CLASS = "auto-complete-popup"; //$NON-NLS-1$

    @Override
    protected Skin<?> createDefaultSkin() {
        return new AutoCompletePopupSkin<>(this);
    }

}
