package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenusTest {
    @DisplayName("잘못된 메뉴 번호 입력시 예외 출력")
    @Test
    void ofExceptionTest() {
        Menus menus = new Menus();
        Assertions.assertThatThrownBy(() -> {
            menus.of(100);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 번호 입력 시 제대로 된 메뉴 반환 테스트")
    @Test
    void ofTest() {
        Menus menus = new Menus();
        Menu menu = menus.of(1);

        Assertions.assertThat(menu.toString()).isEqualTo("[치킨] 1 - 후라이드 : 16000원");
    }
}
