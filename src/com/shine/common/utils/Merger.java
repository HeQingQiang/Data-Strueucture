package com.shine.common.utils;

/**
 * 融合器接口
 *
 * @author shineYu
 * @date 2019/10/14 15:19
 * @Copyright shine_yu@vip.163.com .
 */
public interface Merger<E> {
    E merge(E a, E b);
}
