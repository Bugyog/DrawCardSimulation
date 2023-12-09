package org.example.card;

import lombok.Getter;

import static org.example.card.CardType.WEAPON;

@Getter
class Weapon extends AbstractCard {

    @Override
    public boolean isWeapon() {
        return true;
    }

    @Override
    public CardType getType() {
        return WEAPON;
    }
}
