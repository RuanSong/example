package com.ytx.example.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元工厂类
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class ReportManagerFactory {
    private Map<String, IReportManager> financialReportManager = new HashMap<>();
    private Map<String, IReportManager> employeeReportManager = new HashMap<>();

    public IReportManager getFinancialReportManager(String tenantId) {
        IReportManager report = financialReportManager.get(tenantId);
        if (report == null) {
            report = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, report);
        }
        return report;
    }

    public IReportManager getEmployeeReportManager(String tenantId) {
        IReportManager report = employeeReportManager.get(tenantId);
        if (report == null) {
            report = new EmployeeReportManager(tenantId);
            employeeReportManager.put(tenantId, report);
        }
        return report;
    }
}
