package controller;

import java.util.Arrays;

public enum Command {
    ORDER(1, new OrderMachine()),
    PAY(2, new PayMachine()),
    TERMINATE(3, new TerminateMachine());

    private final int commnad;
    private final PosMachine posMachine;

    Command(int command, PosMachine posMachine) {
        this.commnad = command;
        this.posMachine = posMachine;
    }

    public static Command of(int command) {
        return Arrays.stream(values())
                .filter(c -> c.commnad == command)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 명령어를 입력하였습니다."));
    }

    public PosMachine getPosMachine() {
        return this.posMachine;
    }

    public boolean isTerminate() {
        return this == TERMINATE;
    }
}
