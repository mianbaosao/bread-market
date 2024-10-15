package cn.bugstack.infrastructure.persistent.dao;

import cn.bugstack.infrastructure.persistent.po.RaffleActivityAccount;
import cn.bugstack.middleware.db.router.annotation.DBRouter;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Bread
 * @description 抽奖活动账户表
 * @create 2024/9/26
 */
@Mapper
public interface IRaffleActivityAccountDao {
    void insert(RaffleActivityAccount raffleActivityAccount);

    int updateAccountQuota(RaffleActivityAccount raffleActivityAccount);

    @DBRouter
    RaffleActivityAccount queryActivityAccountByUserId(RaffleActivityAccount raffleActivityAccountReq);

    int updateActivityAccountSubtractionQuota(RaffleActivityAccount raffleActivityAccount);

    void updateActivityAccountMonthSurplusImageQuota(RaffleActivityAccount raffleActivityAccount);

    void updateActivityAccountDaySurplusImageQuota(RaffleActivityAccount raffleActivityAccount);
}
