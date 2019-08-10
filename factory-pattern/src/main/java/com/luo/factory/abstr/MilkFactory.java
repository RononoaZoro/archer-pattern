package com.luo.factory.abstr;

        import com.luo.factory.Milk;
        import com.luo.factory.bean.MengNiu;
        import com.luo.factory.bean.TeLunSu;
        import com.luo.factory.bean.YiLi;

/**
 * @author luoxuzheng
 * @create 2019-08-10 11:58
 **/
public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengNiu() {
        return new MengNiu();
    }

    @Override
    public Milk getYiLi() {
        return new YiLi();
    }

    @Override
    public Milk getTeLunSu() {
        return new TeLunSu();
    }
}
