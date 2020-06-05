package com.tmsdk.module.coin;

import com.tmsdk.module.coin.AdConfig.BUSINESS;
import java.util.ArrayList;

public class AdCoinConfigItem {
    public BUSINESS business;
    public int positionId;
    public String sceneId;
    public ArrayList<Integer> styleIds = new ArrayList<>();
    public int taskType;
}
