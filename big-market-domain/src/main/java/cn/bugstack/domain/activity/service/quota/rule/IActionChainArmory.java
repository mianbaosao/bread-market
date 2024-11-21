package cn.bugstack.domain.activity.service.quota.rule;

/**
 * @description
 */
public interface IActionChainArmory {

    IActionChain next();

    IActionChain appendNext(IActionChain next);

}
