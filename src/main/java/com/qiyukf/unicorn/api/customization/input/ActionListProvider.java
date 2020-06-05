package com.qiyukf.unicorn.api.customization.input;

import com.qiyukf.unicorn.api.customization.action.BaseAction;
import java.util.List;

public interface ActionListProvider {
    List<BaseAction> getActionList();
}
