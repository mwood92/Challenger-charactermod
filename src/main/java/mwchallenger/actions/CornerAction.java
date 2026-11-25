package mwchallenger.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

public class CornerAction extends AbstractGameAction{
    String msg = "Select a card to place on top of your draw pile.";
    CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
    private AbstractPlayer player;

    public CornerAction(AbstractPlayer player, int amount){
        this.amount = amount;
        this.player = player;
        this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        if (this.duration == this.startDuration) {
            for (AbstractCard c : this.player.drawPile.group) {
                temp.addToTop(c);
            }
            temp.sortAlphabetically(true);

            AbstractDungeon.gridSelectScreen.open(temp, amount, true, msg);
            this.tickDuration();
        } else {
            //AbstractDungeon.gridSelectScreen.selectedCards.clear();
            for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                this.player.drawPile.removeCard(c);
                this.player.drawPile.addToTop(c);
            }
            this.tickDuration();
        }
    }
}
