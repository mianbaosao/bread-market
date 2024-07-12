package cn.bugstack.domain.strategy.service.rule.filter;

import cn.bugstack.domain.strategy.model.entity.RuleActionEntity;
import cn.bugstack.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 抽奖规则过滤接口
 * @create 2024-01-06 09:55
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {

    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);

}
