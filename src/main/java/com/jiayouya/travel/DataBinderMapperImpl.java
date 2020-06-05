package com.jiayouya.travel;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jiayouya.travel.databinding.ActivityAboutUsBindingImpl;
import com.jiayouya.travel.databinding.ActivityAnswerBindingImpl;
import com.jiayouya.travel.databinding.ActivityAnswerResultBindingImpl;
import com.jiayouya.travel.databinding.ActivityAuthBindingImpl;
import com.jiayouya.travel.databinding.ActivityAvatarBindingImpl;
import com.jiayouya.travel.databinding.ActivityBonusDetailBindingImpl;
import com.jiayouya.travel.databinding.ActivityBonusDogBindingImpl;
import com.jiayouya.travel.databinding.ActivityBonusLogsBindingImpl;
import com.jiayouya.travel.databinding.ActivityCashApplyBindingImpl;
import com.jiayouya.travel.databinding.ActivityCashBindingImpl;
import com.jiayouya.travel.databinding.ActivityCashLogsBindingImpl;
import com.jiayouya.travel.databinding.ActivityCashResultBindingImpl;
import com.jiayouya.travel.databinding.ActivityDynamicBindingImpl;
import com.jiayouya.travel.databinding.ActivityEditAliPayBindingImpl;
import com.jiayouya.travel.databinding.ActivityExploreBindingImpl;
import com.jiayouya.travel.databinding.ActivityHandbookBindingImpl;
import com.jiayouya.travel.databinding.ActivityInviteCodeBindingImpl;
import com.jiayouya.travel.databinding.ActivityInviteLogsBindingImpl;
import com.jiayouya.travel.databinding.ActivityLoginBindingImpl;
import com.jiayouya.travel.databinding.ActivityMainBindingImpl;
import com.jiayouya.travel.databinding.ActivityMapBindingImpl;
import com.jiayouya.travel.databinding.ActivityMyAliPayBindingImpl;
import com.jiayouya.travel.databinding.ActivityNicknameBindingImpl;
import com.jiayouya.travel.databinding.ActivityNoticeCenterBindingImpl;
import com.jiayouya.travel.databinding.ActivityOnlineServiceBindingImpl;
import com.jiayouya.travel.databinding.ActivityOrderBindingImpl;
import com.jiayouya.travel.databinding.ActivityOrderDetailsBindingImpl;
import com.jiayouya.travel.databinding.ActivityPhoneBindingImpl;
import com.jiayouya.travel.databinding.ActivityPhoneLoginBindingImpl;
import com.jiayouya.travel.databinding.ActivityPrivateBindingImpl;
import com.jiayouya.travel.databinding.ActivityRankingListBindingImpl;
import com.jiayouya.travel.databinding.ActivityRealNameAuthBindingImpl;
import com.jiayouya.travel.databinding.ActivitySearchBindingImpl;
import com.jiayouya.travel.databinding.ActivitySettingBindingImpl;
import com.jiayouya.travel.databinding.ActivitySocialInformationBindingImpl;
import com.jiayouya.travel.databinding.ActivitySplashBindingImpl;
import com.jiayouya.travel.databinding.ActivityTodayProfitLogsBindingImpl;
import com.jiayouya.travel.databinding.ActivityTravelIncomeLogsBindingImpl;
import com.jiayouya.travel.databinding.ActivityWebBindingImpl;
import com.jiayouya.travel.databinding.DialogAchieveGoalBindingImpl;
import com.jiayouya.travel.databinding.DialogBindInviterBindingImpl;
import com.jiayouya.travel.databinding.DialogBindPhoneHintBindingImpl;
import com.jiayouya.travel.databinding.DialogBuyCapacityBindingImpl;
import com.jiayouya.travel.databinding.DialogCashRuleBindingImpl;
import com.jiayouya.travel.databinding.DialogChangeAvatarBindingImpl;
import com.jiayouya.travel.databinding.DialogChannelExplainBindingImpl;
import com.jiayouya.travel.databinding.DialogCoinBoxBindingImpl;
import com.jiayouya.travel.databinding.DialogCoinShortBindingImpl;
import com.jiayouya.travel.databinding.DialogDogDetailBindingImpl;
import com.jiayouya.travel.databinding.DialogDogShopBindingImpl;
import com.jiayouya.travel.databinding.DialogDogUpgradeBindingImpl;
import com.jiayouya.travel.databinding.DialogDoubleCoinBindingImpl;
import com.jiayouya.travel.databinding.DialogExitBindingImpl;
import com.jiayouya.travel.databinding.DialogExploreRuleBindingImpl;
import com.jiayouya.travel.databinding.DialogGetBonusDogBindingImpl;
import com.jiayouya.travel.databinding.DialogGetCoinBindingImpl;
import com.jiayouya.travel.databinding.DialogGetDogBindingImpl;
import com.jiayouya.travel.databinding.DialogGetMaxLevelDogBindingImpl;
import com.jiayouya.travel.databinding.DialogHarvestBindingImpl;
import com.jiayouya.travel.databinding.DialogHbBindingImpl;
import com.jiayouya.travel.databinding.DialogInviterHintBindingImpl;
import com.jiayouya.travel.databinding.DialogLoadingBindingImpl;
import com.jiayouya.travel.databinding.DialogLuckTicketBindingImpl;
import com.jiayouya.travel.databinding.DialogLuckyDrawBindingImpl;
import com.jiayouya.travel.databinding.DialogMergeBonusDogBindingImpl;
import com.jiayouya.travel.databinding.DialogMyBonusDogBindingImpl;
import com.jiayouya.travel.databinding.DialogMyInviterBindingImpl;
import com.jiayouya.travel.databinding.DialogOfflineProfitBindingImpl;
import com.jiayouya.travel.databinding.DialogPayBindingImpl;
import com.jiayouya.travel.databinding.DialogProtocolBindingImpl;
import com.jiayouya.travel.databinding.DialogRandomMergeBindingImpl;
import com.jiayouya.travel.databinding.DialogRealNameAuthFailBindingImpl;
import com.jiayouya.travel.databinding.DialogRecallBindingImpl;
import com.jiayouya.travel.databinding.DialogRecycleHintBindingImpl;
import com.jiayouya.travel.databinding.DialogRecycleSpecialHintBindingImpl;
import com.jiayouya.travel.databinding.DialogResurgenceBindingImpl;
import com.jiayouya.travel.databinding.DialogShareBindingImpl;
import com.jiayouya.travel.databinding.DialogSystemNoticeBindingImpl;
import com.jiayouya.travel.databinding.DialogTaobaoAuthBindingImpl;
import com.jiayouya.travel.databinding.DialogTargetExplainBindingImpl;
import com.jiayouya.travel.databinding.DialogTempBonusBindingImpl;
import com.jiayouya.travel.databinding.DialogTempBonusDogBindingImpl;
import com.jiayouya.travel.databinding.DialogTempBonusProfitBindingImpl;
import com.jiayouya.travel.databinding.DialogTotalProfitBindingImpl;
import com.jiayouya.travel.databinding.DialogTravelCityBindingImpl;
import com.jiayouya.travel.databinding.DialogUnlockCityBindingImpl;
import com.jiayouya.travel.databinding.DialogUpgradeChannelBindingImpl;
import com.jiayouya.travel.databinding.DialogWarehouseBindingImpl;
import com.jiayouya.travel.databinding.DialogWarehouseHintBindingImpl;
import com.jiayouya.travel.databinding.FragmentCoinRankListBindingImpl;
import com.jiayouya.travel.databinding.FragmentDogRankListBindingImpl;
import com.jiayouya.travel.databinding.FragmentInviteLogsBindingImpl;
import com.jiayouya.travel.databinding.FragmentMeBindingImpl;
import com.jiayouya.travel.databinding.FragmentOrderBindingImpl;
import com.jiayouya.travel.databinding.FragmentProfitRankListBindingImpl;
import com.jiayouya.travel.databinding.FragmentTbBindingImpl;
import com.jiayouya.travel.databinding.FragmentTourGroupBindingImpl;
import com.jiayouya.travel.databinding.FragmentTravelBindingImpl;
import com.jiayouya.travel.databinding.ItemAnswerBindingImpl;
import com.jiayouya.travel.databinding.ItemAnswerWrongBindingImpl;
import com.jiayouya.travel.databinding.ItemAnswerWrongSubBindingImpl;
import com.jiayouya.travel.databinding.ItemAssociateBindingImpl;
import com.jiayouya.travel.databinding.ItemCashAmountBindingImpl;
import com.jiayouya.travel.databinding.ItemCashRuleBindingImpl;
import com.jiayouya.travel.databinding.ItemCashTypeBindingImpl;
import com.jiayouya.travel.databinding.ItemCoinRankListBindingImpl;
import com.jiayouya.travel.databinding.ItemDogInfoBindingImpl;
import com.jiayouya.travel.databinding.ItemDogRankListBindingImpl;
import com.jiayouya.travel.databinding.ItemDogShopBindingImpl;
import com.jiayouya.travel.databinding.ItemDynamicContentBindingImpl;
import com.jiayouya.travel.databinding.ItemDynamicTitleBindingImpl;
import com.jiayouya.travel.databinding.ItemExploreDynamicBindingImpl;
import com.jiayouya.travel.databinding.ItemExploreHarvestBindingImpl;
import com.jiayouya.travel.databinding.ItemExploreTeamBindingImpl;
import com.jiayouya.travel.databinding.ItemHandbookBindingImpl;
import com.jiayouya.travel.databinding.ItemInviteLogsBindingImpl;
import com.jiayouya.travel.databinding.ItemListEmptyBindingImpl;
import com.jiayouya.travel.databinding.ItemLogsBindingImpl;
import com.jiayouya.travel.databinding.ItemMapBindingImpl;
import com.jiayouya.travel.databinding.ItemMayHarvestBindingImpl;
import com.jiayouya.travel.databinding.ItemMeDividerBindingImpl;
import com.jiayouya.travel.databinding.ItemMeNormalBindingImpl;
import com.jiayouya.travel.databinding.ItemMeTaskBindingImpl;
import com.jiayouya.travel.databinding.ItemMergeBindingImpl;
import com.jiayouya.travel.databinding.ItemNoticeCenterBindingImpl;
import com.jiayouya.travel.databinding.ItemOrderBindingImpl;
import com.jiayouya.travel.databinding.ItemOrderCoinBindingImpl;
import com.jiayouya.travel.databinding.ItemPayBindingImpl;
import com.jiayouya.travel.databinding.ItemProfitRankListBindingImpl;
import com.jiayouya.travel.databinding.ItemSearchResultBindingImpl;
import com.jiayouya.travel.databinding.ItemShareBindingImpl;
import com.jiayouya.travel.databinding.ItemSortTabBindingImpl;
import com.jiayouya.travel.databinding.ItemTodayProfitLogsBindingImpl;
import com.jiayouya.travel.databinding.ItemWarehouseBindingImpl;
import com.jiayouya.travel.databinding.LayoutTabBindingImpl;
import com.jiayouya.travel.databinding.PopSortBindingImpl;
import com.jiayouya.travel.databinding.QiyuActivityOnlineServiceBindingImpl;
import com.tencent.p605ep.common.adapt.iservice.account.AccountConst.ArgKey;
import com.tencent.p605ep.commonbase.software.AppEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    /* renamed from: a */
    private static final SparseIntArray f9535a = new SparseIntArray(137);

    /* renamed from: com.jiayouya.travel.DataBinderMapperImpl$a */
    private static class C2825a {
        /* renamed from: a */
        static final SparseArray<String> f9536a = new SparseArray<>(37);

        static {
            f9536a.put(0, "_all");
            f9536a.put(1, "voice");
            f9536a.put(2, "onClick");
            f9536a.put(3, "isHasPre");
            f9536a.put(4, "dogId");
            f9536a.put(5, "contactInfo");
            f9536a.put(6, "num");
            f9536a.put(7, "icon");
            f9536a.put(8, "isGold");
            f9536a.put(9, "isAuthenticated");
            f9536a.put(10, "type");
            f9536a.put(11, "speed");
            f9536a.put(12, "price");
            f9536a.put(13, "suggestBuyItem");
            f9536a.put(14, "isHasNext");
            f9536a.put(15, "profit");
            f9536a.put(16, "isSucceed");
            f9536a.put(17, "ali");
            f9536a.put(18, "isMustBind");
            f9536a.put(19, "item");
            f9536a.put(20, "amount");
            f9536a.put(21, "ad");
            f9536a.put(22, AppEntity.KEY_APP_NAME_STR);
            f9536a.put(23, "tempSecond");
            f9536a.put(24, AppEntity.KEY_VERSION_STR);
            f9536a.put(25, "resId");
            f9536a.put(26, "isShowFlowAd");
            f9536a.put(27, "errorText");
            f9536a.put(28, "txt");
            f9536a.put(29, "gameIndex");
            f9536a.put(30, ArgKey.KEY_NAME);
            f9536a.put(31, NotificationCompat.CATEGORY_PROGRESS);
            f9536a.put(32, "step");
            f9536a.put(33, "user");
            f9536a.put(34, "dog");
            f9536a.put(35, ArgKey.KEY_DESC);
        }
    }

    /* renamed from: com.jiayouya.travel.DataBinderMapperImpl$b */
    private static class C2826b {
        /* renamed from: a */
        static final HashMap<String, Integer> f9537a = new HashMap<>(137);

        static {
            f9537a.put("layout/activity_about_us_0", Integer.valueOf(R.layout.activity_about_us));
            f9537a.put("layout/activity_answer_0", Integer.valueOf(R.layout.activity_answer));
            f9537a.put("layout/activity_answer_result_0", Integer.valueOf(R.layout.activity_answer_result));
            f9537a.put("layout/activity_auth_0", Integer.valueOf(R.layout.activity_auth));
            f9537a.put("layout/activity_avatar_0", Integer.valueOf(R.layout.activity_avatar));
            f9537a.put("layout/activity_bonus_detail_0", Integer.valueOf(R.layout.activity_bonus_detail));
            f9537a.put("layout/activity_bonus_dog_0", Integer.valueOf(R.layout.activity_bonus_dog));
            f9537a.put("layout/activity_bonus_logs_0", Integer.valueOf(R.layout.activity_bonus_logs));
            f9537a.put("layout/activity_cash_0", Integer.valueOf(R.layout.activity_cash));
            f9537a.put("layout/activity_cash_apply_0", Integer.valueOf(R.layout.activity_cash_apply));
            f9537a.put("layout/activity_cash_logs_0", Integer.valueOf(R.layout.activity_cash_logs));
            f9537a.put("layout/activity_cash_result_0", Integer.valueOf(R.layout.activity_cash_result));
            f9537a.put("layout/activity_dynamic_0", Integer.valueOf(R.layout.activity_dynamic));
            f9537a.put("layout/activity_edit_ali_pay_0", Integer.valueOf(R.layout.activity_edit_ali_pay));
            f9537a.put("layout/activity_explore_0", Integer.valueOf(R.layout.activity_explore));
            f9537a.put("layout/activity_handbook_0", Integer.valueOf(R.layout.activity_handbook));
            f9537a.put("layout/activity_invite_code_0", Integer.valueOf(R.layout.activity_invite_code));
            f9537a.put("layout/activity_invite_logs_0", Integer.valueOf(R.layout.activity_invite_logs));
            f9537a.put("layout/activity_login_0", Integer.valueOf(R.layout.activity_login));
            f9537a.put("layout/activity_main_0", Integer.valueOf(R.layout.activity_main));
            f9537a.put("layout/activity_map_0", Integer.valueOf(R.layout.activity_map));
            f9537a.put("layout/activity_my_ali_pay_0", Integer.valueOf(R.layout.activity_my_ali_pay));
            f9537a.put("layout/activity_nickname_0", Integer.valueOf(R.layout.activity_nickname));
            f9537a.put("layout/activity_notice_center_0", Integer.valueOf(R.layout.activity_notice_center));
            f9537a.put("layout/activity_online_service_0", Integer.valueOf(R.layout.activity_online_service));
            f9537a.put("layout/activity_order_0", Integer.valueOf(R.layout.activity_order));
            f9537a.put("layout/activity_order_details_0", Integer.valueOf(R.layout.activity_order_details));
            f9537a.put("layout/activity_phone_0", Integer.valueOf(R.layout.activity_phone));
            f9537a.put("layout/activity_phone_login_0", Integer.valueOf(R.layout.activity_phone_login));
            f9537a.put("layout/activity_private_0", Integer.valueOf(R.layout.activity_private));
            f9537a.put("layout/activity_ranking_list_0", Integer.valueOf(R.layout.activity_ranking_list));
            f9537a.put("layout/activity_real_name_auth_0", Integer.valueOf(R.layout.activity_real_name_auth));
            f9537a.put("layout/activity_search_0", Integer.valueOf(R.layout.activity_search));
            f9537a.put("layout/activity_setting_0", Integer.valueOf(R.layout.activity_setting));
            f9537a.put("layout/activity_social_information_0", Integer.valueOf(R.layout.activity_social_information));
            f9537a.put("layout/activity_splash_0", Integer.valueOf(R.layout.activity_splash));
            f9537a.put("layout/activity_today_profit_logs_0", Integer.valueOf(R.layout.activity_today_profit_logs));
            f9537a.put("layout/activity_travel_income_logs_0", Integer.valueOf(R.layout.activity_travel_income_logs));
            f9537a.put("layout/activity_web_0", Integer.valueOf(R.layout.activity_web));
            f9537a.put("layout/dialog_achieve_goal_0", Integer.valueOf(R.layout.dialog_achieve_goal));
            f9537a.put("layout/dialog_bind_inviter_0", Integer.valueOf(R.layout.dialog_bind_inviter));
            f9537a.put("layout/dialog_bind_phone_hint_0", Integer.valueOf(R.layout.dialog_bind_phone_hint));
            f9537a.put("layout/dialog_buy_capacity_0", Integer.valueOf(R.layout.dialog_buy_capacity));
            f9537a.put("layout/dialog_cash_rule_0", Integer.valueOf(R.layout.dialog_cash_rule));
            f9537a.put("layout/dialog_change_avatar_0", Integer.valueOf(R.layout.dialog_change_avatar));
            f9537a.put("layout/dialog_channel_explain_0", Integer.valueOf(R.layout.dialog_channel_explain));
            f9537a.put("layout/dialog_coin_box_0", Integer.valueOf(R.layout.dialog_coin_box));
            f9537a.put("layout/dialog_coin_short_0", Integer.valueOf(R.layout.dialog_coin_short));
            f9537a.put("layout/dialog_dog_detail_0", Integer.valueOf(R.layout.dialog_dog_detail));
            f9537a.put("layout/dialog_dog_shop_0", Integer.valueOf(R.layout.dialog_dog_shop));
            f9537a.put("layout/dialog_dog_upgrade_0", Integer.valueOf(R.layout.dialog_dog_upgrade));
            f9537a.put("layout/dialog_double_coin_0", Integer.valueOf(R.layout.dialog_double_coin));
            f9537a.put("layout/dialog_exit_0", Integer.valueOf(R.layout.dialog_exit));
            f9537a.put("layout/dialog_explore_rule_0", Integer.valueOf(R.layout.dialog_explore_rule));
            f9537a.put("layout/dialog_get_bonus_dog_0", Integer.valueOf(R.layout.dialog_get_bonus_dog));
            f9537a.put("layout/dialog_get_coin_0", Integer.valueOf(R.layout.dialog_get_coin));
            f9537a.put("layout/dialog_get_dog_0", Integer.valueOf(R.layout.dialog_get_dog));
            f9537a.put("layout/dialog_get_max_level_dog_0", Integer.valueOf(R.layout.dialog_get_max_level_dog));
            f9537a.put("layout/dialog_harvest_0", Integer.valueOf(R.layout.dialog_harvest));
            f9537a.put("layout/dialog_hb_0", Integer.valueOf(R.layout.dialog_hb));
            f9537a.put("layout/dialog_inviter_hint_0", Integer.valueOf(R.layout.dialog_inviter_hint));
            f9537a.put("layout/dialog_loading_0", Integer.valueOf(R.layout.dialog_loading));
            f9537a.put("layout/dialog_luck_ticket_0", Integer.valueOf(R.layout.dialog_luck_ticket));
            f9537a.put("layout/dialog_lucky_draw_0", Integer.valueOf(R.layout.dialog_lucky_draw));
            f9537a.put("layout/dialog_merge_bonus_dog_0", Integer.valueOf(R.layout.dialog_merge_bonus_dog));
            f9537a.put("layout/dialog_my_bonus_dog_0", Integer.valueOf(R.layout.dialog_my_bonus_dog));
            f9537a.put("layout/dialog_my_inviter_0", Integer.valueOf(R.layout.dialog_my_inviter));
            f9537a.put("layout/dialog_offline_profit_0", Integer.valueOf(R.layout.dialog_offline_profit));
            f9537a.put("layout/dialog_pay_0", Integer.valueOf(R.layout.dialog_pay));
            f9537a.put("layout/dialog_protocol_0", Integer.valueOf(R.layout.dialog_protocol));
            f9537a.put("layout/dialog_random_merge_0", Integer.valueOf(R.layout.dialog_random_merge));
            f9537a.put("layout/dialog_real_name_auth_fail_0", Integer.valueOf(R.layout.dialog_real_name_auth_fail));
            f9537a.put("layout/dialog_recall_0", Integer.valueOf(R.layout.dialog_recall));
            f9537a.put("layout/dialog_recycle_hint_0", Integer.valueOf(R.layout.dialog_recycle_hint));
            f9537a.put("layout/dialog_recycle_special_hint_0", Integer.valueOf(R.layout.dialog_recycle_special_hint));
            f9537a.put("layout/dialog_resurgence_0", Integer.valueOf(R.layout.dialog_resurgence));
            f9537a.put("layout/dialog_share_0", Integer.valueOf(R.layout.dialog_share));
            f9537a.put("layout/dialog_system_notice_0", Integer.valueOf(R.layout.dialog_system_notice));
            f9537a.put("layout/dialog_taobao_auth_0", Integer.valueOf(R.layout.dialog_taobao_auth));
            f9537a.put("layout/dialog_target_explain_0", Integer.valueOf(R.layout.dialog_target_explain));
            f9537a.put("layout/dialog_temp_bonus_0", Integer.valueOf(R.layout.dialog_temp_bonus));
            f9537a.put("layout/dialog_temp_bonus_dog_0", Integer.valueOf(R.layout.dialog_temp_bonus_dog));
            f9537a.put("layout/dialog_temp_bonus_profit_0", Integer.valueOf(R.layout.dialog_temp_bonus_profit));
            f9537a.put("layout/dialog_total_profit_0", Integer.valueOf(R.layout.dialog_total_profit));
            f9537a.put("layout/dialog_travel_city_0", Integer.valueOf(R.layout.dialog_travel_city));
            f9537a.put("layout/dialog_unlock_city_0", Integer.valueOf(R.layout.dialog_unlock_city));
            f9537a.put("layout/dialog_upgrade_channel_0", Integer.valueOf(R.layout.dialog_upgrade_channel));
            f9537a.put("layout/dialog_warehouse_0", Integer.valueOf(R.layout.dialog_warehouse));
            f9537a.put("layout/dialog_warehouse_hint_0", Integer.valueOf(R.layout.dialog_warehouse_hint));
            f9537a.put("layout/fragment_coin_rank_list_0", Integer.valueOf(R.layout.fragment_coin_rank_list));
            f9537a.put("layout/fragment_dog_rank_list_0", Integer.valueOf(R.layout.fragment_dog_rank_list));
            f9537a.put("layout/fragment_invite_logs_0", Integer.valueOf(R.layout.fragment_invite_logs));
            f9537a.put("layout/fragment_me_0", Integer.valueOf(R.layout.fragment_me));
            f9537a.put("layout/fragment_order_0", Integer.valueOf(R.layout.fragment_order));
            f9537a.put("layout/fragment_profit_rank_list_0", Integer.valueOf(R.layout.fragment_profit_rank_list));
            f9537a.put("layout/fragment_tb_0", Integer.valueOf(R.layout.fragment_tb));
            f9537a.put("layout/fragment_tour_group_0", Integer.valueOf(R.layout.fragment_tour_group));
            f9537a.put("layout/fragment_travel_0", Integer.valueOf(R.layout.fragment_travel));
            f9537a.put("layout/item_answer_0", Integer.valueOf(R.layout.item_answer));
            f9537a.put("layout/item_answer_wrong_0", Integer.valueOf(R.layout.item_answer_wrong));
            f9537a.put("layout/item_answer_wrong_sub_0", Integer.valueOf(R.layout.item_answer_wrong_sub));
            f9537a.put("layout/item_associate_0", Integer.valueOf(R.layout.item_associate));
            f9537a.put("layout/item_cash_amount_0", Integer.valueOf(R.layout.item_cash_amount));
            f9537a.put("layout/item_cash_rule_0", Integer.valueOf(R.layout.item_cash_rule));
            f9537a.put("layout/item_cash_type_0", Integer.valueOf(R.layout.item_cash_type));
            f9537a.put("layout/item_coin_rank_list_0", Integer.valueOf(R.layout.item_coin_rank_list));
            f9537a.put("layout/item_dog_info_0", Integer.valueOf(R.layout.item_dog_info));
            f9537a.put("layout/item_dog_rank_list_0", Integer.valueOf(R.layout.item_dog_rank_list));
            f9537a.put("layout/item_dog_shop_0", Integer.valueOf(R.layout.item_dog_shop));
            f9537a.put("layout/item_dynamic_content_0", Integer.valueOf(R.layout.item_dynamic_content));
            f9537a.put("layout/item_dynamic_title_0", Integer.valueOf(R.layout.item_dynamic_title));
            f9537a.put("layout/item_explore_dynamic_0", Integer.valueOf(R.layout.item_explore_dynamic));
            f9537a.put("layout/item_explore_harvest_0", Integer.valueOf(R.layout.item_explore_harvest));
            f9537a.put("layout/item_explore_team_0", Integer.valueOf(R.layout.item_explore_team));
            f9537a.put("layout/item_handbook_0", Integer.valueOf(R.layout.item_handbook));
            f9537a.put("layout/item_invite_logs_0", Integer.valueOf(R.layout.item_invite_logs));
            f9537a.put("layout/item_list_empty_0", Integer.valueOf(R.layout.item_list_empty));
            f9537a.put("layout/item_logs_0", Integer.valueOf(R.layout.item_logs));
            f9537a.put("layout/item_map_0", Integer.valueOf(R.layout.item_map));
            f9537a.put("layout/item_may_harvest_0", Integer.valueOf(R.layout.item_may_harvest));
            f9537a.put("layout/item_me_divider_0", Integer.valueOf(R.layout.item_me_divider));
            f9537a.put("layout/item_me_normal_0", Integer.valueOf(R.layout.item_me_normal));
            f9537a.put("layout/item_me_task_0", Integer.valueOf(R.layout.item_me_task));
            f9537a.put("layout/item_merge_0", Integer.valueOf(R.layout.item_merge));
            f9537a.put("layout/item_notice_center_0", Integer.valueOf(R.layout.item_notice_center));
            f9537a.put("layout/item_order_0", Integer.valueOf(R.layout.item_order));
            f9537a.put("layout/item_order_coin_0", Integer.valueOf(R.layout.item_order_coin));
            f9537a.put("layout/item_pay_0", Integer.valueOf(R.layout.item_pay));
            f9537a.put("layout/item_profit_rank_list_0", Integer.valueOf(R.layout.item_profit_rank_list));
            f9537a.put("layout/item_search_result_0", Integer.valueOf(R.layout.item_search_result));
            f9537a.put("layout/item_share_0", Integer.valueOf(R.layout.item_share));
            f9537a.put("layout/item_sort_tab_0", Integer.valueOf(R.layout.item_sort_tab));
            f9537a.put("layout/item_today_profit_logs_0", Integer.valueOf(R.layout.item_today_profit_logs));
            f9537a.put("layout/item_warehouse_0", Integer.valueOf(R.layout.item_warehouse));
            f9537a.put("layout/layout_tab_0", Integer.valueOf(R.layout.layout_tab));
            f9537a.put("layout/pop_sort_0", Integer.valueOf(R.layout.pop_sort));
            f9537a.put("layout/qiyu_activity_online_service_0", Integer.valueOf(R.layout.qiyu_activity_online_service));
        }
    }

    static {
        f9535a.put(R.layout.activity_about_us, 1);
        f9535a.put(R.layout.activity_answer, 2);
        f9535a.put(R.layout.activity_answer_result, 3);
        f9535a.put(R.layout.activity_auth, 4);
        f9535a.put(R.layout.activity_avatar, 5);
        f9535a.put(R.layout.activity_bonus_detail, 6);
        f9535a.put(R.layout.activity_bonus_dog, 7);
        f9535a.put(R.layout.activity_bonus_logs, 8);
        f9535a.put(R.layout.activity_cash, 9);
        f9535a.put(R.layout.activity_cash_apply, 10);
        f9535a.put(R.layout.activity_cash_logs, 11);
        f9535a.put(R.layout.activity_cash_result, 12);
        f9535a.put(R.layout.activity_dynamic, 13);
        f9535a.put(R.layout.activity_edit_ali_pay, 14);
        f9535a.put(R.layout.activity_explore, 15);
        f9535a.put(R.layout.activity_handbook, 16);
        f9535a.put(R.layout.activity_invite_code, 17);
        f9535a.put(R.layout.activity_invite_logs, 18);
        f9535a.put(R.layout.activity_login, 19);
        f9535a.put(R.layout.activity_main, 20);
        f9535a.put(R.layout.activity_map, 21);
        f9535a.put(R.layout.activity_my_ali_pay, 22);
        f9535a.put(R.layout.activity_nickname, 23);
        f9535a.put(R.layout.activity_notice_center, 24);
        f9535a.put(R.layout.activity_online_service, 25);
        f9535a.put(R.layout.activity_order, 26);
        f9535a.put(R.layout.activity_order_details, 27);
        f9535a.put(R.layout.activity_phone, 28);
        f9535a.put(R.layout.activity_phone_login, 29);
        f9535a.put(R.layout.activity_private, 30);
        f9535a.put(R.layout.activity_ranking_list, 31);
        f9535a.put(R.layout.activity_real_name_auth, 32);
        f9535a.put(R.layout.activity_search, 33);
        f9535a.put(R.layout.activity_setting, 34);
        f9535a.put(R.layout.activity_social_information, 35);
        f9535a.put(R.layout.activity_splash, 36);
        f9535a.put(R.layout.activity_today_profit_logs, 37);
        f9535a.put(R.layout.activity_travel_income_logs, 38);
        f9535a.put(R.layout.activity_web, 39);
        f9535a.put(R.layout.dialog_achieve_goal, 40);
        f9535a.put(R.layout.dialog_bind_inviter, 41);
        f9535a.put(R.layout.dialog_bind_phone_hint, 42);
        f9535a.put(R.layout.dialog_buy_capacity, 43);
        f9535a.put(R.layout.dialog_cash_rule, 44);
        f9535a.put(R.layout.dialog_change_avatar, 45);
        f9535a.put(R.layout.dialog_channel_explain, 46);
        f9535a.put(R.layout.dialog_coin_box, 47);
        f9535a.put(R.layout.dialog_coin_short, 48);
        f9535a.put(R.layout.dialog_dog_detail, 49);
        f9535a.put(R.layout.dialog_dog_shop, 50);
        f9535a.put(R.layout.dialog_dog_upgrade, 51);
        f9535a.put(R.layout.dialog_double_coin, 52);
        f9535a.put(R.layout.dialog_exit, 53);
        f9535a.put(R.layout.dialog_explore_rule, 54);
        f9535a.put(R.layout.dialog_get_bonus_dog, 55);
        f9535a.put(R.layout.dialog_get_coin, 56);
        f9535a.put(R.layout.dialog_get_dog, 57);
        f9535a.put(R.layout.dialog_get_max_level_dog, 58);
        f9535a.put(R.layout.dialog_harvest, 59);
        f9535a.put(R.layout.dialog_hb, 60);
        f9535a.put(R.layout.dialog_inviter_hint, 61);
        f9535a.put(R.layout.dialog_loading, 62);
        f9535a.put(R.layout.dialog_luck_ticket, 63);
        f9535a.put(R.layout.dialog_lucky_draw, 64);
        f9535a.put(R.layout.dialog_merge_bonus_dog, 65);
        f9535a.put(R.layout.dialog_my_bonus_dog, 66);
        f9535a.put(R.layout.dialog_my_inviter, 67);
        f9535a.put(R.layout.dialog_offline_profit, 68);
        f9535a.put(R.layout.dialog_pay, 69);
        f9535a.put(R.layout.dialog_protocol, 70);
        f9535a.put(R.layout.dialog_random_merge, 71);
        f9535a.put(R.layout.dialog_real_name_auth_fail, 72);
        f9535a.put(R.layout.dialog_recall, 73);
        f9535a.put(R.layout.dialog_recycle_hint, 74);
        f9535a.put(R.layout.dialog_recycle_special_hint, 75);
        f9535a.put(R.layout.dialog_resurgence, 76);
        f9535a.put(R.layout.dialog_share, 77);
        f9535a.put(R.layout.dialog_system_notice, 78);
        f9535a.put(R.layout.dialog_taobao_auth, 79);
        f9535a.put(R.layout.dialog_target_explain, 80);
        f9535a.put(R.layout.dialog_temp_bonus, 81);
        f9535a.put(R.layout.dialog_temp_bonus_dog, 82);
        f9535a.put(R.layout.dialog_temp_bonus_profit, 83);
        f9535a.put(R.layout.dialog_total_profit, 84);
        f9535a.put(R.layout.dialog_travel_city, 85);
        f9535a.put(R.layout.dialog_unlock_city, 86);
        f9535a.put(R.layout.dialog_upgrade_channel, 87);
        f9535a.put(R.layout.dialog_warehouse, 88);
        f9535a.put(R.layout.dialog_warehouse_hint, 89);
        f9535a.put(R.layout.fragment_coin_rank_list, 90);
        f9535a.put(R.layout.fragment_dog_rank_list, 91);
        f9535a.put(R.layout.fragment_invite_logs, 92);
        f9535a.put(R.layout.fragment_me, 93);
        f9535a.put(R.layout.fragment_order, 94);
        f9535a.put(R.layout.fragment_profit_rank_list, 95);
        f9535a.put(R.layout.fragment_tb, 96);
        f9535a.put(R.layout.fragment_tour_group, 97);
        f9535a.put(R.layout.fragment_travel, 98);
        f9535a.put(R.layout.item_answer, 99);
        f9535a.put(R.layout.item_answer_wrong, 100);
        f9535a.put(R.layout.item_answer_wrong_sub, 101);
        f9535a.put(R.layout.item_associate, 102);
        f9535a.put(R.layout.item_cash_amount, 103);
        f9535a.put(R.layout.item_cash_rule, 104);
        f9535a.put(R.layout.item_cash_type, 105);
        f9535a.put(R.layout.item_coin_rank_list, 106);
        f9535a.put(R.layout.item_dog_info, 107);
        f9535a.put(R.layout.item_dog_rank_list, 108);
        f9535a.put(R.layout.item_dog_shop, 109);
        f9535a.put(R.layout.item_dynamic_content, 110);
        f9535a.put(R.layout.item_dynamic_title, 111);
        f9535a.put(R.layout.item_explore_dynamic, 112);
        f9535a.put(R.layout.item_explore_harvest, 113);
        f9535a.put(R.layout.item_explore_team, 114);
        f9535a.put(R.layout.item_handbook, 115);
        f9535a.put(R.layout.item_invite_logs, 116);
        f9535a.put(R.layout.item_list_empty, 117);
        f9535a.put(R.layout.item_logs, 118);
        f9535a.put(R.layout.item_map, 119);
        f9535a.put(R.layout.item_may_harvest, 120);
        f9535a.put(R.layout.item_me_divider, 121);
        f9535a.put(R.layout.item_me_normal, 122);
        f9535a.put(R.layout.item_me_task, 123);
        f9535a.put(R.layout.item_merge, 124);
        f9535a.put(R.layout.item_notice_center, 125);
        f9535a.put(R.layout.item_order, 126);
        f9535a.put(R.layout.item_order_coin, 127);
        f9535a.put(R.layout.item_pay, 128);
        f9535a.put(R.layout.item_profit_rank_list, 129);
        f9535a.put(R.layout.item_search_result, 130);
        f9535a.put(R.layout.item_share, 131);
        f9535a.put(R.layout.item_sort_tab, 132);
        f9535a.put(R.layout.item_today_profit_logs, 133);
        f9535a.put(R.layout.item_warehouse, 134);
        f9535a.put(R.layout.layout_tab, 135);
        f9535a.put(R.layout.pop_sort, 136);
        f9535a.put(R.layout.qiyu_activity_online_service, 137);
    }

    /* renamed from: a */
    private final ViewDataBinding m12735a(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/activity_about_us_0".equals(obj)) {
                    return new ActivityAboutUsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The tag for activity_about_us is invalid. Received: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString());
            case 2:
                if ("layout/activity_answer_0".equals(obj)) {
                    return new ActivityAnswerBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The tag for activity_answer is invalid. Received: ");
                sb2.append(obj);
                throw new IllegalArgumentException(sb2.toString());
            case 3:
                if ("layout/activity_answer_result_0".equals(obj)) {
                    return new ActivityAnswerResultBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The tag for activity_answer_result is invalid. Received: ");
                sb3.append(obj);
                throw new IllegalArgumentException(sb3.toString());
            case 4:
                if ("layout/activity_auth_0".equals(obj)) {
                    return new ActivityAuthBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("The tag for activity_auth is invalid. Received: ");
                sb4.append(obj);
                throw new IllegalArgumentException(sb4.toString());
            case 5:
                if ("layout/activity_avatar_0".equals(obj)) {
                    return new ActivityAvatarBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("The tag for activity_avatar is invalid. Received: ");
                sb5.append(obj);
                throw new IllegalArgumentException(sb5.toString());
            case 6:
                if ("layout/activity_bonus_detail_0".equals(obj)) {
                    return new ActivityBonusDetailBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("The tag for activity_bonus_detail is invalid. Received: ");
                sb6.append(obj);
                throw new IllegalArgumentException(sb6.toString());
            case 7:
                if ("layout/activity_bonus_dog_0".equals(obj)) {
                    return new ActivityBonusDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("The tag for activity_bonus_dog is invalid. Received: ");
                sb7.append(obj);
                throw new IllegalArgumentException(sb7.toString());
            case 8:
                if ("layout/activity_bonus_logs_0".equals(obj)) {
                    return new ActivityBonusLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("The tag for activity_bonus_logs is invalid. Received: ");
                sb8.append(obj);
                throw new IllegalArgumentException(sb8.toString());
            case 9:
                if ("layout/activity_cash_0".equals(obj)) {
                    return new ActivityCashBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("The tag for activity_cash is invalid. Received: ");
                sb9.append(obj);
                throw new IllegalArgumentException(sb9.toString());
            case 10:
                if ("layout/activity_cash_apply_0".equals(obj)) {
                    return new ActivityCashApplyBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append("The tag for activity_cash_apply is invalid. Received: ");
                sb10.append(obj);
                throw new IllegalArgumentException(sb10.toString());
            case 11:
                if ("layout/activity_cash_logs_0".equals(obj)) {
                    return new ActivityCashLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append("The tag for activity_cash_logs is invalid. Received: ");
                sb11.append(obj);
                throw new IllegalArgumentException(sb11.toString());
            case 12:
                if ("layout/activity_cash_result_0".equals(obj)) {
                    return new ActivityCashResultBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append("The tag for activity_cash_result is invalid. Received: ");
                sb12.append(obj);
                throw new IllegalArgumentException(sb12.toString());
            case 13:
                if ("layout/activity_dynamic_0".equals(obj)) {
                    return new ActivityDynamicBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb13 = new StringBuilder();
                sb13.append("The tag for activity_dynamic is invalid. Received: ");
                sb13.append(obj);
                throw new IllegalArgumentException(sb13.toString());
            case 14:
                if ("layout/activity_edit_ali_pay_0".equals(obj)) {
                    return new ActivityEditAliPayBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb14 = new StringBuilder();
                sb14.append("The tag for activity_edit_ali_pay is invalid. Received: ");
                sb14.append(obj);
                throw new IllegalArgumentException(sb14.toString());
            case 15:
                if ("layout/activity_explore_0".equals(obj)) {
                    return new ActivityExploreBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb15 = new StringBuilder();
                sb15.append("The tag for activity_explore is invalid. Received: ");
                sb15.append(obj);
                throw new IllegalArgumentException(sb15.toString());
            case 16:
                if ("layout/activity_handbook_0".equals(obj)) {
                    return new ActivityHandbookBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb16 = new StringBuilder();
                sb16.append("The tag for activity_handbook is invalid. Received: ");
                sb16.append(obj);
                throw new IllegalArgumentException(sb16.toString());
            case 17:
                if ("layout/activity_invite_code_0".equals(obj)) {
                    return new ActivityInviteCodeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb17 = new StringBuilder();
                sb17.append("The tag for activity_invite_code is invalid. Received: ");
                sb17.append(obj);
                throw new IllegalArgumentException(sb17.toString());
            case 18:
                if ("layout/activity_invite_logs_0".equals(obj)) {
                    return new ActivityInviteLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb18 = new StringBuilder();
                sb18.append("The tag for activity_invite_logs is invalid. Received: ");
                sb18.append(obj);
                throw new IllegalArgumentException(sb18.toString());
            case 19:
                if ("layout/activity_login_0".equals(obj)) {
                    return new ActivityLoginBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb19 = new StringBuilder();
                sb19.append("The tag for activity_login is invalid. Received: ");
                sb19.append(obj);
                throw new IllegalArgumentException(sb19.toString());
            case 20:
                if ("layout/activity_main_0".equals(obj)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb20 = new StringBuilder();
                sb20.append("The tag for activity_main is invalid. Received: ");
                sb20.append(obj);
                throw new IllegalArgumentException(sb20.toString());
            case 21:
                if ("layout/activity_map_0".equals(obj)) {
                    return new ActivityMapBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb21 = new StringBuilder();
                sb21.append("The tag for activity_map is invalid. Received: ");
                sb21.append(obj);
                throw new IllegalArgumentException(sb21.toString());
            case 22:
                if ("layout/activity_my_ali_pay_0".equals(obj)) {
                    return new ActivityMyAliPayBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb22 = new StringBuilder();
                sb22.append("The tag for activity_my_ali_pay is invalid. Received: ");
                sb22.append(obj);
                throw new IllegalArgumentException(sb22.toString());
            case 23:
                if ("layout/activity_nickname_0".equals(obj)) {
                    return new ActivityNicknameBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb23 = new StringBuilder();
                sb23.append("The tag for activity_nickname is invalid. Received: ");
                sb23.append(obj);
                throw new IllegalArgumentException(sb23.toString());
            case 24:
                if ("layout/activity_notice_center_0".equals(obj)) {
                    return new ActivityNoticeCenterBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb24 = new StringBuilder();
                sb24.append("The tag for activity_notice_center is invalid. Received: ");
                sb24.append(obj);
                throw new IllegalArgumentException(sb24.toString());
            case 25:
                if ("layout/activity_online_service_0".equals(obj)) {
                    return new ActivityOnlineServiceBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb25 = new StringBuilder();
                sb25.append("The tag for activity_online_service is invalid. Received: ");
                sb25.append(obj);
                throw new IllegalArgumentException(sb25.toString());
            case 26:
                if ("layout/activity_order_0".equals(obj)) {
                    return new ActivityOrderBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb26 = new StringBuilder();
                sb26.append("The tag for activity_order is invalid. Received: ");
                sb26.append(obj);
                throw new IllegalArgumentException(sb26.toString());
            case 27:
                if ("layout/activity_order_details_0".equals(obj)) {
                    return new ActivityOrderDetailsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb27 = new StringBuilder();
                sb27.append("The tag for activity_order_details is invalid. Received: ");
                sb27.append(obj);
                throw new IllegalArgumentException(sb27.toString());
            case 28:
                if ("layout/activity_phone_0".equals(obj)) {
                    return new ActivityPhoneBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb28 = new StringBuilder();
                sb28.append("The tag for activity_phone is invalid. Received: ");
                sb28.append(obj);
                throw new IllegalArgumentException(sb28.toString());
            case 29:
                if ("layout/activity_phone_login_0".equals(obj)) {
                    return new ActivityPhoneLoginBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb29 = new StringBuilder();
                sb29.append("The tag for activity_phone_login is invalid. Received: ");
                sb29.append(obj);
                throw new IllegalArgumentException(sb29.toString());
            case 30:
                if ("layout/activity_private_0".equals(obj)) {
                    return new ActivityPrivateBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb30 = new StringBuilder();
                sb30.append("The tag for activity_private is invalid. Received: ");
                sb30.append(obj);
                throw new IllegalArgumentException(sb30.toString());
            case 31:
                if ("layout/activity_ranking_list_0".equals(obj)) {
                    return new ActivityRankingListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb31 = new StringBuilder();
                sb31.append("The tag for activity_ranking_list is invalid. Received: ");
                sb31.append(obj);
                throw new IllegalArgumentException(sb31.toString());
            case 32:
                if ("layout/activity_real_name_auth_0".equals(obj)) {
                    return new ActivityRealNameAuthBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb32 = new StringBuilder();
                sb32.append("The tag for activity_real_name_auth is invalid. Received: ");
                sb32.append(obj);
                throw new IllegalArgumentException(sb32.toString());
            case 33:
                if ("layout/activity_search_0".equals(obj)) {
                    return new ActivitySearchBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb33 = new StringBuilder();
                sb33.append("The tag for activity_search is invalid. Received: ");
                sb33.append(obj);
                throw new IllegalArgumentException(sb33.toString());
            case 34:
                if ("layout/activity_setting_0".equals(obj)) {
                    return new ActivitySettingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb34 = new StringBuilder();
                sb34.append("The tag for activity_setting is invalid. Received: ");
                sb34.append(obj);
                throw new IllegalArgumentException(sb34.toString());
            case 35:
                if ("layout/activity_social_information_0".equals(obj)) {
                    return new ActivitySocialInformationBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb35 = new StringBuilder();
                sb35.append("The tag for activity_social_information is invalid. Received: ");
                sb35.append(obj);
                throw new IllegalArgumentException(sb35.toString());
            case 36:
                if ("layout/activity_splash_0".equals(obj)) {
                    return new ActivitySplashBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb36 = new StringBuilder();
                sb36.append("The tag for activity_splash is invalid. Received: ");
                sb36.append(obj);
                throw new IllegalArgumentException(sb36.toString());
            case 37:
                if ("layout/activity_today_profit_logs_0".equals(obj)) {
                    return new ActivityTodayProfitLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb37 = new StringBuilder();
                sb37.append("The tag for activity_today_profit_logs is invalid. Received: ");
                sb37.append(obj);
                throw new IllegalArgumentException(sb37.toString());
            case 38:
                if ("layout/activity_travel_income_logs_0".equals(obj)) {
                    return new ActivityTravelIncomeLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb38 = new StringBuilder();
                sb38.append("The tag for activity_travel_income_logs is invalid. Received: ");
                sb38.append(obj);
                throw new IllegalArgumentException(sb38.toString());
            case 39:
                if ("layout/activity_web_0".equals(obj)) {
                    return new ActivityWebBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb39 = new StringBuilder();
                sb39.append("The tag for activity_web is invalid. Received: ");
                sb39.append(obj);
                throw new IllegalArgumentException(sb39.toString());
            case 40:
                if ("layout/dialog_achieve_goal_0".equals(obj)) {
                    return new DialogAchieveGoalBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb40 = new StringBuilder();
                sb40.append("The tag for dialog_achieve_goal is invalid. Received: ");
                sb40.append(obj);
                throw new IllegalArgumentException(sb40.toString());
            case 41:
                if ("layout/dialog_bind_inviter_0".equals(obj)) {
                    return new DialogBindInviterBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb41 = new StringBuilder();
                sb41.append("The tag for dialog_bind_inviter is invalid. Received: ");
                sb41.append(obj);
                throw new IllegalArgumentException(sb41.toString());
            case 42:
                if ("layout/dialog_bind_phone_hint_0".equals(obj)) {
                    return new DialogBindPhoneHintBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb42 = new StringBuilder();
                sb42.append("The tag for dialog_bind_phone_hint is invalid. Received: ");
                sb42.append(obj);
                throw new IllegalArgumentException(sb42.toString());
            case 43:
                if ("layout/dialog_buy_capacity_0".equals(obj)) {
                    return new DialogBuyCapacityBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb43 = new StringBuilder();
                sb43.append("The tag for dialog_buy_capacity is invalid. Received: ");
                sb43.append(obj);
                throw new IllegalArgumentException(sb43.toString());
            case 44:
                if ("layout/dialog_cash_rule_0".equals(obj)) {
                    return new DialogCashRuleBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb44 = new StringBuilder();
                sb44.append("The tag for dialog_cash_rule is invalid. Received: ");
                sb44.append(obj);
                throw new IllegalArgumentException(sb44.toString());
            case 45:
                if ("layout/dialog_change_avatar_0".equals(obj)) {
                    return new DialogChangeAvatarBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb45 = new StringBuilder();
                sb45.append("The tag for dialog_change_avatar is invalid. Received: ");
                sb45.append(obj);
                throw new IllegalArgumentException(sb45.toString());
            case 46:
                if ("layout/dialog_channel_explain_0".equals(obj)) {
                    return new DialogChannelExplainBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb46 = new StringBuilder();
                sb46.append("The tag for dialog_channel_explain is invalid. Received: ");
                sb46.append(obj);
                throw new IllegalArgumentException(sb46.toString());
            case 47:
                if ("layout/dialog_coin_box_0".equals(obj)) {
                    return new DialogCoinBoxBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb47 = new StringBuilder();
                sb47.append("The tag for dialog_coin_box is invalid. Received: ");
                sb47.append(obj);
                throw new IllegalArgumentException(sb47.toString());
            case 48:
                if ("layout/dialog_coin_short_0".equals(obj)) {
                    return new DialogCoinShortBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb48 = new StringBuilder();
                sb48.append("The tag for dialog_coin_short is invalid. Received: ");
                sb48.append(obj);
                throw new IllegalArgumentException(sb48.toString());
            case 49:
                if ("layout/dialog_dog_detail_0".equals(obj)) {
                    return new DialogDogDetailBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb49 = new StringBuilder();
                sb49.append("The tag for dialog_dog_detail is invalid. Received: ");
                sb49.append(obj);
                throw new IllegalArgumentException(sb49.toString());
            case 50:
                if ("layout/dialog_dog_shop_0".equals(obj)) {
                    return new DialogDogShopBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb50 = new StringBuilder();
                sb50.append("The tag for dialog_dog_shop is invalid. Received: ");
                sb50.append(obj);
                throw new IllegalArgumentException(sb50.toString());
            default:
                return null;
        }
    }

    /* renamed from: b */
    private final ViewDataBinding m12736b(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/dialog_dog_upgrade_0".equals(obj)) {
                    return new DialogDogUpgradeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The tag for dialog_dog_upgrade is invalid. Received: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString());
            case 52:
                if ("layout/dialog_double_coin_0".equals(obj)) {
                    return new DialogDoubleCoinBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The tag for dialog_double_coin is invalid. Received: ");
                sb2.append(obj);
                throw new IllegalArgumentException(sb2.toString());
            case 53:
                if ("layout/dialog_exit_0".equals(obj)) {
                    return new DialogExitBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The tag for dialog_exit is invalid. Received: ");
                sb3.append(obj);
                throw new IllegalArgumentException(sb3.toString());
            case 54:
                if ("layout/dialog_explore_rule_0".equals(obj)) {
                    return new DialogExploreRuleBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("The tag for dialog_explore_rule is invalid. Received: ");
                sb4.append(obj);
                throw new IllegalArgumentException(sb4.toString());
            case 55:
                if ("layout/dialog_get_bonus_dog_0".equals(obj)) {
                    return new DialogGetBonusDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("The tag for dialog_get_bonus_dog is invalid. Received: ");
                sb5.append(obj);
                throw new IllegalArgumentException(sb5.toString());
            case 56:
                if ("layout/dialog_get_coin_0".equals(obj)) {
                    return new DialogGetCoinBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("The tag for dialog_get_coin is invalid. Received: ");
                sb6.append(obj);
                throw new IllegalArgumentException(sb6.toString());
            case 57:
                if ("layout/dialog_get_dog_0".equals(obj)) {
                    return new DialogGetDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("The tag for dialog_get_dog is invalid. Received: ");
                sb7.append(obj);
                throw new IllegalArgumentException(sb7.toString());
            case 58:
                if ("layout/dialog_get_max_level_dog_0".equals(obj)) {
                    return new DialogGetMaxLevelDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("The tag for dialog_get_max_level_dog is invalid. Received: ");
                sb8.append(obj);
                throw new IllegalArgumentException(sb8.toString());
            case 59:
                if ("layout/dialog_harvest_0".equals(obj)) {
                    return new DialogHarvestBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("The tag for dialog_harvest is invalid. Received: ");
                sb9.append(obj);
                throw new IllegalArgumentException(sb9.toString());
            case 60:
                if ("layout/dialog_hb_0".equals(obj)) {
                    return new DialogHbBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append("The tag for dialog_hb is invalid. Received: ");
                sb10.append(obj);
                throw new IllegalArgumentException(sb10.toString());
            case 61:
                if ("layout/dialog_inviter_hint_0".equals(obj)) {
                    return new DialogInviterHintBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append("The tag for dialog_inviter_hint is invalid. Received: ");
                sb11.append(obj);
                throw new IllegalArgumentException(sb11.toString());
            case 62:
                if ("layout/dialog_loading_0".equals(obj)) {
                    return new DialogLoadingBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append("The tag for dialog_loading is invalid. Received: ");
                sb12.append(obj);
                throw new IllegalArgumentException(sb12.toString());
            case 63:
                if ("layout/dialog_luck_ticket_0".equals(obj)) {
                    return new DialogLuckTicketBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb13 = new StringBuilder();
                sb13.append("The tag for dialog_luck_ticket is invalid. Received: ");
                sb13.append(obj);
                throw new IllegalArgumentException(sb13.toString());
            case 64:
                if ("layout/dialog_lucky_draw_0".equals(obj)) {
                    return new DialogLuckyDrawBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb14 = new StringBuilder();
                sb14.append("The tag for dialog_lucky_draw is invalid. Received: ");
                sb14.append(obj);
                throw new IllegalArgumentException(sb14.toString());
            case 65:
                if ("layout/dialog_merge_bonus_dog_0".equals(obj)) {
                    return new DialogMergeBonusDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb15 = new StringBuilder();
                sb15.append("The tag for dialog_merge_bonus_dog is invalid. Received: ");
                sb15.append(obj);
                throw new IllegalArgumentException(sb15.toString());
            case 66:
                if ("layout/dialog_my_bonus_dog_0".equals(obj)) {
                    return new DialogMyBonusDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb16 = new StringBuilder();
                sb16.append("The tag for dialog_my_bonus_dog is invalid. Received: ");
                sb16.append(obj);
                throw new IllegalArgumentException(sb16.toString());
            case 67:
                if ("layout/dialog_my_inviter_0".equals(obj)) {
                    return new DialogMyInviterBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb17 = new StringBuilder();
                sb17.append("The tag for dialog_my_inviter is invalid. Received: ");
                sb17.append(obj);
                throw new IllegalArgumentException(sb17.toString());
            case 68:
                if ("layout/dialog_offline_profit_0".equals(obj)) {
                    return new DialogOfflineProfitBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb18 = new StringBuilder();
                sb18.append("The tag for dialog_offline_profit is invalid. Received: ");
                sb18.append(obj);
                throw new IllegalArgumentException(sb18.toString());
            case 69:
                if ("layout/dialog_pay_0".equals(obj)) {
                    return new DialogPayBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb19 = new StringBuilder();
                sb19.append("The tag for dialog_pay is invalid. Received: ");
                sb19.append(obj);
                throw new IllegalArgumentException(sb19.toString());
            case 70:
                if ("layout/dialog_protocol_0".equals(obj)) {
                    return new DialogProtocolBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb20 = new StringBuilder();
                sb20.append("The tag for dialog_protocol is invalid. Received: ");
                sb20.append(obj);
                throw new IllegalArgumentException(sb20.toString());
            case 71:
                if ("layout/dialog_random_merge_0".equals(obj)) {
                    return new DialogRandomMergeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb21 = new StringBuilder();
                sb21.append("The tag for dialog_random_merge is invalid. Received: ");
                sb21.append(obj);
                throw new IllegalArgumentException(sb21.toString());
            case 72:
                if ("layout/dialog_real_name_auth_fail_0".equals(obj)) {
                    return new DialogRealNameAuthFailBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb22 = new StringBuilder();
                sb22.append("The tag for dialog_real_name_auth_fail is invalid. Received: ");
                sb22.append(obj);
                throw new IllegalArgumentException(sb22.toString());
            case 73:
                if ("layout/dialog_recall_0".equals(obj)) {
                    return new DialogRecallBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb23 = new StringBuilder();
                sb23.append("The tag for dialog_recall is invalid. Received: ");
                sb23.append(obj);
                throw new IllegalArgumentException(sb23.toString());
            case 74:
                if ("layout/dialog_recycle_hint_0".equals(obj)) {
                    return new DialogRecycleHintBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb24 = new StringBuilder();
                sb24.append("The tag for dialog_recycle_hint is invalid. Received: ");
                sb24.append(obj);
                throw new IllegalArgumentException(sb24.toString());
            case 75:
                if ("layout/dialog_recycle_special_hint_0".equals(obj)) {
                    return new DialogRecycleSpecialHintBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb25 = new StringBuilder();
                sb25.append("The tag for dialog_recycle_special_hint is invalid. Received: ");
                sb25.append(obj);
                throw new IllegalArgumentException(sb25.toString());
            case 76:
                if ("layout/dialog_resurgence_0".equals(obj)) {
                    return new DialogResurgenceBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb26 = new StringBuilder();
                sb26.append("The tag for dialog_resurgence is invalid. Received: ");
                sb26.append(obj);
                throw new IllegalArgumentException(sb26.toString());
            case 77:
                if ("layout/dialog_share_0".equals(obj)) {
                    return new DialogShareBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb27 = new StringBuilder();
                sb27.append("The tag for dialog_share is invalid. Received: ");
                sb27.append(obj);
                throw new IllegalArgumentException(sb27.toString());
            case 78:
                if ("layout/dialog_system_notice_0".equals(obj)) {
                    return new DialogSystemNoticeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb28 = new StringBuilder();
                sb28.append("The tag for dialog_system_notice is invalid. Received: ");
                sb28.append(obj);
                throw new IllegalArgumentException(sb28.toString());
            case 79:
                if ("layout/dialog_taobao_auth_0".equals(obj)) {
                    return new DialogTaobaoAuthBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb29 = new StringBuilder();
                sb29.append("The tag for dialog_taobao_auth is invalid. Received: ");
                sb29.append(obj);
                throw new IllegalArgumentException(sb29.toString());
            case 80:
                if ("layout/dialog_target_explain_0".equals(obj)) {
                    return new DialogTargetExplainBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb30 = new StringBuilder();
                sb30.append("The tag for dialog_target_explain is invalid. Received: ");
                sb30.append(obj);
                throw new IllegalArgumentException(sb30.toString());
            case 81:
                if ("layout/dialog_temp_bonus_0".equals(obj)) {
                    return new DialogTempBonusBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb31 = new StringBuilder();
                sb31.append("The tag for dialog_temp_bonus is invalid. Received: ");
                sb31.append(obj);
                throw new IllegalArgumentException(sb31.toString());
            case 82:
                if ("layout/dialog_temp_bonus_dog_0".equals(obj)) {
                    return new DialogTempBonusDogBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb32 = new StringBuilder();
                sb32.append("The tag for dialog_temp_bonus_dog is invalid. Received: ");
                sb32.append(obj);
                throw new IllegalArgumentException(sb32.toString());
            case 83:
                if ("layout/dialog_temp_bonus_profit_0".equals(obj)) {
                    return new DialogTempBonusProfitBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb33 = new StringBuilder();
                sb33.append("The tag for dialog_temp_bonus_profit is invalid. Received: ");
                sb33.append(obj);
                throw new IllegalArgumentException(sb33.toString());
            case 84:
                if ("layout/dialog_total_profit_0".equals(obj)) {
                    return new DialogTotalProfitBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb34 = new StringBuilder();
                sb34.append("The tag for dialog_total_profit is invalid. Received: ");
                sb34.append(obj);
                throw new IllegalArgumentException(sb34.toString());
            case 85:
                if ("layout/dialog_travel_city_0".equals(obj)) {
                    return new DialogTravelCityBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb35 = new StringBuilder();
                sb35.append("The tag for dialog_travel_city is invalid. Received: ");
                sb35.append(obj);
                throw new IllegalArgumentException(sb35.toString());
            case 86:
                if ("layout/dialog_unlock_city_0".equals(obj)) {
                    return new DialogUnlockCityBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb36 = new StringBuilder();
                sb36.append("The tag for dialog_unlock_city is invalid. Received: ");
                sb36.append(obj);
                throw new IllegalArgumentException(sb36.toString());
            case 87:
                if ("layout/dialog_upgrade_channel_0".equals(obj)) {
                    return new DialogUpgradeChannelBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb37 = new StringBuilder();
                sb37.append("The tag for dialog_upgrade_channel is invalid. Received: ");
                sb37.append(obj);
                throw new IllegalArgumentException(sb37.toString());
            case 88:
                if ("layout/dialog_warehouse_0".equals(obj)) {
                    return new DialogWarehouseBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb38 = new StringBuilder();
                sb38.append("The tag for dialog_warehouse is invalid. Received: ");
                sb38.append(obj);
                throw new IllegalArgumentException(sb38.toString());
            case 89:
                if ("layout/dialog_warehouse_hint_0".equals(obj)) {
                    return new DialogWarehouseHintBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb39 = new StringBuilder();
                sb39.append("The tag for dialog_warehouse_hint is invalid. Received: ");
                sb39.append(obj);
                throw new IllegalArgumentException(sb39.toString());
            case 90:
                if ("layout/fragment_coin_rank_list_0".equals(obj)) {
                    return new FragmentCoinRankListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb40 = new StringBuilder();
                sb40.append("The tag for fragment_coin_rank_list is invalid. Received: ");
                sb40.append(obj);
                throw new IllegalArgumentException(sb40.toString());
            case 91:
                if ("layout/fragment_dog_rank_list_0".equals(obj)) {
                    return new FragmentDogRankListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb41 = new StringBuilder();
                sb41.append("The tag for fragment_dog_rank_list is invalid. Received: ");
                sb41.append(obj);
                throw new IllegalArgumentException(sb41.toString());
            case 92:
                if ("layout/fragment_invite_logs_0".equals(obj)) {
                    return new FragmentInviteLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb42 = new StringBuilder();
                sb42.append("The tag for fragment_invite_logs is invalid. Received: ");
                sb42.append(obj);
                throw new IllegalArgumentException(sb42.toString());
            case 93:
                if ("layout/fragment_me_0".equals(obj)) {
                    return new FragmentMeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb43 = new StringBuilder();
                sb43.append("The tag for fragment_me is invalid. Received: ");
                sb43.append(obj);
                throw new IllegalArgumentException(sb43.toString());
            case 94:
                if ("layout/fragment_order_0".equals(obj)) {
                    return new FragmentOrderBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb44 = new StringBuilder();
                sb44.append("The tag for fragment_order is invalid. Received: ");
                sb44.append(obj);
                throw new IllegalArgumentException(sb44.toString());
            case 95:
                if ("layout/fragment_profit_rank_list_0".equals(obj)) {
                    return new FragmentProfitRankListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb45 = new StringBuilder();
                sb45.append("The tag for fragment_profit_rank_list is invalid. Received: ");
                sb45.append(obj);
                throw new IllegalArgumentException(sb45.toString());
            case 96:
                if ("layout/fragment_tb_0".equals(obj)) {
                    return new FragmentTbBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb46 = new StringBuilder();
                sb46.append("The tag for fragment_tb is invalid. Received: ");
                sb46.append(obj);
                throw new IllegalArgumentException(sb46.toString());
            case 97:
                if ("layout/fragment_tour_group_0".equals(obj)) {
                    return new FragmentTourGroupBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb47 = new StringBuilder();
                sb47.append("The tag for fragment_tour_group is invalid. Received: ");
                sb47.append(obj);
                throw new IllegalArgumentException(sb47.toString());
            case 98:
                if ("layout/fragment_travel_0".equals(obj)) {
                    return new FragmentTravelBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb48 = new StringBuilder();
                sb48.append("The tag for fragment_travel is invalid. Received: ");
                sb48.append(obj);
                throw new IllegalArgumentException(sb48.toString());
            case 99:
                if ("layout/item_answer_0".equals(obj)) {
                    return new ItemAnswerBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb49 = new StringBuilder();
                sb49.append("The tag for item_answer is invalid. Received: ");
                sb49.append(obj);
                throw new IllegalArgumentException(sb49.toString());
            case 100:
                if ("layout/item_answer_wrong_0".equals(obj)) {
                    return new ItemAnswerWrongBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb50 = new StringBuilder();
                sb50.append("The tag for item_answer_wrong is invalid. Received: ");
                sb50.append(obj);
                throw new IllegalArgumentException(sb50.toString());
            default:
                return null;
        }
    }

    /* renamed from: c */
    private final ViewDataBinding m12737c(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 101:
                if ("layout/item_answer_wrong_sub_0".equals(obj)) {
                    return new ItemAnswerWrongSubBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("The tag for item_answer_wrong_sub is invalid. Received: ");
                sb.append(obj);
                throw new IllegalArgumentException(sb.toString());
            case 102:
                if ("layout/item_associate_0".equals(obj)) {
                    return new ItemAssociateBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("The tag for item_associate is invalid. Received: ");
                sb2.append(obj);
                throw new IllegalArgumentException(sb2.toString());
            case 103:
                if ("layout/item_cash_amount_0".equals(obj)) {
                    return new ItemCashAmountBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The tag for item_cash_amount is invalid. Received: ");
                sb3.append(obj);
                throw new IllegalArgumentException(sb3.toString());
            case 104:
                if ("layout/item_cash_rule_0".equals(obj)) {
                    return new ItemCashRuleBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("The tag for item_cash_rule is invalid. Received: ");
                sb4.append(obj);
                throw new IllegalArgumentException(sb4.toString());
            case 105:
                if ("layout/item_cash_type_0".equals(obj)) {
                    return new ItemCashTypeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("The tag for item_cash_type is invalid. Received: ");
                sb5.append(obj);
                throw new IllegalArgumentException(sb5.toString());
            case 106:
                if ("layout/item_coin_rank_list_0".equals(obj)) {
                    return new ItemCoinRankListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("The tag for item_coin_rank_list is invalid. Received: ");
                sb6.append(obj);
                throw new IllegalArgumentException(sb6.toString());
            case 107:
                if ("layout/item_dog_info_0".equals(obj)) {
                    return new ItemDogInfoBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append("The tag for item_dog_info is invalid. Received: ");
                sb7.append(obj);
                throw new IllegalArgumentException(sb7.toString());
            case 108:
                if ("layout/item_dog_rank_list_0".equals(obj)) {
                    return new ItemDogRankListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb8 = new StringBuilder();
                sb8.append("The tag for item_dog_rank_list is invalid. Received: ");
                sb8.append(obj);
                throw new IllegalArgumentException(sb8.toString());
            case 109:
                if ("layout/item_dog_shop_0".equals(obj)) {
                    return new ItemDogShopBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb9 = new StringBuilder();
                sb9.append("The tag for item_dog_shop is invalid. Received: ");
                sb9.append(obj);
                throw new IllegalArgumentException(sb9.toString());
            case 110:
                if ("layout/item_dynamic_content_0".equals(obj)) {
                    return new ItemDynamicContentBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb10 = new StringBuilder();
                sb10.append("The tag for item_dynamic_content is invalid. Received: ");
                sb10.append(obj);
                throw new IllegalArgumentException(sb10.toString());
            case 111:
                if ("layout/item_dynamic_title_0".equals(obj)) {
                    return new ItemDynamicTitleBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb11 = new StringBuilder();
                sb11.append("The tag for item_dynamic_title is invalid. Received: ");
                sb11.append(obj);
                throw new IllegalArgumentException(sb11.toString());
            case 112:
                if ("layout/item_explore_dynamic_0".equals(obj)) {
                    return new ItemExploreDynamicBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb12 = new StringBuilder();
                sb12.append("The tag for item_explore_dynamic is invalid. Received: ");
                sb12.append(obj);
                throw new IllegalArgumentException(sb12.toString());
            case 113:
                if ("layout/item_explore_harvest_0".equals(obj)) {
                    return new ItemExploreHarvestBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb13 = new StringBuilder();
                sb13.append("The tag for item_explore_harvest is invalid. Received: ");
                sb13.append(obj);
                throw new IllegalArgumentException(sb13.toString());
            case 114:
                if ("layout/item_explore_team_0".equals(obj)) {
                    return new ItemExploreTeamBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb14 = new StringBuilder();
                sb14.append("The tag for item_explore_team is invalid. Received: ");
                sb14.append(obj);
                throw new IllegalArgumentException(sb14.toString());
            case 115:
                if ("layout/item_handbook_0".equals(obj)) {
                    return new ItemHandbookBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb15 = new StringBuilder();
                sb15.append("The tag for item_handbook is invalid. Received: ");
                sb15.append(obj);
                throw new IllegalArgumentException(sb15.toString());
            case 116:
                if ("layout/item_invite_logs_0".equals(obj)) {
                    return new ItemInviteLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb16 = new StringBuilder();
                sb16.append("The tag for item_invite_logs is invalid. Received: ");
                sb16.append(obj);
                throw new IllegalArgumentException(sb16.toString());
            case 117:
                if ("layout/item_list_empty_0".equals(obj)) {
                    return new ItemListEmptyBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb17 = new StringBuilder();
                sb17.append("The tag for item_list_empty is invalid. Received: ");
                sb17.append(obj);
                throw new IllegalArgumentException(sb17.toString());
            case 118:
                if ("layout/item_logs_0".equals(obj)) {
                    return new ItemLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb18 = new StringBuilder();
                sb18.append("The tag for item_logs is invalid. Received: ");
                sb18.append(obj);
                throw new IllegalArgumentException(sb18.toString());
            case 119:
                if ("layout/item_map_0".equals(obj)) {
                    return new ItemMapBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb19 = new StringBuilder();
                sb19.append("The tag for item_map is invalid. Received: ");
                sb19.append(obj);
                throw new IllegalArgumentException(sb19.toString());
            case 120:
                if ("layout/item_may_harvest_0".equals(obj)) {
                    return new ItemMayHarvestBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb20 = new StringBuilder();
                sb20.append("The tag for item_may_harvest is invalid. Received: ");
                sb20.append(obj);
                throw new IllegalArgumentException(sb20.toString());
            case 121:
                if ("layout/item_me_divider_0".equals(obj)) {
                    return new ItemMeDividerBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb21 = new StringBuilder();
                sb21.append("The tag for item_me_divider is invalid. Received: ");
                sb21.append(obj);
                throw new IllegalArgumentException(sb21.toString());
            case 122:
                if ("layout/item_me_normal_0".equals(obj)) {
                    return new ItemMeNormalBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb22 = new StringBuilder();
                sb22.append("The tag for item_me_normal is invalid. Received: ");
                sb22.append(obj);
                throw new IllegalArgumentException(sb22.toString());
            case 123:
                if ("layout/item_me_task_0".equals(obj)) {
                    return new ItemMeTaskBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb23 = new StringBuilder();
                sb23.append("The tag for item_me_task is invalid. Received: ");
                sb23.append(obj);
                throw new IllegalArgumentException(sb23.toString());
            case 124:
                if ("layout/item_merge_0".equals(obj)) {
                    return new ItemMergeBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb24 = new StringBuilder();
                sb24.append("The tag for item_merge is invalid. Received: ");
                sb24.append(obj);
                throw new IllegalArgumentException(sb24.toString());
            case 125:
                if ("layout/item_notice_center_0".equals(obj)) {
                    return new ItemNoticeCenterBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb25 = new StringBuilder();
                sb25.append("The tag for item_notice_center is invalid. Received: ");
                sb25.append(obj);
                throw new IllegalArgumentException(sb25.toString());
            case 126:
                if ("layout/item_order_0".equals(obj)) {
                    return new ItemOrderBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb26 = new StringBuilder();
                sb26.append("The tag for item_order is invalid. Received: ");
                sb26.append(obj);
                throw new IllegalArgumentException(sb26.toString());
            case 127:
                if ("layout/item_order_coin_0".equals(obj)) {
                    return new ItemOrderCoinBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb27 = new StringBuilder();
                sb27.append("The tag for item_order_coin is invalid. Received: ");
                sb27.append(obj);
                throw new IllegalArgumentException(sb27.toString());
            case 128:
                if ("layout/item_pay_0".equals(obj)) {
                    return new ItemPayBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb28 = new StringBuilder();
                sb28.append("The tag for item_pay is invalid. Received: ");
                sb28.append(obj);
                throw new IllegalArgumentException(sb28.toString());
            case 129:
                if ("layout/item_profit_rank_list_0".equals(obj)) {
                    return new ItemProfitRankListBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb29 = new StringBuilder();
                sb29.append("The tag for item_profit_rank_list is invalid. Received: ");
                sb29.append(obj);
                throw new IllegalArgumentException(sb29.toString());
            case 130:
                if ("layout/item_search_result_0".equals(obj)) {
                    return new ItemSearchResultBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb30 = new StringBuilder();
                sb30.append("The tag for item_search_result is invalid. Received: ");
                sb30.append(obj);
                throw new IllegalArgumentException(sb30.toString());
            case 131:
                if ("layout/item_share_0".equals(obj)) {
                    return new ItemShareBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb31 = new StringBuilder();
                sb31.append("The tag for item_share is invalid. Received: ");
                sb31.append(obj);
                throw new IllegalArgumentException(sb31.toString());
            case 132:
                if ("layout/item_sort_tab_0".equals(obj)) {
                    return new ItemSortTabBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb32 = new StringBuilder();
                sb32.append("The tag for item_sort_tab is invalid. Received: ");
                sb32.append(obj);
                throw new IllegalArgumentException(sb32.toString());
            case 133:
                if ("layout/item_today_profit_logs_0".equals(obj)) {
                    return new ItemTodayProfitLogsBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb33 = new StringBuilder();
                sb33.append("The tag for item_today_profit_logs is invalid. Received: ");
                sb33.append(obj);
                throw new IllegalArgumentException(sb33.toString());
            case 134:
                if ("layout/item_warehouse_0".equals(obj)) {
                    return new ItemWarehouseBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb34 = new StringBuilder();
                sb34.append("The tag for item_warehouse is invalid. Received: ");
                sb34.append(obj);
                throw new IllegalArgumentException(sb34.toString());
            case 135:
                if ("layout/layout_tab_0".equals(obj)) {
                    return new LayoutTabBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb35 = new StringBuilder();
                sb35.append("The tag for layout_tab is invalid. Received: ");
                sb35.append(obj);
                throw new IllegalArgumentException(sb35.toString());
            case 136:
                if ("layout/pop_sort_0".equals(obj)) {
                    return new PopSortBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb36 = new StringBuilder();
                sb36.append("The tag for pop_sort is invalid. Received: ");
                sb36.append(obj);
                throw new IllegalArgumentException(sb36.toString());
            case 137:
                if ("layout/qiyu_activity_online_service_0".equals(obj)) {
                    return new QiyuActivityOnlineServiceBindingImpl(dataBindingComponent, view);
                }
                StringBuilder sb37 = new StringBuilder();
                sb37.append("The tag for qiyu_activity_online_service is invalid. Received: ");
                sb37.append(obj);
                throw new IllegalArgumentException(sb37.toString());
            default:
                return null;
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f9535a.get(i);
        if (i2 > 0) {
            Object tag = view.getTag();
            if (tag != null) {
                int i3 = (i2 - 1) / 50;
                if (i3 == 0) {
                    return m12735a(dataBindingComponent, view, i2, tag);
                }
                if (i3 == 1) {
                    return m12736b(dataBindingComponent, view, i2, tag);
                }
                if (i3 == 2) {
                    return m12737c(dataBindingComponent, view, i2, tag);
                }
            } else {
                throw new RuntimeException("view must have a tag");
            }
        }
        return null;
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f9535a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        Integer num = (Integer) C2826b.f9537a.get(str);
        if (num != null) {
            i = num.intValue();
        }
        return i;
    }

    public String convertBrIdToString(int i) {
        return (String) C2825a.f9536a.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new reezy.app.farm.DataBinderMapperImpl());
        return arrayList;
    }
}
