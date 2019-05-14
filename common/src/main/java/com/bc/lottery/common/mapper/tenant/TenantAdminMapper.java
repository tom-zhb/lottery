package com.bc.lottery.common.mapper.tenant;

import com.bc.lottery.common.core.mapper.BaseMapper;
import com.bc.lottery.common.domain.tenant.TenantAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TenantAdminMapper extends BaseMapper<TenantAdmin> {

    @Select("SELECT * FROM tenant_admin where user_name = #{userName} AND password = #{password}")
    TenantAdmin getTenantAdmin(@Param("userName") String userName, @Param("password") String password);


}
