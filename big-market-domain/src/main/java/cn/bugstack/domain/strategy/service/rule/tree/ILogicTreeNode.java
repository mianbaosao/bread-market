package cn.bugstack.domain.strategy.service.rule.tree;

import cn.bugstack.domain.strategy.service.rule.tree.factory.DefaultTreeFactory;

/**
 * @description 规则树接口
 */
public interface ILogicTreeNode {

    //返回RuleLoginCheckTypeVo（就是是否放行）和StategyAwardVO
    DefaultTreeFactory.TreeActionEntity logic(String userId, Long strategyId, Integer awardId, String ruleValue);

}
