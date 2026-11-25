package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.PoisonPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import mwchallenger.actions.AlleopathyAction;

import static mwchallenger.BasicMod.makeID;

public class CankerPower extends BasePower{
    public static final String Power_ID = makeID(CankerPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_TYPE = false;
    public static final String NAME = "Canker";
    private static final int turns = -1;
    public boolean parry_block_check = false;

    public CankerPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);
    }

    public void atEndOfTurn(boolean isPlayer) {
        if (AbstractDungeon.player.currentBlock > 0 & isPlayer) {
            parry_block_check = true;
        }
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        AbstractPlayer p = AbstractDungeon.player;
        AbstractCreature target = info.owner;
        if(p.currentBlock == 0 & parry_block_check){
            addToBot(new ApplyPowerAction(p,p,new PoisonPower(p,p,1)));
            addToBot(new AlleopathyAction(p,info,amount));
            addToBot(new RemoveSpecificPowerAction(p,p,Power_ID));
        }
        return super.onAttackedToChangeDamage(info, damageAmount);
    }

    @Override
    public void atEndOfRound() {
        AbstractPlayer p = AbstractDungeon.player;
        this.addToTop(new RemoveSpecificPowerAction(p,p,Power_ID));
        super.atEndOfRound();
    }
}
