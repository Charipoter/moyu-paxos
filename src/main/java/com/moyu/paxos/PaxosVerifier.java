package com.moyu.paxos;

import java.util.Map;
import java.util.Set;
/**
 * 持有集群整体的成员信息
 */
public interface PaxosVerifier {

    /**
     * 给定同意者 id，判断该决议是否胜出（超过半数）
     */
    boolean reachConsensus(Set<Long> serverIds);
    /**
     * 获取集群所有成员信息
     */
    Map<Long, PaxosServerInfo> getAllMembers();

}
