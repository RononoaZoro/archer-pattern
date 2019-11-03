package com.luo;

/**
 * Hello world!
 *
 */
class ScanServiceImpl implements ScanService {

    private ScanBuyService scanBuyService;

    private ScanLoginService scanLoginService;

    ScanServiceImpl(ScanBuyService scanBuyService, ScanLoginService scanLoginService) {
        this.scanBuyService = scanBuyService;
        this.scanLoginService = scanLoginService;
    }

    @Override
    public void scanBuy() {
        scanBuyService.buy();
    }

    @Override
    public void scanLogin() {
        scanLoginService.login();
    }
}
