package com.maemlab.suggesterfx.data.beans.autocompletion;

import com.maemlab.suggesterfx.data.beans.Bean;
import javafx.util.StringConverter;

public class BeanConverter extends StringConverter<Bean> {
    @Override
    public String toString(Bean bean) {
        if (bean == null) {
            return null;
        }
        return bean.getDescription();
    }

    @Override
    public Bean fromString(String string) {
        return null;
    }
}
