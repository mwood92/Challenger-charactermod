package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.LoseDexterityPower;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static mwchallenger.BasicMod.makeID;

public class StrengthAndConditioningPower extends BasePower {
    public static final String Power_ID = makeID(StrengthAndConditioningPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static boolean TURN_TYPE = false;
    public static final String NAME = "Strength and Conditioning";
    private static final int turns = -1;

    public StrengthAndConditioningPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);
    }
    @Override
    public int onLoseHp(int damageAmount) {
        // borrowed from TungstenRod
        if (damageAmount > 0) {
            this.flash();
            addToTop(new ApplyPowerAction(owner, owner, new StrengthPower(owner, this.amount)));
            addToTop(new ApplyPowerAction(owner, owner, new LoseStrengthPower(owner, this.amount)));

            addToTop(new ApplyPowerAction(owner, owner, new DexterityPower(owner, this.amount)));
            addToTop(new ApplyPowerAction(owner, owner, new LoseDexterityPower(owner, this.amount)));
        }
        return(damageAmount);
    }
    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
