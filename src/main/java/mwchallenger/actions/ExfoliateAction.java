package mwchallenger.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class ExfoliateAction extends AbstractGameAction {
    private AbstractPlayer p;

    public  ExfoliateAction(AbstractPlayer p,int amount) {
        this.p = p;
        this.amount = amount*3;
    }

    @Override
    public void update() {

        int before_block = p.currentBlock;

        p.loseBlock(amount);

        int after_block = p.currentBlock;

        if(before_block > 0) {
            int blocks_removed = before_block - after_block;
            addToBot(new ApplyPowerAction(p,p, new StrengthPower(p,blocks_removed)));
        }
        this.isDone = true;
    }
}
