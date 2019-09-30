package com.luo.composite.menuiterator.custom;


/**
 * @author luoxuzheng
 * @create 2019-09-30 11:31
 **/
public class MenuItemTestNew {

    public static void main(String[] args) {
        MenuComponentNew allMenus = new MenuNew("ALL MENUS", "All menus combined");
//

        MenuComponentNew pancakeHouseMenu =
                new MenuNew("PANCAKE HOUSE MENU", "Breakfast");

        pancakeHouseMenu.add(new MenuItemNew(
                "K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs, and toast",
                true,
                2.99));
        pancakeHouseMenu.add(new MenuItemNew(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false,
                2.99));
        pancakeHouseMenu.add(new MenuItemNew(
                "Blueberry Pancakes",
                "Pancakes made with fresh blueberries, and blueberry syrup",
                true,
                3.49));
        pancakeHouseMenu.add(new MenuItemNew(
                "Waffles",
                "Waffles, with your choice of blueberries or strawberries",
                true,
                3.59));

        allMenus.add(pancakeHouseMenu);

        WaitressNew waitress = new WaitressNew(allMenus);

//        waitress.printMenu();

        waitress.printVegetarianMenu();
    }

}
