package cn.bugstack.domain.strategy.service.rule.tree.factory.engine;

import cn.bugstack.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @description 规则树组合接口
 *              执行器接口
 */
public interface IDecisionTreeEngine {

    //返回奖品id和奖品ruleValue(一些判断条件)
    DefaultTreeFactory.StrategyAwardVO process(String userId, Long strategyId, Integer awardId);

}
