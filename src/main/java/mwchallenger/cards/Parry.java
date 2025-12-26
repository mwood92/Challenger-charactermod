package mwchallenger.cards;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ParryPower;
import mwchallenger.util.CardStats;

public class Parry extends BaseCard{
    public static final String ID = makeID(Parry.class.getSimpleName());
    public static final int setBlock = 3;
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            0
    );
    public Parry() {
        super(ID, info);
        this.baseBlock = setBlock;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.applyPowers();
        final int finalBlock = this.baseBlock;
        this.addToBot(new GainBlockAction(p,finalBlock));
        this.addToBot(new ApplyPowerAction(p,p,new ParryPower(p,1)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Parry();
    }
}
