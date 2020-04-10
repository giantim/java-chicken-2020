package domain;

import java.util.Collections;
import java.util.List;

public class Tables {
    private final List<Table> tables = TableRepository.tables();

    public Table of(int tableNumber) {
        Table table = tables.stream()
                .filter(t -> t.isSelectTable(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("목록에 없는 테이블을 선택했습니다."));
        return table;
    }

    public List<Table> getTables() {
        return Collections.unmodifiableList(this.tables);
    }
}
