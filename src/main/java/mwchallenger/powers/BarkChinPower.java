package mwchallenger.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;

import static mwchallenger.BasicMod.makeID;

public class BarkChinPower extends BasePower {

    public static final String Power_ID = makeID(BarkChinPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_TYPE = false;
    public static final String NAME = "Bark Chin";
    private static final int turns = -1;



    public BarkChinPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);
        this.amount=amount;
    }

    @Override
    public int onLoseHp(int damageAmount) {
        // borrowed from TungstenRod
        if (damageAmount > 0) {
            this.flash();
            return damageAmount - this.amount;
        } else {
            return damageAmount;
        }
    }

    @Override
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        return super.onAttackedToChangeDamage(info, damageAmount);
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
