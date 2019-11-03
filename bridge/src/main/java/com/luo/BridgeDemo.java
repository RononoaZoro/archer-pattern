package com.luo;

/**
 * 桥接模式 将抽象部分与实现部分分离，使它们都可以独立的变化。
 * @author luoxuzheng
 * @create 2019-09-30 14:59
 **/
public class BridgeDemo {

    public static void main(String[] args) {

        ScanService scanService = new ScanServiceImpl(new ScanBuyService() {

            @Override
            public void buy() {
                System.out.println("JD 扫码购物");
            }
        }, null);

        // ScanService.scanBuy() -> ScanBuyService.buy();
        // 对应客户端而言，只关注粗粒度接口，具体执行方法是由运行时初始化而定。
        scanService.scanBuy();

        scanService = new ScanServiceImpl(new ScanBuyService() {

            @Override
            public void buy() {
                System.out.println("TB 扫码购物");
            }
        }, null);

        // ScanService.scanBuy() -> ScanBuyService.buy();
        scanService.scanBuy();


    }
}



