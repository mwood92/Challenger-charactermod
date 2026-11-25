package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.PoisonPower;

import static mwchallenger.BasicMod.makeID;

public class CambiumPower extends BasePower{
    public static final String Power_ID = makeID(CambiumPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_TYPE = false;
    public static final String NAME = "Cambium";
    private static final int turns = -1;
    public boolean block_check = false;

    public CambiumPower(AbstractPlayer owner,int block_amount,int poison_amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, turns);
        amount =  block_amount;
        amount2 = poison_amount;
    }

    public void atEndOfTurn(boolean isPlayer) {
        if (AbstractDungeon.player.currentBlock > 0 & isPlayer) {
            block_check = true;}
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        if(p.currentBlock == 0 & block_check){
            block_check = false;
            addToBot(new GainBlockAction(p,amount));
            addToBot(new ApplyPowerAction(p,p,new PoisonPower(p,p,amount2),amount2));
        }

        return super.onAttacked(info, damageAmount);
    }
    @Override
    public void atStartOfTurn() {
        block_check = false;
    }
}
