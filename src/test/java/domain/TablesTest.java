package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TablesTest {
    @DisplayName("잘못된 테이블 번호 입력 시 예외 출력")
    @Test
    void ofExceptionTest() {
        Tables tables = new Tables();
        Assertions.assertThatThrownBy(() -> {
            tables.of(4);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("테이블 번호 입력시 제대로 된 테이블 반환하는지 테스트")
    @Test
    void ofTest() {
        Tables tables = new Tables();
        Table table = tables.of(3);

        Assertions.assertThat(table.toString()).isEqualTo("3");
    }
}
