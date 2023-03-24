package com.poetrygame.dto.cityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class playerInformationQuery {
    private Integer pageNum = 0;   // 当前的页面
    private Integer pageSize = 10;  // 每一页所显示的数量
    private String AliasName;
    private Integer status;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAliasName() {
        return AliasName;
    }

    public void setAliasName(String aliasName) {
        AliasName = aliasName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
