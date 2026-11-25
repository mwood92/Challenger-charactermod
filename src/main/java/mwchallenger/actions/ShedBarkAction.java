package mwchallenger.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;

public class ShedBarkAction extends AbstractGameAction{
    private AbstractPlayer p;
    private int amount2;

    public ShedBarkAction(AbstractPlayer p, int amount, int amount2) {
        this.p = p;
        this.source = p;
        this.amount = amount;
        this.amount2 = amount2;
        this.duration = Settings.ACTION_DUR_XFAST;
        this.actionType = ActionType.SPECIAL;
    }

    @Override
    public void update() {

        int before_block = p.currentBlock;

        p.loseBlock(amount);

        int after_block = p.currentBlock;

        if(before_block > 0) {
            int blocks_removed = before_block - after_block;
            addToBot(new DamageAllEnemiesAction(p,blocks_removed*amount2, DamageInfo.DamageType.NORMAL,AttackEffect.SHIELD));
        }
        this.isDone = true;
    }
}
