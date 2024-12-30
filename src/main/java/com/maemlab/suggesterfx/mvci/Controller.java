package com.maemlab.suggesterfx.mvci;

import javafx.scene.layout.Region;

public interface Controller {
    Region getView();
    void lookup(Runnable innerRunnable);
    void load();
}
