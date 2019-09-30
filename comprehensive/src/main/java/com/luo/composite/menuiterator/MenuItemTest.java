package com.luo.composite.menuiterator;

/**
 * @author luoxuzheng
 * @create 2019-09-30 11:31
 **/
public class MenuItemTest {

    public static void main(String[] args) {
        MenuComponent hotdog = new MenuItem("Hotdog",
                "A hot dog, with saurkraut, relish, onions, topped with cheese",
                false,
                3.05);

        MenuComponent colddog = new MenuItem("colddog",
                "A cold dog, with saurkraut, relish, onions, topped with cheese",
                true,
                3.05);


        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

        allMenus.add(hotdog);
        allMenus.add(colddog);

        Waitress waitress = new Waitress(allMenus);

//        waitress.printMenu();

        waitress.printVegetarianMenu();
    }

}
