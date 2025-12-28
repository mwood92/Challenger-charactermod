package mwchallenger.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static mwchallenger.BasicMod.makeID;

public class ProvokePower extends BasePower {
    public static final String Power_ID = makeID(ProvokePower.class.getSimpleName());

    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static final boolean TURN_TYPE = true;
    private static final int turns = 1;

    public ProvokePower(AbstractCreature owner, int amount){
        super(Power_ID,TYPE,TURN_TYPE,owner,turns);
        this.amount = amount;
    }

    @Override
    public float atDamageGive(float damage, DamageInfo.DamageType type){
        return type == DamageInfo.DamageType.NORMAL ? damage + this.amount : damage;
    }
    @Override
    public void updateDescription(){
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
