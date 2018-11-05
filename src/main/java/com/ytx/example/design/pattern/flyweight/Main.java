package com.ytx.example.design.pattern.flyweight;

/**
 * 享元模式是为提升系统性能的是设计模式，主要作用是服用大对象，易节省内存空间和对象创建时间
 * SASS系统应用场景应用较多
 * <p>
 * 享元模式和对象池最大的不同在于：
 * 享元对象是不可互相替代的，他们各自有各自的含义和用途
 * 对象池中的对象都是等价的，如数据库连接池中的连接
 *
 * @author Rosan
 * @version 1.0
 * @date 2018/11/5
 */
public class Main {
    public static void main(String[] args) {
        ReportManagerFactory rmf = new ReportManagerFactory();
        IReportManager reportManager = rmf.getEmployeeReportManager("A");
        System.out.println(reportManager.createReport());

        IReportManager reportManager2 = rmf.getFinancialReportManager("A");
        System.out.println(reportManager2.createReport());

    }
}
