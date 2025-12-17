package mwchallenger.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.character.MyCharacter;
import mwchallenger.util.CardStats;

public class SizeUp extends BaseCard {
    public static final String ID = makeID(SizeUp.class.getSimpleName());
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.ENEMY,
            1
    );

    public SizeUp() {
        super(ID, info);

        //setBlock(BLOCK); //Sets the card's damage and how much it changes when upgraded.

    }

    @Override
    public void applyPowers() {
        // Set 'baseBlock' to the current hand size before super.applyPowers()
        // so Dexterity and other buffs are applied to the total.
        int realBaseBlock = this.baseBlock;
        this.baseBlock = AbstractDungeon.player.hand.size() * realBaseBlock;

        super.applyPowers();

        // Reset baseBlock so the calculation doesn't "stack" incorrectly next time
        this.baseBlock = realBaseBlock;
        this.isBlockModified = (this.block != this.baseBlock);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        // 1. Get current hand size
        int handSize = p.hand.size();

        // 2. Calculate total block (hand size * your magic number or base block)
        // If your card's 'baseBlock' is the multiplier:
        int totalBlock = handSize * this.block;

        // 3. Apply the block
        this.addToBot(new GainBlockAction(p, p, totalBlock));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SizeUp();
    }
}
