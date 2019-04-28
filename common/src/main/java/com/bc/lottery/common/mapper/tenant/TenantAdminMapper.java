package com.bc.lottery.common.mapper.tenant;

import com.bc.lottery.common.core.mapper.BaseMapper;
import com.bc.lottery.common.domain.tenant.TenantAdminDO;
import org.apache.ibatis.annotations.Select;

public interface TenantAdminMapper extends BaseMapper<TenantAdminDO> {

    @Select("SELECT * FROM tenant_admin where user_name = #{user_name} AND password = #{password}")
    TenantAdminDO getTenantAdminDO(String user_name, String password);
}
