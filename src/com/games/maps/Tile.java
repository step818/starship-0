package com.games.maps;


public enum Tile {
    NOTHING ('.'),
    WALL('#'),
    PLAYER('@'),
    DOCK('^'),
    PIRATE('p'),
    FRIENDLY('f'),
    RUM('r'),
    GOLD('g'),
    TREASURE('m'),
    KEY('!'),
    DOOR('/'),
    PLUS('+'),
    MAP('*'),
    TILDE('~'),
    SPACE(' '),
    POI('?'),
    CLUE('`'),
    COINTOSS('c'),
    VENDOR('V'),
    LOTTERY('$'),
    BLACKJACK('&'),
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E'),
    F('F'),
    G('G'),
    H('H'),
    I('I'),
    J('J'),
    K('K'),
    L('L'),
    M('M'),
    N('N'),
    O('O'),
    P('P'),
    Q('Q'),
    R('R'),
    S('S'),
    T('T'),
    U('U'),
    //V is for Vendor
    W('W'),
    X('X'),
    Y('Y'),
    Z('Z'),

    //STORE ITEMS
    CORN('['),
    WHISKEY(';'),
    APPLE(','),
    BOW('}'),
    SWORD('|'),
    XP('"'),
    SOAP('='),

    // NUMBERS
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    ZERO('0');


    private char symbol;

    Tile(char symbol){
        this.symbol=symbol;
    }

    public char symbol(){
        return symbol;
    }
}
