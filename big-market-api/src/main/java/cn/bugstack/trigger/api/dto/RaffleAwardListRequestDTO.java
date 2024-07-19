package cn.bugstack.trigger.api.dto;

import lombok.Data;

/**
 * @description 抽奖奖品列表，请求对象
 */
@Data
public class RaffleAwardListRequestDTO {

    // 抽奖策略ID
    private Long strategyId;

}
