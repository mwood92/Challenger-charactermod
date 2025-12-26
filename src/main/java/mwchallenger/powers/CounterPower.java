package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static mwchallenger.BasicMod.makeID;

public class CounterPower extends BasePower{
    public static final String Power_ID = makeID(CounterPower.class.getSimpleName());
    private static final boolean TURN_TYPE = true;
    private static final AbstractPower.PowerType TYPE = PowerType.BUFF;
    private static final int turns = 1;

    public CounterPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, turns);
    }
}
