package mwchallenger.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static mwchallenger.BasicMod.makeID;

public class BackpedalPower extends BasePower {

    public static final String Power_ID = makeID(BackpedalPower.class.getSimpleName());
    private static final PowerType TYPE = PowerType.BUFF;
    private static final boolean TURN_TYPE = false;
    public static final String NAME = "Backpedal";
    private static final int turns = -1;
    private static boolean cost_reduced = true;



    public BackpedalPower(AbstractCreature owner, int amount) {
        super(Power_ID, TYPE, TURN_TYPE, owner, amount);
        this.amount=amount;
    }

    @Override
    public void update(int slot) {
        for(AbstractCard c: AbstractDungeon.player.hand.group){
            if(c.type == AbstractCard.CardType.ATTACK){
                c.modifyCostForCombat(-1);
            }
        }
        super.update(slot);
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK && !card.purgeOnUse && this.amount > 0) {
          addToTop(new RemoveSpecificPowerAction(this.owner,this.owner,Power_ID));
        }

    }

    @Override
    public void atEndOfTurn(boolean isPlayer) {
        if(isPlayer){
            addToTop(new RemoveSpecificPowerAction(this.owner,this.owner,Power_ID));
        }
        super.atEndOfTurn(isPlayer);
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }
}
