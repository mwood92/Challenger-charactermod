package mwchallenger.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class BackpedalAction extends AbstractGameAction {
    String msg = "Select a card to place on top of your draw pile.";
    CardGroup temp = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
    private final AbstractPlayer player;

    public BackpedalAction(AbstractPlayer player){
        this.player = player;
        this.duration = this.startDuration = Settings.ACTION_DUR_FAST;
    }

    @Override
    public void update() {
        if (this.duration == this.startDuration) {

            // come back and fix edge cases.

            AbstractDungeon.handCardSelectScreen.open(msg, 1, true);
            this.tickDuration();
        } else {
            //AbstractDungeon.gridSelectScreen.selectedCards.clear();
            for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                this.player.hand.removeCard(c);
                this.player.drawPile.addToTop(c);
            }
            this.tickDuration();
        }
    }
}
