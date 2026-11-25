package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static mwchallenger.BasicMod.makeID;

public class RallyPower extends BasePower {

    public static final String Power_ID = makeID(RallyPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_TYPE = false;
    public static final String NAME = "Rally";
    private static final int turns = -1;
    private static boolean maintain_rally = false;
    private static boolean broke_exactly_rally = false;



    public RallyPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);
        this.amount=amount;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if(isPlayer & this.owner.currentBlock > 0){
            maintain_rally = true;
        }
        super.atEndOfTurn(isPlayer);
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if(damageAmount > this.owner.currentBlock){
            maintain_rally = false;
        } else if (damageAmount == this.owner.currentBlock) {
            broke_exactly_rally = true;
        }

        return super.onAttacked(info, damageAmount);
    }

    @Override
    public void atStartOfTurn() {
        if(maintain_rally & broke_exactly_rally){
            maintain_rally = false;
            broke_exactly_rally = false;
            addToTop(new ApplyPowerAction(this.owner,this.owner, new StrengthPower(this.owner,this.amount)));
        }
        super.atStartOfTurn();
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
