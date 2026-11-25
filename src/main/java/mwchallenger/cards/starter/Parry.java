package mwchallenger.cards.starter;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import mwchallenger.cards.BaseCard;
import mwchallenger.character.MyCharacter;
import mwchallenger.powers.ParryCardPower;
import mwchallenger.powers.ParryPower;
import mwchallenger.util.CardStats;

public class Parry extends BaseCard {
    public static final String ID = makeID(Parry.class.getSimpleName());
    public static final int MAGICNUMBER = 2;
    public static final int UPG_MAGICNUMBER = 2;
    public static final int BLOCK = 3;
    public static final int UPG_BLOCK = 2;
    private static final CardStats info = new CardStats(
            MyCharacter.Meta.CARD_COLOR,
            CardType.SKILL,
            CardRarity.BASIC,
            CardTarget.SELF,
            0
    );
    public Parry() {
        super(ID, info);
        setBlock(BLOCK,UPG_BLOCK);
        setMagic(MAGICNUMBER,UPG_MAGICNUMBER);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        super.applyPowers();
        final int finalBlock = this.block;
        this.addToBot(new GainBlockAction(p,finalBlock));
        this.addToBot(new ApplyPowerAction(p,p,new ParryPower(p)));
        this.addToBot(new ApplyPowerAction(p,p,new ParryCardPower(p, MAGICNUMBER)));
    }
    @Override
    public AbstractCard makeCopy() { //Optional
        return new Parry();
    }
}
