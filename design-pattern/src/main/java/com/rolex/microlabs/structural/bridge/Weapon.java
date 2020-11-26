package com.rolex.microlabs.structural.bridge;

/**
 * @author rolex
 * @since 2020
 */
public interface Weapon {
    void wield();

    void swing();

    void unwield();

    Enchantment getEnchantment();
}