package mwchallenger.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static mwchallenger.BasicMod.makeID;

public class ParryPower extends BasePower {
public static final String Power_ID = makeID(ParryPower.class.getSimpleName());
private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
private static boolean TURN_TYPE = false;

    public ParryPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);
    }
}
