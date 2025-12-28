package mwchallenger.cards;

import basemod.helpers.dynamicvariables.MagicNumberVariable;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ParryPower;
import mwchallenger.util.CardStats;

public class SizeUp extends BaseCard {
    public static final String ID = makeID(SizeUp.class.getSimpleName());
    public static final int setBlock = 0;
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.COMMON,
            CardTarget.SELF,
            1
    );

    public SizeUp() {
        super(ID, info);

        setBlock(setBlock); //Sets the card's damage and how much it changes when upgraded.
        setMagic(2);

    }



    @Override
    public void applyPowers() {

        this.baseBlock = AbstractDungeon.player.hand.size()+1;
        super.applyPowers();

    }


    @Override
    public void use(AbstractPlayer p,AbstractMonster m) {
        addToTop(new DrawCardAction(magicNumber));
        this.addToBot(new GainBlockAction(p, this.block));
        this.addToBot(new ApplyPowerAction(p,p,new ParryPower(p)));
    }

    @Override
    public AbstractCard makeCopy() { //Optional
        return new SizeUp();
    }
}
