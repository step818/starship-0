package com.games.pieces.test;

import com.games.pieces.Player;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player = new Player('@', Color.yellow, 10, 10);

@Test
    public void testPlayerHasWeapon(){
    player.setInventory("weapon");
    String weapon = player.getInventory().get(0);
    assertEquals(weapon, "weapon");
}
}
