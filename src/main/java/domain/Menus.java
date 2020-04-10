package domain;

import java.util.Collections;
import java.util.List;

public class Menus {
    private final List<Menu> menus = MenuRepository.menus();

    public List<Menu> getMenus() {
        return Collections.unmodifiableList(this.menus);
    }

    public Menu of(int menuNumber) {
        Menu menu = this.menus.stream()
                .filter(m -> m.isSelectMenu(menuNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 번호를 입력하였습니다."));
        return menu;
    }
}
