package cn.bugstack.domain.activity.service.armory;

/**
 * @description 活动装配预热
 */
public interface IActivityArmory {

    boolean assembleActivitySkuByActivityId(Long activityId);

    boolean assembleActivitySku(Long sku);
}
