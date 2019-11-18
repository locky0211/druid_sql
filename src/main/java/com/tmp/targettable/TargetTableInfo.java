package com.tmp.targettable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 插入的目标表信息
 */
public class TargetTableInfo implements Serializable{

    //插入目标表名称
    private String targetTableName;


    private List<String> tableColumn = new ArrayList<String>();//目标表字段

    //目标表字段对应关系<表字段名，对应关系>
    private List<TargetTableColumn> tableColumnList = new ArrayList<TargetTableColumn>();

    public TargetTableInfo() {

    }

    public TargetTableInfo(String targetTableName) {
        this.targetTableName = targetTableName;
    }

    public String getTargetTableName() {
        return targetTableName;
    }

    public void setTargetTableName(String targetTableName) {
        this.targetTableName = targetTableName;
    }

    public List<TargetTableColumn> getTableColumnList() {
        return tableColumnList;
    }

    public void setTableColumnList(List<TargetTableColumn> tableColumnList) {
        this.tableColumnList = tableColumnList;
    }

    public List<String> getTableColumn() {
        return tableColumn;
    }

    public void setTableColumn(List<String> tableColumn) {
        this.tableColumn = tableColumn;
    }
}
