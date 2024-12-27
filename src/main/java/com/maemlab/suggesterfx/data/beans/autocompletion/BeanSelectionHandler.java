package com.maemlab.suggesterfx.data.beans.autocompletion;

import com.maemlab.suggesterfx.data.beans.Bean;
import com.maemlab.suggesterfx.mvci.Interactor;
import com.maemlab.suggesterfx.widgets.autocompletion.AutoCompletionBinding;
import javafx.event.EventHandler;

public class BeanSelectionHandler implements EventHandler<AutoCompletionBinding.AutoCompletionEvent<Bean>> {

    private final Interactor interactor;

    public BeanSelectionHandler(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void handle(AutoCompletionBinding.AutoCompletionEvent<Bean> event) {
        Bean bean = event.getCompletion();
        if(interactor != null) {
            interactor.updateModelAfterAutocompletion(bean);
        }
    }
}
