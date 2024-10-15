package cn.bugstack.domain.activity.model.entity;

import lombok.Data;

/**
 * @description 参与抽奖活动实体对象
 */
@Data
public class PartakeRaffleActivityEntity {

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 活动ID
     */
    private Long activityId;

}
