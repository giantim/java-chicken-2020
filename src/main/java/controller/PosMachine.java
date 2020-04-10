package controller;

import domain.Menus;
import domain.Tables;

public interface PosMachine {
    void execute(Tables tables, Menus menus);
}