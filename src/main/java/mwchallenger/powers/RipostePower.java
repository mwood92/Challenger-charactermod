package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.VulnerablePower;

import static mwchallenger.BasicMod.makeID;

public class RipostePower extends BasePower {
    public static final String Power_ID = makeID(RipostePower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;

    private static boolean TURN_TYPE = true;
    public static final String NAME = "Riposte";
    private static final int turns = -1;
    public boolean parry_block_check = false;

    public RipostePower(AbstractCreature owner, AbstractCreature target, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, turns);
        this.amount = amount;
        this.source = target;
    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        AbstractPlayer p = AbstractDungeon.player;
        if (AbstractDungeon.player.currentBlock > 0 & isPlayer) {
            parry_block_check = true;
        }
    }

    @Override
    public int onAttackedToChangeDamage(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        if(p.currentBlock == 0 & parry_block_check){
            this.addToTop(new DamageAction(this.source,new DamageInfo(p,this.amount, DamageInfo.DamageType.NORMAL)));
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
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
