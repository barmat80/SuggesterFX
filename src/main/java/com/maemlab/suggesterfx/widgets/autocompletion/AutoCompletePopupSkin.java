package com.maemlab.suggesterfx.widgets.autocompletion;

import javafx.beans.binding.Bindings;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseButton;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class AutoCompletePopupSkin<T> implements Skin<AutoCompletePopup<T>> {

    private final AutoCompletePopup<T> control;
    private final ListView<T> suggestionList;
    final int LIST_CELL_HEIGHT = 24;

    public AutoCompletePopupSkin(AutoCompletePopup<T> control) {
        this(control, control.getConverter());
    }

    public AutoCompletePopupSkin(AutoCompletePopup<T> control, StringConverter<T> displayConverter) {
        this(control, TextFieldListCell.forListView(displayConverter));
    }

    public AutoCompletePopupSkin(AutoCompletePopup<T> control, Callback<ListView<T>, ListCell<T>> cellFactory) {
        this.control = control;
        suggestionList = new ListView<>(control.getSuggestions());

        suggestionList.getStyleClass().add(AutoCompletePopup.DEFAULT_STYLE_CLASS);

       /**
         * Here we bind the prefHeightProperty to the minimum height between the
         * max visible rows and the current items list. We also add an arbitrary
         * 5 number because when we have only one item we have the vertical
         * scrollBar showing for no reason.
         */
        suggestionList.prefHeightProperty().bind(
                Bindings.min(control.visibleRowCountProperty(), Bindings.size(suggestionList.getItems()))
                .multiply(LIST_CELL_HEIGHT).add(18));
        suggestionList.setCellFactory(cellFactory);
        
        //Allowing the user to control ListView width.
        suggestionList.prefWidthProperty().bind(control.prefWidthProperty());
        suggestionList.maxWidthProperty().bind(control.maxWidthProperty());
        suggestionList.minWidthProperty().bind(control.minWidthProperty());
        registerEventListener();
    }

    private void registerEventListener(){
        suggestionList.setOnMouseClicked(me -> {
            if (me.getButton() == MouseButton.PRIMARY){
                onSuggestionChoosen(suggestionList.getSelectionModel().getSelectedItem());
            }
        });


        suggestionList.setOnKeyPressed(ke -> {
            switch (ke.getCode()) {
                case TAB:
                case ENTER:
                    onSuggestionChoosen(suggestionList.getSelectionModel().getSelectedItem());
                    break;
                case ESCAPE:
                    if (control.isHideOnEscape()) {
                        control.hide();
                    }
                    break;
                default:
                    break;
            }
        });
    }

    private void onSuggestionChoosen(T suggestion){
        if(suggestion != null) {
            Event.fireEvent(control, new AutoCompletePopup.SuggestionEvent<>(suggestion));
        }
    }


    @Override
    public Node getNode() {
        return suggestionList;
    }

    @Override
    public AutoCompletePopup<T> getSkinnable() {
        return control;
    }

    @Override
    public void dispose() {
    }
}
