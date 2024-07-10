package cn.bugstack.domain.strategy.service.rule.impl;

import cn.bugstack.domain.strategy.model.entity.RuleActionEntity;
import cn.bugstack.domain.strategy.model.entity.RuleMatterEntity;
import cn.bugstack.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.bugstack.domain.strategy.repository.IStrategyRepository;
import cn.bugstack.domain.strategy.service.annotation.LogicStrategy;
import cn.bugstack.domain.strategy.service.rule.ILogicFilter;
import cn.bugstack.domain.strategy.service.rule.factory.DefaultLogicFactory;
import cn.bugstack.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 【抽奖前规则】黑名单用户过滤规则
 */
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_BLACKLIST)
public class RuleBackListLogicFilter implements ILogicFilter<RuleActionEntity.RaffleBeforeEntity> {

    @Resource
    private IStrategyRepository repository;

    @Override
    public RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> filter(RuleMatterEntity ruleMatterEntity) {
        log.info("规则过滤-黑名单 userId:{} strategyId:{} ruleModel:{}", ruleMatterEntity.getUserId(), ruleMatterEntity.getStrategyId(), ruleMatterEntity.getRuleModel());

        String userId = ruleMatterEntity.getUserId();

        // 查询规则值配置
        String ruleValue = repository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(), ruleMatterEntity.getAwardId(), ruleMatterEntity.getRuleModel());
        String[] splitRuleValue = ruleValue.split(Constants.COLON);

        // 检查 splitRuleValue 的长度
        if (splitRuleValue.length > 1) {
            Integer awardId = Integer.parseInt(splitRuleValue[0]);
            String[] userBlackIds = splitRuleValue[1].split(Constants.SPLIT);
            for (String userBlackId : userBlackIds) {
                if (userId.equals(userBlackId)) {
                    return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                            .ruleModel(DefaultLogicFactory.LogicModel.RULE_BLACKLIST.getCode())
                            .data(RuleActionEntity.RaffleBeforeEntity.builder()
                                    .strategyId(ruleMatterEntity.getStrategyId())
                                    .awardId(awardId)
                                    .build())
                            .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                            .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                            .build();
                }
            }
        } else {
            log.warn("splitRuleValue 数组长度小于 2, ruleValue: {}", ruleValue);
        }

        return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                .build();
    }

}
