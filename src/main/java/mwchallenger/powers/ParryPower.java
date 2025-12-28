package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static mwchallenger.BasicMod.makeID;

public class ParryPower extends BasePower {
    public static final String Power_ID = makeID(ParryPower.class.getSimpleName());
    private static final AbstractPower.PowerType TYPE = AbstractPower.PowerType.BUFF;
    private static boolean TURN_TYPE = true;
    public static final String NAME = "Parry";
    private static final int turns = -1;
    public boolean parry_block_check = false;

    public ParryPower(AbstractCreature owner) {
        super(Power_ID, TYPE, TURN_TYPE, owner, turns);
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (AbstractDungeon.player.currentBlock > 0 & isPlayer) {
            parry_block_check = true;}
        }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        if(p.currentBlock == 0 & parry_block_check){
            this.addToBot(new RemoveSpecificPowerAction(p, p,Power_ID));
            this.addToBot(new ApplyPowerAction(p, p,new CounterPower(p,1)));

        }

        return super.onAttacked(info, damageAmount);
    }
    @Override
    public void atStartOfTurn() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToBot(new RemoveSpecificPowerAction(p, p,Power_ID));
        super.atStartOfTurn();
    }
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + DESCRIPTIONS[1];
    }
}
