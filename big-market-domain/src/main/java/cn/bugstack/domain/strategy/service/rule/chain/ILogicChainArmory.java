package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @description 责任链装配
 * 放置的是责任链的次要方法
 */
public interface ILogicChainArmory {

    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);

}
