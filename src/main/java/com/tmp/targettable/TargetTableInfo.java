package com.tmp.targettable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 插入的目标表信息
 */
public class TargetTableInfo implements Serializable {

    //插入目标表名称,带shcema (eg: schema.tableName)
    private String targetTableName;
    private String tableOwner;//schema名
    private String tableName;//表名


    private List<String> tableColumn = new ArrayList<String>();//目标表字段

    //目标表字段对应关系<表字段名，对应关系>
    private List<TargetTableColumn> tableColumnList = new ArrayList<TargetTableColumn>();

    public TargetTableInfo() {

    }

    public TargetTableInfo(String targetTableName, String tableOwner, String tableName) {
        this.targetTableName = targetTableName;
        this.tableOwner = tableOwner;
        this.tableName = tableName;
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

    public String getTableOwner() {
        return tableOwner;
    }

    public void setTableOwner(String tableOwner) {
        this.tableOwner = tableOwner;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
