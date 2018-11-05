package com.ytx.example.design.pattern.flyweight;

/**
 * 享元类
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class FinancialReportManager implements IReportManager {
    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is an financial report";
    }

}
