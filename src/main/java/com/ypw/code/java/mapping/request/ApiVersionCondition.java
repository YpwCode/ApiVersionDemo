package com.ypw.code.java.mapping.request;

import com.ypw.code.java.mapping.common.Const;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: yangpengwei
 * @time: 2021/5/26 9:49 上午
 * @description 接口版本条件过滤匹配
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    /**
     * @author: yangpengwei
     * @time: 2021/5/26 9:52 上午
     * @description 默认最高版本
     */
    private static final String DEFAULT_VERSION = Const.API_VERSION;

    /**
     * @author: yangpengwei
     * @time: 2021/5/26 9:52 上午
     * @description 请求头字段
     */
    private static final String HEADER_VERSION = "version";

    /**
     * @author: yangpengwei
     * @time: 2021/5/26 9:55 上午
     * @description 版本号
     */
    private String apiVersion;

    public ApiVersionCondition(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        return new ApiVersionCondition(other.getApiVersion());
    }

   /**
    * @author: yangpengwei
    * @time: 2021/5/26 2:07 下午
    * @description 版本排序
    */
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        return compareTo(other.getApiVersion(), this.apiVersion) ? 1 : -1;
    }

    /**
     * @author: yangpengwei
     * @time: 2021/5/26 2:08 下午
     * @description 版本匹配, 默认最新版本, 向下就近匹配
     */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        String version = request.getHeader(HEADER_VERSION);
        if (!StringUtils.hasLength(version)) {
            version = DEFAULT_VERSION;
        }
        if (compareTo(version, this.apiVersion)) {
            return this;
        }
        return null;
    }

    /**
     * @author: yangpengwei
     * @time: 2021/5/26 2:10 下午
     * @description 排序对比
     */
    private boolean compareTo(String target, String other) {
        if (target.equals(other)) {
            return true;
        }

        target = target.replaceAll("\\.", "");
        other = other.replaceAll("\\.", "");
        int targetInt = Integer.parseInt(target);
        int otherInt = Integer.parseInt(other);
        return targetInt > otherInt;
    }

    public String getApiVersion() {
        return apiVersion;
    }
}