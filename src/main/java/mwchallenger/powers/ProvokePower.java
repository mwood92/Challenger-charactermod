package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static mwchallenger.BasicMod.makeID;

public class ProvokePower extends BasePower {
    public static final String Power_ID = makeID(ProvokePower.class.getSimpleName());

    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_TYPE = true;
    private static boolean justApplied = true;
    private static int TURNS = 1;

    public ProvokePower(AbstractCreature owner, int amount){
        super(Power_ID,TYPE,TURN_TYPE,owner,amount);
        this.amount = amount;
        this.justApplied = justApplied;
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type){
        return type == DamageInfo.DamageType.NORMAL ? damage + amount : damage;
    }

    public void atEndOfRound() {
        this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, Power_ID));
    }

    @Override
    public void updateDescription(){
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}
