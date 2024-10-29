package cn.bugstack.trigger.api.dto;

import lombok.Data;

/**
 * @description 活动抽奖请求对象
 */
@Data
public class ActivityDrawRequestDTO {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
