package cn.bugstack.domain.strategy.service.rule.chain;

/**
 * @description 责任链装配
 */
public interface ILogicChainArmory {

    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);

}
