package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static mwchallenger.BasicMod.makeID;

public class SizeUpPower extends BasePower {
    public static final String Power_ID = makeID(SizeUpPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;

    private static boolean TURN_TYPE = true;
    public static final String NAME = "Riposte";
    private static final int turns = -1;
    public boolean parry_block_check = false;

    public SizeUpPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, turns);
        this.amount = amount;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if (AbstractDungeon.player.currentBlock > 0 & isPlayer) {
            parry_block_check = true;
        }
    }

    @Override
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        if(p.currentBlock == 0 & parry_block_check){
            this.addToTop(new DrawCardAction(source,amount));
            this.addToTop(new RemoveSpecificPowerAction(p,p,ID));
        }
        return super.onAttackedToChangeDamage(info, damageAmount);
    }

    @Override
    public void atEndOfRound() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToTop(new RemoveSpecificPowerAction(p,p,ID));
        super.atEndOfRound();
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + amount + DESCRIPTIONS[1];
    }
}
