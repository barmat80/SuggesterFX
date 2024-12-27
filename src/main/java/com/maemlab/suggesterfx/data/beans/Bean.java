package com.maemlab.suggesterfx.data.beans;

import java.util.List;

public interface Bean {
    List<Integer> getPKs();
    String getDescription();
    void setCreateDate(String date);
    String getCreateDate();
    void setUpdateDate(String date);
    String getUpdateDate();
}
